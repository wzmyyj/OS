package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.application.SettingManager;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.SettingContract;
import com.osmeet.os.view.activity.MainActivity;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 */

public class SettingPresenter extends BasePresenter<SettingContract.IView> implements SettingContract.IPresenter {

    public SettingPresenter(Activity activity, SettingContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void logout() {
        App.getInstance().clearToken();
        App.finish(MainActivity.class);
        toast("登出成功！");
        goLogin();
        finish();
        mActivity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    @Override
    public SettingManager getSetting() {
        return App.getInstance().getSetting();
    }
}
