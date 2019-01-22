package com.osmeet.os.app.application;


import android.support.annotation.NonNull;

import com.igexin.sdk.PushManager;
import com.kongzue.dialog.v2.DialogSettings;
import com.osmeet.os.BuildConfig;
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

/**
 * Created by yyj on 2018/10/27. email: 2209011667@qq.com
 * 应用的Application，别忘了在AndroidManifest上设置进去。
 * 代码尽量没有警告！！！
 */

public class App extends BaseApplication {

    private static App app;

    private UserManager userManager;
    private SettingManager settingManager;

    @Override
    public void onCreate() {
        super.onCreate();
        L.setTAG("OSMeet");
//        L.setDebug(false);
        L.setDebug(true);
        ReOk.init(Urls.OS_BASE);
        app = this;
        userManager = UserManager.getInstance(this);
        settingManager = SettingManager.getInstance(this);

        setDialog();
        GP.init(BuildConfig.APPLICATION_ID + ".FileProvider", "/OsMeet/images");


        PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), PushIntentService.class);
    }


    private void setDialog() {
        DialogSettings.style = DialogSettings.STYLE_KONGZUE;
        DialogSettings.tip_theme = DialogSettings.THEME_DARK;         //设置提示框主题
        DialogSettings.dialog_theme = DialogSettings.THEME_LIGHT;       //设置对话框主题
        DialogSettings.use_blur = true;
    }

    public static App getInstance() {
        return app;
    }

    public void setToken(@NonNull Token token) {
        if (token.getToken() != null && token.getRefreshToken() != null) {
            userManager.setToken(token);
        }
    }

    public void clearToken() {
        if (userManager.getMyInfo() != null) {
            PushManager.getInstance().unBindAlias(this, userManager.getMyInfo().getId(), false);
        }
        userManager.clearToken();
    }

    public void setMyInfo(User user) {
        userManager.setMyInfo(user);
        if (user != null)
            PushManager.getInstance().bindAlias(this, user.getId());
    }

    public User getMyInfo() {
        return userManager.getMyInfo();
    }

    public void setComplete(boolean isComplete) {
        userManager.setComplete(isComplete);
    }

    public boolean isComplete() {
        return userManager.isComplete();
    }

    public String getVersion() {
        return "Android_" + PackageUtil.getVersionName(this);
    }

    public Token getToken() {
        return userManager.getToken();
    }

    public SettingManager getSetting() {
        return settingManager;
    }

}
