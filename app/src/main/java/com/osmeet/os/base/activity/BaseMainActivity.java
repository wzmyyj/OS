package com.osmeet.os.base.activity;

import android.os.Bundle;

import com.osmeet.os.base.application.BaseApplication;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import top.wzmyyj.wzm_sdk.activity.PagerFragmentActivity;
import top.wzmyyj.wzm_sdk.tools.T;
import top.wzmyyj.wzm_sdk.utils.OrientationUtil;
import top.wzmyyj.wzm_sdk.utils.StatusBarUtil;

/**
 * Created by yyj on 2018/06/24. email: 2209011667@qq.com
 * 有Tab的Activity。
 */

public abstract class BaseMainActivity<P extends IBasePresenter> extends PagerFragmentActivity implements IBaseView {
    protected P mPresenter;

    @Override
    protected void initSome(Bundle savedInstanceState) {
        BaseApplication.getInstance().addActivity(this);
        initPresenter();
        checkPresenterIsNull();
        super.initSome(savedInstanceState);
        StatusBarUtil.initStatusBar(activity, true, true, true);
    }

    protected abstract void initPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }


    @Override
    protected void onResume() {
        // 强制设为竖屏。
        OrientationUtil.portrait(this);
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        mPresenter = null;
        BaseApplication.getInstance().removeActivity(this);
    }

    @Override
    public void showToast(String msg) {
        T.s(msg);
    }

    @Override
    public void showStart(int what, Object... objects) {

    }

    @Override
    public void showProgress(int what, int progress, Object... objects) {

    }

    @Override
    public void showCancel(int what, int progress, Object... objects) {

    }

    @Override
    public void showFail(int what, Object... objects) {
        if (what == this.DEFAULT) {
            showToast((String) objects[0]);
        }
    }

    @Override
    public void showSuccess(int what, Object... objects) {

    }

    @Override
    public void showFinish(int what, Object... objects) {

    }

    @Override
    public void showFinishActivity() {
        finish();
    }
}
