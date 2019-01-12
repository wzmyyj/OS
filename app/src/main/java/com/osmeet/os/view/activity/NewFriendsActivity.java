package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.NewFriendsContract;
import com.osmeet.os.presenter.NewFriendsPresenter;

public class NewFriendsActivity extends BaseActivity<NewFriendsContract.IPresenter> implements NewFriendsContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new NewFriendsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_friends;
    }

}

