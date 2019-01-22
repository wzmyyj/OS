package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.Trade;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class TradeIVD extends BaseIVD<Trade> {
    public TradeIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_trade_item;
    }

    @Override
    public void convert(ViewHolder holder, Trade trade, int position) {
        ImageView img_store_logo = holder.getView(R.id.img_store_logo);
        TextView tv_store_name = holder.getView(R.id.tv_store_name);
        TextView tv_goods_name = holder.getView(R.id.tv_goods_name);
        TextView tv_trade_state = holder.getView(R.id.tv_trade_state);
        TextView tv_amount_paid = holder.getView(R.id.tv_amount_paid);
        ImageView img_goods_image = holder.getView(R.id.img_goods_image);

        WidgetUtil.setTextNonNull(tv_trade_state, trade.getStateDesc());
        WidgetUtil.setTextPrice(tv_amount_paid, "￥", trade.getAmountPaid());

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
    }
}
