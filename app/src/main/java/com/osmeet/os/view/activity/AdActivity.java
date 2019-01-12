package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.AdContract;
import com.osmeet.os.presenter.AdPresenter;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告页面。
 */

public class AdActivity extends BaseActivity<AdContract.IPresenter> implements AdContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new AdPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ad;
    }

    @Override
    protected void initView() {
        super.initView();
        setSwipeBackEnable(false);
    }
}

