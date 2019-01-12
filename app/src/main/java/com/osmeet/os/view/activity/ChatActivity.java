package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.presenter.ChatPresenter;

public class ChatActivity extends BaseActivity<ChatContract.IPresenter> implements ChatContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ChatPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

}

