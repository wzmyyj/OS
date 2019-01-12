package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.TradeContract;
import com.osmeet.os.presenter.TradePresenter;

public class TradeActivity extends BaseActivity<TradeContract.IPresenter> implements TradeContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new TradePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_trade;
    }

}
