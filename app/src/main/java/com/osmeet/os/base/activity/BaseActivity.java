package com.osmeet.os.base.activity;

import android.os.Bundle;

import com.osmeet.os.base.application.BaseApplication;
import com.osmeet.os.base.contract.BaseContract;

import butterknife.ButterKnife;
import top.wzmyyj.wzm_sdk.activity.PanelActivity;
import top.wzmyyj.wzm_sdk.tools.T;
import top.wzmyyj.wzm_sdk.utils.ActivityUtil;
import top.wzmyyj.wzm_sdk.utils.StatusBarUtil;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public abstract class BaseActivity<P extends BaseContract.IPresenter> extends PanelActivity implements BaseContract.IView {

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

    protected abstract int getLayoutId();

    @Override
    protected void setRootView() {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onResume() {
        // 强制设为竖屏。
        ActivityUtil.portrait(this);
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
        mPresenter = null;
        BaseApplication.getInstance().removeActivity(this);
    }

    @Override
    public void showToast(String msg) {
        T.s(msg);
    }


    @Override
    public void showFinishActivity(int how) {
        finish();
        if(how==this.FINISH_FADE_IN_OUT){
            this.overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        }
    }
}
