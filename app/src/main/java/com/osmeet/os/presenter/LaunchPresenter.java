package com.osmeet.os.presenter;

import android.app.Activity;

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
    }

    @Override
    public long delayMillis() {
        if (App.getInstance().getSetting().isOnce()) {
            return 1000;
        } else if (App.getInstance().getSetting().isAd()) {
            return 500;
        } else {
            return 300;
        }
    }


    @Override
    public void go() {
        if (App.getInstance().getSetting().isOnce()) {
            goGuide();// 前往引导页。
        } else if (App.getInstance().getSetting().isAd()) {
            goAd();// 前往广告。
        } else {
            goLogin();// 前往登录。
        }
        finish(mView.FINISH_FADE_IN_OUT);
    }
}
