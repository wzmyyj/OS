package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.FriendsContract;
import com.osmeet.os.presenter.FriendsPresenter;

public class FriendsActivity extends BaseActivity<FriendsContract.IPresenter> implements FriendsContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new FriendsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_friends;
    }

}

