package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.MatchListContract;
import com.osmeet.os.presenter.MatchListPresenter;
import com.osmeet.os.view.panel.MatchListRecyclerPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.panel.PanelUtil;

public class MatchListActivity extends BaseActivity<MatchListContract.IPresenter> implements MatchListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MatchListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match_list;
    }

    MatchListRecyclerPanel matchListRecyclerPanel_0;
    MatchListRecyclerPanel matchListRecyclerPanel_1;
    MatchListRecyclerPanel matchListRecyclerPanel_2;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                matchListRecyclerPanel_0 = new MatchListRecyclerPanel(context, mPresenter)
                        .setTitle(context.getString(R.string.all)),
                matchListRecyclerPanel_1 = new MatchListRecyclerPanel(context, mPresenter)
                        .setTitle(context.getString(R.string.os_now)),
                matchListRecyclerPanel_2 = new MatchListRecyclerPanel(context, mPresenter)
                        .setTitle(context.getString(R.string.os_history))
        );

    }

    @BindView(R.id.tab_1)
    TabLayout mTabLayout;
    @BindView(R.id.vp_1)
    ViewPager mViewPager;

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @Override
    protected void initView() {
        super.initView();
        PanelUtil.in(getPanelList(), mTabLayout, mViewPager);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMatchTeamList(0);
    }

    @Override
    public void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList, int pageNum) {
        matchListRecyclerPanel_0.setDataList(matchTeamList, pageNum);
        List<MatchTeam> matchTeamList_1 = new ArrayList<>();
        List<MatchTeam> matchTeamList_2 = new ArrayList<>();
        for (MatchTeam matchTeam : matchTeamList) {
            if (matchTeam.getMatchStatus() == MatchTeam.MATCH_NOW) {
                matchTeamList_1.add(matchTeam);
            } else {
                matchTeamList_2.add(matchTeam);
            }
        }
        matchListRecyclerPanel_1.setDataList(matchTeamList_1, pageNum);
        matchListRecyclerPanel_2.setDataList(matchTeamList_2, pageNum);
    }
}

