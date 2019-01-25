package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Friend;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.NewFriendListContract;
import com.osmeet.os.presenter.NewFriendsPresenter;
import com.osmeet.os.view.panel.NewFriendsRecyclerPanel;

import java.util.List;

import butterknife.BindView;

public class NewFriendsActivity extends BaseActivity<NewFriendListContract.IPresenter> implements NewFriendListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new NewFriendsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_friends;
    }


    NewFriendsRecyclerPanel newFriendsRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                newFriendsRecyclerPanel = new NewFriendsRecyclerPanel(context, mPresenter)
        );
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadNewFriendList(0);
    }

    @Override
    public void showNewFriendList(@NonNull List<Friend> friendList, int pageNum) {
        newFriendsRecyclerPanel.setDataList(friendList, pageNum);
    }

    @Override
    public void showAgreeNewFriend(@NonNull String userId) {
        newFriendsRecyclerPanel.agreeSuccess(userId);
    }
}

