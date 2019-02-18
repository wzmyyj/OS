package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.AboutOsContract;
import com.osmeet.os.presenter.AboutOsPresenter;

public class AboutOsActivity extends BaseActivity<AboutOsContract.IPresenter> implements AboutOsContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new AboutOsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_os;
    }

}

