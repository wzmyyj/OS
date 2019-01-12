package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.MatchBeginContract;
import com.osmeet.os.presenter.MatchBeginPresenter;

public class MatchBeginActivity extends BaseActivity<MatchBeginContract.IPresenter> implements MatchBeginContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MatchBeginPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_match_begin;
    }

}

