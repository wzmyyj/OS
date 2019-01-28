package com.osmeet.os.presenter;

import android.app.Activity;
import android.os.Handler;

import com.osmeet.os.app.application.App;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.LaunchContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LaunchPresenter extends BasePresenter<LaunchContract.IView> implements LaunchContract.IPresenter {

    public LaunchPresenter(Activity activity, LaunchContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void checkPermission() {

    }

    @Override
    public void init() {
        App.getInstance().setMyInfo(null);
        App.getInstance().connectRc();
    }


    private long delayMillis() {
        return 1000;
    }

    private void goTo() {
        if (App.getInstance().getSetting().isOnce()) {
            goGuide();// 前往引导页。
        } else if (App.getInstance().getSetting().isAd()) {
            goAd();// 前往广告。
        } else {
            goLogin();// 前往登录。
        }
        finish(mView.FINISH_FADE_IN_OUT);
    }

    @Override
    public void go() {
        new Handler().postDelayed(this::goTo, delayMillis());
    }


}
