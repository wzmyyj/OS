package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ScanContract;
import com.osmeet.os.presenter.ScanPresenter;

public class ScanActivity extends BaseActivity<ScanContract.IPresenter> implements ScanContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ScanPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan;
    }

}

