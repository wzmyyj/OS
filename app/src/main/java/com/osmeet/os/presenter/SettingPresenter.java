package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.application.SettingManager;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.utils.GlideCacheUtil;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.SettingContract;

import java.util.List;

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
        App.getInstance().finishAll();
        toast(getContext().getString(R.string.logout_success));
        goLogin();
        finish(mView.FINISH_FADE_IN_OUT);
    }

    @Override
    public SettingManager getSetting() {
        return App.getInstance().getSetting();
    }

    @Override
    public void clearCache() {
        GlideCacheUtil.clearAll(getContext());
    }

    @Override
    public String getCacheSize() {
        return GlideCacheUtil.getCacheSize(getContext());
    }

    @Override
    public void changeLanguage(int i) {

    }

    @Override
    public String getLanguage() {
        return null;
    }

    @NonNull
    @Override
    public List<String> getLanguageList() {
        return null;
    }

    @Override
    public String getAccount() {
        User user = App.getInstance().getMyInfo();
        if (user != null && user.getPhone() != null) {
            return user.getPhone();
        }
        return "12345";
    }
}
