package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.InviteFriendsContract;
import com.osmeet.os.presenter.InviteFriendsPresenter;

public class InviteFriendsActivity extends BaseActivity<InviteFriendsContract.IPresenter> implements InviteFriendsContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new InviteFriendsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invite_friends;
    }

}
