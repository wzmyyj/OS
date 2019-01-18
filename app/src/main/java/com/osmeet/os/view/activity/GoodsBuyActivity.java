package com.osmeet.os.view.activity;

import android.graphics.Paint;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.GoodsBuyContract;
import com.osmeet.os.presenter.GoodsBuyPresenter;
import com.osmeet.os.view.panel.GoodsBuyNeScrollPanel;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsBuyActivity extends BaseActivity<GoodsBuyContract.IPresenter> implements GoodsBuyContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new GoodsBuyPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_buy;
    }


    GoodsBuyNeScrollPanel goodsBuyNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(goodsBuyNeScrollPanel = new GoodsBuyNeScrollPanel(context, mPresenter));
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @BindView(R.id.tv_goods_price)
    TextView tv_goods_price;
    @BindView(R.id.tv_goods_price_old)
    TextView tv_goods_price_old;
    @BindView(R.id.bt_goods_buy)
    Button bt_goods_buy;

    @OnClick(R.id.bt_goods_buy)
    void pay() {
        goodsBuyNeScrollPanel.pay();
    }

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
        bt_goods_buy.setText(R.string.pay);
        tv_goods_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        goodsBuyNeScrollPanel.bindView("v1", tv_goods_price);
        goodsBuyNeScrollPanel.bindView("v2", tv_goods_price_old);
    }
}

