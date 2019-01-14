package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.GuideContract;
import com.osmeet.os.presenter.GuidePresenter;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 引导页面。
 */

public class GuideActivity extends BaseActivity<GuideContract.IPresenter> implements GuideContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new GuidePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected boolean swipeBackEnable() {
        return false;
    }

    @Override
    protected void initData() {
        super.initData();
        App.getInstance().getSetting().setIsOnce(false);
    }
}

