package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.TradeListContract;
import com.osmeet.os.presenter.TradeListPresenter;

public class TradeListActivity extends BaseActivity<TradeListContract.IPresenter> implements TradeListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new TradeListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_trade_list;
    }

}


