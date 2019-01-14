package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.MatchBeginContract;
import com.osmeet.os.presenter.MatchBeginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MatchBeginActivity extends BaseActivity<MatchBeginContract.IPresenter> implements MatchBeginContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MatchBeginPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match_begin;
    }


    @BindView(R.id.img_user_avatar_1)
    ImageView img_user_avatar_1;
    @BindView(R.id.img_user_avatar_2)
    ImageView img_user_avatar_2;
    @BindView(R.id.img_shop_logo)
    ImageView img_shop_logo;


    private String matchId;

    @OnClick(R.id.img_go_match)
    void go_match() {
        mPresenter.goMatch(matchId);
    }

    @Override
    public void showMatchTeam(@NonNull MatchTeam matchTeam) {

    }
}

