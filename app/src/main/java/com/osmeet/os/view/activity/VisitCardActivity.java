package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.VisitCardContract;
import com.osmeet.os.presenter.VisitCardPresenter;

public class VisitCardActivity extends BaseActivity<VisitCardContract.IPresenter> implements VisitCardContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new VisitCardPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_visit_card;
    }

}

