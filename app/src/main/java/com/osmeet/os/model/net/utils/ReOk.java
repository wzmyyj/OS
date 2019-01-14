package com.osmeet.os.model.net.utils;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Token;
import com.osmeet.os.model.net.service.UserService;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.gson.Gson2ConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import top.wzmyyj.wzm_sdk.tools.L;

/**
 * Created by yyj on 2018/07/31. email: 2209011667@qq.com
 */

public class ReOk {
    private static String BASE_URL = null;

    public static void init(@NonNull String base_url) {
        BASE_URL = base_url;
    }

    public static Retrofit bind() {
        if (BASE_URL == null)
            throw new IllegalStateException("please init BASE_URL");
        return bind(BASE_URL, new Gson());
    }


    public static Retrofit bind(String base_url) {
        return bind(base_url, new Gson());
    }

    public static Retrofit bind(Gson gson) {
        if (BASE_URL == null)
            throw new IllegalStateException("please init BASE_URL");
        return bind(BASE_URL, gson);
    }

    // 直接调用这个方法不保存BaseURL。
    public static Retrofit bind(@NonNull String base_url, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(Gson2ConverterFactory.create(gson))
                .client(getClient())
                .build();
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)// 设置超时时间。
                .readTimeout(10, TimeUnit.SECONDS)// 设置读取超时时间。
                .writeTimeout(10, TimeUnit.SECONDS)// 设置写入超时时间。
                .addInterceptor(new HttpLoggingInterceptor(L::d).setLevel(HttpLoggingInterceptor.Level.BODY))// 拦截日志。
                .addInterceptor(ReOk::intercept)
                .build();
    }

    private static Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();
        request.addHeader("Authorization", App.getInstance().getToken().getBearerToken())
                .addHeader("version", App.getInstance().getVersion()); //添加默认的Token请求头
        Response proceed = chain.proceed(request.build());
        //如果token过期 再去重新请求token 然后设置token的请求头 重新发起请求 用户无感
        L.d("intercept:" + proceed.code());
        if (isTokenExpired(proceed)) {
            String newHeaderToken = getNewToken();
            //使用新的Token，创建新的请求
            if (newHeaderToken == null) throw new IllegalStateException("newHeaderToken is null");
            Request newRequest = chain.request().newBuilder()
                    .header("Authorization", newHeaderToken)
                    .build();
            return chain.proceed(newRequest);
        }
        return proceed;
    }

    private static synchronized String getNewToken() throws IOException {
        if (BASE_URL == null)
            throw new IllegalStateException("please init BASE_URL");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(Gson2ConverterFactory.create())
                .build();
        retrofit2.Response<Box<Token>> response = retrofit.create(UserService.class)
                .refreshToken(App.getInstance().getToken().getRefreshToken())
                .execute();
        Box<Token> box = response.body();
        if (box == null) throw new IllegalStateException("refreshToken response body is null");
        Token token = box.getData();
        String newToken = null;
        if (token != null) {
            App.getInstance().setToken(token);
            L.d("intercept new token:" + token.getBearerToken());
            newToken = token.getBearerToken();
        }
        return newToken;
    }


    private static boolean isTokenExpired(Response response) {
        return response.code() == 403;
    }
}
