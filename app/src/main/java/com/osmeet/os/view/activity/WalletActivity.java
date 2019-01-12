package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.WalletContract;
import com.osmeet.os.presenter.WalletPresenter;

public class WalletActivity extends BaseActivity<WalletContract.IPresenter> implements WalletContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new WalletPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

}

