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

import java.util.ArrayList;
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
        App.getInstance().getLanguageManager().setLanguage(i);
        goLaunch();
        finish(mView.FINISH_FADE_IN_OUT);
        App.getInstance().finishAll();
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(0);
    }

    @Override
    public String getLanguage() {
        int i = App.getInstance().getLanguageManager().getLanguage();
        if (i >= getLanguageList().size()) i = 0;
        return getLanguageList().get(i);
    }


    @NonNull
    @Override
    public List<String> getLanguageList() {
        List<String> strList = new ArrayList<>();
        strList.add(getContext().getString(R.string.by_system));
        strList.add("简体中文");
        strList.add("English");
        return strList;
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
