package com.osmeet.os.app.application;


import android.support.annotation.NonNull;

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

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
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
        rcManager = RcManager.getInstance(this);

        setDialog();
        GP.init("provider.GPFileProvider", "/OsMeet/images");

        ZXingLibrary.initDisplayOpinion(this);
        ZoomMediaLoader.getInstance().init(new GlideIZoomImageLoader());

        RongIM.init(this.getApplicationContext());
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
        rcManager.setmRcToken(rcToken);
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


    public void connectRc() {
        RcToken mRcToken = getRcToken();
        if (mRcToken == null) return;
        RongIM.connect(mRcToken.getToken(), new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {

            }

            @Override
            public void onSuccess(String userId) {
                L.d("Success userId= " + userId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                L.e("ErrorCode=" + errorCode);
            }
        });
    }
}
