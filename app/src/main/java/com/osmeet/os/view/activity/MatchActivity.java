package com.osmeet.os.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.MatchContract;
import com.osmeet.os.presenter.MatchPresenter;
import com.osmeet.os.view.panel.MatchFrontPanel;
import com.osmeet.os.view.panel.MatchMapPanel;

import butterknife.BindView;
import butterknife.OnClick;

public class MatchActivity extends BaseActivity<MatchContract.IPresenter> implements MatchContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MatchPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match;
    }

    @Override
    protected boolean swipeBackEnable() {
        return false;
    }

    MatchMapPanel matchMapPanel;
    MatchFrontPanel matchFrontPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(matchMapPanel = new MatchMapPanel(context, mPresenter),
                matchFrontPanel = new MatchFrontPanel(context, mPresenter)
        );
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @OnClick(R.id.img_more)
    void more() {

    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
        fl_panel.addView(getPanelView(1));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        matchMapPanel.onSaveInstanceState(outState);
    }

    @Override
    public void showMatchTeam(@NonNull MatchTeam matchTeam) {

    }
}

