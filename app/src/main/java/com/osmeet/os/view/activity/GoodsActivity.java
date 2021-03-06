package com.osmeet.os.view.activity;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Goods;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.GoodsContract;
import com.osmeet.os.presenter.GoodsPresenter;
import com.osmeet.os.view.panel.GoodsNeScrollPanel;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsActivity extends BaseActivity<GoodsContract.IPresenter> implements GoodsContract.IView {

    @Override
    protected void initPresenter() {
        mPresenter = new GoodsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods;
    }


    GoodsNeScrollPanel goodsNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(goodsNeScrollPanel = new GoodsNeScrollPanel(context, mPresenter));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @BindView(R.id.tv_goods_price)
    TextView tv_goods_price;
    @BindView(R.id.tv_goods_price_old)
    TextView tv_goods_price_old;

    @OnClick(R.id.bt_goods_buy)
    void buy() {
        if (simpleGoods != null)
            mPresenter.goGoodsBuy(simpleGoods);
    }

    @Override
    protected void initView() {
        super.initView();
        setTopBar();
        fl_panel.addView(getPanelView(0));
        fl_panel.addView(mTopBar);

        tv_goods_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        goodsNeScrollPanel.bindView("v", ll_tap_bar);
    }

    private View mTopBar;
    private LinearLayout ll_tap_bar;
    private TextView tv_name;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_goods_top_bar, null);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        tv_name = mTopBar.findViewById(R.id.tv_name);
        mTopBar.findViewById(R.id.img_back).setOnClickListener(v -> mPresenter.finish());
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadGoodsInfo();
    }

    private Goods.SimpleGoods simpleGoods;

    @Override
    public void showGoodsInfo(@NonNull Goods goods) {
        goodsNeScrollPanel.setGoods(goods);
        WidgetUtil.setTextNonNull(tv_name, goods.getName());
        WidgetUtil.setTextPrice(tv_goods_price, "￥", goods.getDiscountPrice());
        WidgetUtil.setTextPrice(tv_goods_price_old, "￥", goods.getOriginalPrice());

        simpleGoods = new Goods.SimpleGoods(goods);
    }

}

