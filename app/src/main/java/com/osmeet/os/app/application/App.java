package com.osmeet.os.app.application;


import android.support.annotation.NonNull;

import com.igexin.sdk.PushManager;
import com.osmeet.os.app.bean.Token;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.base.application.BaseApplication;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.service.PushIntentService;
import com.osmeet.os.service.PushService;

import top.wzmyyj.wzm_sdk.tools.L;
import top.wzmyyj.wzm_sdk.utils.PackageUtil;
import top.wzmyyj.wzm_sdk.utils.StatusBarUtil;

/**
 * Created by yyj on 2018/10/27. email: 2209011667@qq.com
 * 应用的Application，别忘了在AndroidManifest上设置进去。
 * 代码尽量没有警告！！！
 */

public class App extends BaseApplication {


    public static String TOKEN = null;
    public static String REFRESHTOKEN = null;

    // Bearer
    public static String BEARER_TOKEN = null;

    public static String VERSION = null;

    public static boolean ISCOMPLETE = false;

    public static User MyInfo;

    private static TokenManager tokenManager;
    public static SettingManager SETTING;


    @Override
    public void onCreate() {
        super.onCreate();
        StatusBarUtil.initStatusBarHeight(this);
        L.setTAG("OSMeet");
//        L.setDebug(false);
        L.setDebug(true);
        ReOk.init(Urls.OS_BASE);
        SETTING = SettingManager.getInstance(this);
        tokenManager = TokenManager.getInstance(this);
        VERSION = "Android_" + PackageUtil.getVersionName(this);
        TOKEN = tokenManager.getToken();
        REFRESHTOKEN = tokenManager.getRefreshToken();
        BEARER_TOKEN = "Bearer " + TOKEN;


        GP.init(PackageUtil.getPackageName(this) + ".FileProvider", "/OsMeet/images");


        PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), PushIntentService.class);

    }


    public static void setToken(@NonNull Token token) {
        if (token.getToken() != null && token.getRefreshToken() != null) {
            TOKEN = token.getToken();
            REFRESHTOKEN = token.getRefreshToken();
            BEARER_TOKEN = "Bearer " + TOKEN;
            tokenManager.setToken(token);
        }
    }

    public static void clearToken() {
        App.TOKEN = null;
        App.REFRESHTOKEN = null;
        App.REFRESHTOKEN = null;
        tokenManager.clearToken();
        MyInfo = null;
    }

    public static void setMyInfo(User user) {
        MyInfo = user;
    }

    public static void setComplete(boolean isComplete) {
        ISCOMPLETE = isComplete;
    }

}
