package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ProtocolContract;
import com.osmeet.os.presenter.ProtocolPresenter;

public class ProtocolActivity extends BaseActivity<ProtocolContract.IPresenter> implements ProtocolContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ProtocolPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_protocol;
    }

}

