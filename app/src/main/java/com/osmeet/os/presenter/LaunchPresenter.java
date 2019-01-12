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
        App.setMyInfo(null);
    }

    @Override
    public long delayMillis() {
        if (App.SETTING.isOnce()) {
            return 1000;
        } else if (App.SETTING.isAd()) {
            return 500;
        } else {
            return 200;
        }
    }


    @Override
    public void go() {
        if (App.SETTING.isOnce()) {
            goGuide();// 前往引导页。
        } else if (App.SETTING.isAd()) {
            goAd();// 前往广告。
        } else {
            goLogin();// 前往登录。
        }
        finish();
        mActivity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);// 淡入淡出。
    }
}
