package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.InviteListContract;
import com.osmeet.os.presenter.InviteListPresenter;
import com.osmeet.os.view.panel.InviteListRecyclerPanel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class InviteListActivity extends BaseActivity<InviteListContract.IPresenter> implements InviteListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new InviteListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invite_list;
    }

    InviteListRecyclerPanel inviteListRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(inviteListRecyclerPanel = new InviteListRecyclerPanel(context, mPresenter));
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    public void showMatchInviteList(@NonNull List<MatchInvite> matchInviteList) {
        inviteListRecyclerPanel.matchInviteList(matchInviteList);
    }
}
