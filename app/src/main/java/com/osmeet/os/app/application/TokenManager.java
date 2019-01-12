package com.osmeet.os.app.application;

import android.app.Application;

import com.osmeet.os.app.bean.Token;

import top.wzmyyj.wzm_sdk.tools.P;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class TokenManager {

    private TokenManager() {

    }

    private static class Holder {
        private static TokenManager manager = new TokenManager();
    }

    public static TokenManager getInstance(Application context) {
        return Holder.manager.setContext(context);
    }

    private Application context;

    private TokenManager setContext(Application context) {
        this.context = context;
        return this;
    }

    public void setToken(Token token) {
        if (token == null) return;
        P.create(context).putString("Token", token.getToken())
                .putString("RefreshToken", token.getRefreshToken())
                .commit();
    }

    public void clearToken() {
        P.create(context).putString("Token", null)
                .putString("RefreshToken", null)
                .commit();
    }

    public String getToken() {
        return P.create(context).getString("Token", "");
    }

    public String getRefreshToken() {
        return P.create(context).getString("RefreshToken", "");
    }


//    static void setIsComplete(Context context, boolean isComplete) {
//        P.create(context).putBoolean("isComplete", isComplete)
//                .commit();
//    }

//    static boolean isComplete(Context context) {
//        return P.create(context).getBoolean("isComplete", false);
//    }


}
