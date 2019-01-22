package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.TradeListContract;
import com.osmeet.os.view.adapter.ivd.TradeIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/19.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class TradeListRecyclerPanel extends BaseRecyclerPanel<Trade, TradeListContract.IPresenter> {
    public TradeListRecyclerPanel(Context context, TradeListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Trade>> ivd) {
        ivd.add(new TradeIVD(context));
    }


    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        mPresenter.goTrade(mData.get(position).getId());
    }

    @Override
    protected void update() {
        mPresenter.loadTradeList(getTag().toString(), 0);
    }


    public void setTradeList(@NonNull List<Trade> tradeList) {
        mData.clear();
        mData.addAll(tradeList);
        notifyDataSetChanged();
    }
}
