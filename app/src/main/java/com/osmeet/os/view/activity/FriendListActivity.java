package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.event.FriendListChangeEvent;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.FriendListContract;
import com.osmeet.os.presenter.FriendListPresenter;
import com.osmeet.os.view.panel.FriendListRecyclerPanel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

public class FriendListActivity extends BaseActivity<FriendListContract.IPresenter> implements FriendListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new FriendListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_friend_list;
    }


    FriendListRecyclerPanel friendListRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                friendListRecyclerPanel = new FriendListRecyclerPanel(context, mPresenter)
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
        mPresenter.loadFriendList(0);
        mPresenter.loadNewFriendNum();
    }


    @Override
    public void showFriendList(@NonNull List<User> userList, int pageNum) {
        friendListRecyclerPanel.setDataList(userList, pageNum);
    }

    @Override
    public void showNewFriendNum(int num) {
        friendListRecyclerPanel.setNewFriendNum(num);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe
    public void onEvent(FriendListChangeEvent event) {
        if (event.isChange()) {
            mPresenter.loadFriendList(0);
            mPresenter.loadNewFriendNum();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

