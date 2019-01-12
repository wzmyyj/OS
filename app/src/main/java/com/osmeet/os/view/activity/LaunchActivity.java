package com.osmeet.os.view.activity;

import android.os.Bundle;
import android.os.Handler;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.LaunchContract;
import com.osmeet.os.presenter.LaunchPresenter;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 启动页面（欢迎页面）。
 */

public class LaunchActivity extends BaseActivity<LaunchContract.IPresenter> implements LaunchContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new LaunchPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_launch;
    }


    @Override
    protected void initSome(Bundle savedInstanceState) {
        super.initSome(savedInstanceState);
        mPresenter.checkPermission();
        mPresenter.init();
    }


    @Override
    protected void initEvent() {
        super.initEvent();
        long delayMillis = mPresenter.delayMillis();
        mHandler.postDelayed(mRunnable, delayMillis);
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = () -> mPresenter.go();

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mRunnable);
    }
}

