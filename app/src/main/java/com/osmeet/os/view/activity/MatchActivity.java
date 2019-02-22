package com.osmeet.os.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.event.TeamChangeEvent;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.MatchContract;
import com.osmeet.os.presenter.MatchPresenter;
import com.osmeet.os.view.panel.MatchFrontPanel;
import com.osmeet.os.view.panel.MatchMapPanel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

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

//    @Override
//    protected boolean swipeBackEnable() {
//        return false;
//    }

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
        if (mMatchTeam != null && mMatchTeam.getMatchStatus() == MatchTeam.MATCH_NOW) {
            List<String> list = new ArrayList<>();
            list.add(context.getString(R.string.cancel_os));
            BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                        switch (index) {
                            case 0:
                                dialog();
                                break;
                        }
                    }, true, context.getString(R.string.cancel)
            ).setTitle(context.getString(R.string.please_choose));
        }

    }

    private void dialog() {
        SelectDialog.show(context, context.getString(R.string.warm),
                context.getString(R.string.is_cancel_os),
                context.getString(R.string.ok), (dialog, which) -> mPresenter.quitMatch(),
                context.getString(R.string.cancel), (dialog, which) -> {
                });
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
    protected void initData() {
        super.initData();
        mPresenter.loadMatchTeam();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        matchMapPanel.onSaveInstanceState(outState);
    }

    private MatchTeam mMatchTeam;

    @Override
    public void showMatchTeam(@NonNull MatchTeam matchTeam) {
        mMatchTeam = matchTeam;
        matchFrontPanel.setMatchTeam(matchTeam);
        matchMapPanel.setMatchTeam(matchTeam);
    }


    @Override
    protected void initEvent() {
        super.initEvent();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }


    @Subscribe
    public void onEvent(TeamChangeEvent event) {
        if (mPresenter.getMatchId().equals(event.getTeamId())) {
            mPresenter.loadMatchTeam();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

