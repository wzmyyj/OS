package com.osmeet.os.view.activity;

import android.widget.ImageView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.tools.G;
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
    @BindView(R.id.img_store_logo)
    ImageView img_store_logo;


    private MatchTeam.SimpleMatchTeam simpleMatchTeam;

    @Override
    protected void initData() {
        super.initData();
        simpleMatchTeam = mPresenter.getSimpleMatchTeam();
        G.img(context, simpleMatchTeam.getStore_logo(), img_store_logo);
        G.img(context, simpleMatchTeam.getUser1_avatar(), img_user_avatar_1);
        G.img(context, simpleMatchTeam.getUser2_avatar(), img_user_avatar_2);
    }

    @OnClick(R.id.img_go_match)
    void go_match() {
        if (simpleMatchTeam != null) {
            mPresenter.goMatch(simpleMatchTeam.getId());
            mPresenter.finish();
        }

    }

}

