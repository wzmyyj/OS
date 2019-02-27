package com.osmeet.os.view.activity;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.TradeContract;
import com.osmeet.os.presenter.TradePresenter;
import com.osmeet.os.view.panel.TradeNeScrollPanel;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class TradeActivity extends BaseActivity<TradeContract.IPresenter> implements TradeContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new TradePresenter(activity, this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_trade;
    }

    TradeNeScrollPanel tradeNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(tradeNeScrollPanel = new TradeNeScrollPanel(context, mPresenter));
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
        tradeNeScrollPanel.pay();
    }

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
        bt_goods_buy.setText(R.string.pay);
        tv_goods_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tradeNeScrollPanel.bindView("v1", tv_goods_price);
        tradeNeScrollPanel.bindView("v2", tv_goods_price_old);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadTradeInfo();
    }

    @Override
    public void showTradeInfo(@NonNull Trade trade) {
        tradeNeScrollPanel.setTrade(trade);
    }

    @Override
    public void showResult(@NonNull Map<String, String> result) {

    }
}
