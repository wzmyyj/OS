package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.GoodsContract;
import com.osmeet.os.presenter.GoodsPresenter;

public class GoodsActivity extends BaseActivity<GoodsContract.IPresenter> implements GoodsContract.IView {
    @Override
    public void showGoods(@NonNull Goods goods) {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new GoodsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods;
    }

}

