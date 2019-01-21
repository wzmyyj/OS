package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.TradeListContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;


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
        ivd.add(new SingleIVD<Trade>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_trade_item;
            }

            @Override
            public void convert(ViewHolder holder, Trade trade, int position) {

            }
        });
    }

    @Override
    protected void update() {

    }


    public void setTradeList(@NonNull List<Trade> tradeList) {
        mData.clear();
        mData.addAll(tradeList);
        notifyDataSetChanged();
    }
}
