package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.AboutOsContract;

import top.wzmyyj.wzm_sdk.utils.PackageUtil;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class AboutOsPresenter extends BasePresenter<AboutOsContract.IView> implements AboutOsContract.IPresenter {

    public AboutOsPresenter(Activity activity, AboutOsContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public String getVersion() {
        return PackageUtil.getVersionName(getContext());
    }
}
