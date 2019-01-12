package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.MatchListContract;
import com.osmeet.os.presenter.MatchListPresenter;

import java.util.List;

public class MatchListActivity extends BaseActivity<MatchListContract.IPresenter> implements MatchListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MatchListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match_list;
    }

    @Override
    public void showMatchTeamList(@NonNull List<MatchTeam> matchTeamList) {

    }
}

