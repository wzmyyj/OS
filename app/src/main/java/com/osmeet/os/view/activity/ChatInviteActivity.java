package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ChatInviteContract;
import com.osmeet.os.presenter.ChatInvitePresenter;

public class ChatInviteActivity extends BaseActivity<ChatInviteContract.IPresenter> implements ChatInviteContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ChatInvitePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat_invite;
    }

}

