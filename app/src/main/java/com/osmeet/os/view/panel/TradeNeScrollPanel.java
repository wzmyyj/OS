package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.TradeContract;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class TradeNeScrollPanel extends BaseNeScrollPanel<TradeContract.IPresenter> {
    public TradeNeScrollPanel(Context context, TradeContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_trade_content;
    }

    @BindView(R.id.tv_trade_state)
    TextView tv_trade_state;
    @BindView(R.id.img_store_logo)
    ImageView img_store_logo;
    @BindView(R.id.tv_store_name)
    TextView tv_store_name;
    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.tv_amount_paid)
    TextView tv_amount_paid;
    @BindView(R.id.img_goods_image)
    ImageView img_goods_image;
    @BindView(R.id.tv_trade_number)
    TextView tv_trade_number;
    @BindView(R.id.tv_trade_time)
    TextView tv_trade_time;
    @BindView(R.id.tv_buy_count)
    TextView tv_buy_count;

    @Override
    protected void update() {
        mPresenter.loadTrade();
    }

    public void setTrade(@NonNull Trade trade) {

        WidgetUtil.setTextNonNull(tv_trade_state, trade.getStateDesc());
        WidgetUtil.setTextPrice(tv_amount_paid, "￥", trade.getAmountPaid());
        WidgetUtil.setTextNonNull(tv_trade_number, trade.getSerialNumber());
        WidgetUtil.setTextNonNull(tv_trade_time, TimeUtil.long2str(trade.getCreateDate(), TimeUtil.YYYY_MM_DD_HH_MM));
        WidgetUtil.setTextNumber(tv_buy_count, trade.getPurchaseAmount());

        Goods goods = trade.getGoods();
        if (goods != null) {
            WidgetUtil.setTextNonNull(tv_goods_name, goods.getName());
            if (goods.getImages() != null && goods.getImages().size() > 0)
                G.img(context, goods.getImages().get(0).getUrl(), img_goods_image);

            Store store = goods.getStore();
            if (store != null) {
                if (store.getLogoImage() != null)
                    G.img(context, store.getLogoImage().getUrl(), img_store_logo);
                WidgetUtil.setTextNonNull(tv_store_name, store.getName());
            }
        }

        TextView v1 = getBindView("v1");
        if (v1 != null) {
            WidgetUtil.setTextPrice(v1, "￥", trade.getAmountPaid());
        }
        TextView v2 = getBindView("v2");
        if (v2 != null) {
            WidgetUtil.setTextPrice(v2, "￥", trade.getAmount());
        }
    }

    public void pay() {
        mPresenter.loadPay();
    }

}
