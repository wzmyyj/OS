package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.view.adapter.ivd.StoryIVD;
import com.osmeet.os.view.panel.simple.UserInfoPanel;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class UserInfoRecyclerPanel extends StoryRecyclerPanel<UserInfoContract.IPresenter> {
    public UserInfoRecyclerPanel(Context context, UserInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }


    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
    }

    @Override
    public void update() {
        mPresenter.loadUserInfo();
        mPresenter.loadStoryList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadStoryList(nextPageNum());
    }

    private UserInfoPanel userInfoPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(userInfoPanel = new UserInfoPanel(context));
    }


//    @Override
//    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//        super.onItemClick(view, holder, position);
//
//    }


    public void setUser(@NonNull User user) {
        userInfoPanel.setUser(user);
    }


    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = getPanelView(0);

    }

    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }


}
