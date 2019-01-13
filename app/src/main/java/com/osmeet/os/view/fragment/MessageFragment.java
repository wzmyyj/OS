package com.osmeet.os.view.fragment;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.MessageContract;
import com.osmeet.os.presenter.MessagePresenter;
import com.osmeet.os.view.panel.MessageNeScrollPanel;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yyj on 2018/12/19. email: 2209011667@qq.com
 */

public class MessageFragment extends BaseFragment<MessageContract.IPresenter> implements MessageContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MessagePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

    MessageNeScrollPanel messageNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(messageNeScrollPanel = new MessageNeScrollPanel(context, mPresenter));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        setTopBar();
        fl_panel.addView(getPanelView(0));
        fl_panel.addView(mTopBar);

        messageNeScrollPanel.bingView("v", ll_tap_bar);
    }

    private View mTopBar;
    private LinearLayout ll_tap_bar;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_message_top_bar, null);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        mTopBar.findViewById(R.id.img_search).setOnClickListener(v -> search());
        mTopBar.findViewById(R.id.img_scan).setOnClickListener(v -> scan());
    }

    private void search() {

    }

    private void scan() {
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMatchTeamList();
        mPresenter.loadMatchInviteList();
    }

    @Override
    public void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList) {
        messageNeScrollPanel.matchTeamList(matchTeamList);
    }

    @Override
    public void showMatchInviteList(@NonNull List<MatchInvite> matchInviteList) {
        messageNeScrollPanel.matchInviteList(matchInviteList);
    }
}
