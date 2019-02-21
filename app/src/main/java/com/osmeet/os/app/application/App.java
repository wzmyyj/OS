package com.osmeet.os.app.application;


import android.support.annotation.NonNull;

import com.amap.api.location.DPoint;
import com.igexin.sdk.PushManager;
import com.kongzue.dialog.v2.DialogSettings;
import com.osmeet.os.app.bean.RcToken;
import com.osmeet.os.app.bean.Token;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.other.GlideIZoomImageLoader;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.assembly.service.PushIntentService;
import com.osmeet.os.assembly.service.PushService;
import com.osmeet.os.base.application.BaseApplication;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.Urls;
import com.previewlibrary.ZoomMediaLoader;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

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
    private RcManager rcManager;
    private LanguageManager languageManager;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        L.init("OSMeet", true);
        ReOk.init(Urls.OS_BASE);

        languageManager=LanguageManager.getInstance();
        languageManager.init(this);
        userManager = UserManager.getInstance();
        userManager.init(this);
        settingManager = SettingManager.getInstance();
        settingManager.init(this);
        rcManager = RcManager.getInstance();
        rcManager.init(this);


        setDialog();
        GP.init("provider.GPFileProvider", "/OsMeet/images");

        ZXingLibrary.initDisplayOpinion(this);
        ZoomMediaLoader.getInstance().init(new GlideIZoomImageLoader());

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

    public void setRcToken(RcToken rcToken) {
        rcManager.setRcToken(rcToken);
    }

    public RcToken getRcToken() {
        return rcManager.getRcToken();
    }


    public void clearToken() {
        if (userManager.getMyInfo() != null) {
            PushManager.getInstance().unBindAlias(this, userManager.getMyInfo().getId(), false);
        }
        userManager.clearToken();
        rcManager.clearToken();
    }

    public void setMyInfo(User user) {
        userManager.setMyInfo(user);
        if (user != null)
            PushManager.getInstance().bindAlias(this, user.getId());
    }

    public void refreshRcUser(User user) {
        rcManager.refreshUserInfo(user);
    }

    public User getMyInfo() {
        return userManager.getMyInfo();
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


    public void connectRc() {
        rcManager.connect();
    }


    private DPoint myDPoint;

    public DPoint getMyDPoint() {
        return myDPoint;
    }

    public void setMyDPoint(DPoint myDPoint) {
        this.myDPoint = myDPoint;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }
}
