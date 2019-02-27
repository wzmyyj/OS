package com.osmeet.os.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.presenter.UserInfoPresenter;
import com.osmeet.os.view.panel.UserInfoRecyclerPanel;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class UserInfoFragment extends BaseFragment<UserInfoContract.IPresenter> implements UserInfoContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new UserInfoPresenter(this, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

    public static UserInfoFragment newInstance(String userId) {
        UserInfoFragment userInfoFragment = new UserInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("userId", userId);
        userInfoFragment.setArguments(bundle);
        return userInfoFragment;
    }

    public void changeData(String userId) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", userId);
        this.setArguments(bundle);
        if (mVRoot != null && mPresenter != null) {
            initData();
        }

    }


    UserInfoRecyclerPanel userInfoRecyclerPanel;


    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(userInfoRecyclerPanel = new UserInfoRecyclerPanel(context, mPresenter).inFragment(this));
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
        setArg();
        mPresenter.loadUserInfo();
        mPresenter.loadStoryList(0);

    }

    private void setArg() {
        if (getArguments() != null) {
            String userId = getArguments().getString("userId");
            if (userId == null) return;
            mPresenter.setUserId(userId);
        }
    }


    @Override
    public void showUserInfo(@NonNull User user) {
        userInfoRecyclerPanel.setUser(user);
    }


    @Override
    public void showStoryList(@NonNull List<Story> storyList, int pageNum) {
        userInfoRecyclerPanel.setDataList(storyList, pageNum);
    }
}