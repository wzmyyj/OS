package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.AccountContract;
import com.osmeet.os.presenter.AccountPresenter;

public class AccountActivity extends BaseActivity<AccountContract.IPresenter> implements AccountContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new AccountPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }

}

