package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.TradeListContract;
import com.osmeet.os.presenter.TradeListPresenter;
import com.osmeet.os.view.panel.TradeListRecyclerPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.adapter.ViewTitlePagerAdapter;
import top.wzmyyj.wzm_sdk.panel.Panel;

public class TradeListActivity extends BaseActivity<TradeListContract.IPresenter> implements TradeListContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new TradeListPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_trade_list;
    }


    TradeListRecyclerPanel tradeListRecyclerPanel_0;
    TradeListRecyclerPanel tradeListRecyclerPanel_1;
//    TradeListRecyclerPanel tradeListRecyclerPanel_2;
    TradeListRecyclerPanel tradeListRecyclerPanel_3;
    TradeListRecyclerPanel tradeListRecyclerPanel_4;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                tradeListRecyclerPanel_0 = new TradeListRecyclerPanel(context, mPresenter).setTitle("全部").setTag(Trade.ALL),
                tradeListRecyclerPanel_1 = new TradeListRecyclerPanel(context, mPresenter).setTitle("待付款").setTag(Trade.WAIT_PAY),
//                tradeListRecyclerPanel_2 = new TradeListRecyclerPanel(context, mPresenter).setTitle("待匹配").setTag(Trade.),
                tradeListRecyclerPanel_3 = new TradeListRecyclerPanel(context, mPresenter).setTitle("待使用").setTag(Trade.PAID),
                tradeListRecyclerPanel_4 = new TradeListRecyclerPanel(context, mPresenter).setTitle("退款").setTag(Trade.P_REFUND_END)
        );
    }

    @BindView(R.id.tab_1)
    TabLayout mTabLayout;
    @BindView(R.id.vp_1)
    ViewPager mViewPager;

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @Override
    protected void initView() {
        super.initView();
        List<View> viewList = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (Panel p : getPanelList()) {
            viewList.add(p.getView());
            titles.add(p.getTitle());
        }
        ViewTitlePagerAdapter pagerAdapter = new ViewTitlePagerAdapter(viewList, titles);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initData() {
        super.initData();
        for (Panel p : getPanelList()) {
            mPresenter.loadTradeList(p.getTag().toString(), 0);
        }
    }

    @Override
    public void showTradeList(@NonNull List<Trade> tradeList, @NonNull String state) {
        for (Panel p : getPanelList()) {
            if (state.equals(p.getTag().toString())) {
                ((TradeListRecyclerPanel) p).setTradeList(tradeList);
            }
        }
    }
}


