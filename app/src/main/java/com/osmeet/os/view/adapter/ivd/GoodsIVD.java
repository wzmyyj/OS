package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class GoodsIVD extends BaseIVD<Goods> {


    public GoodsIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return  R.layout.layout_store_goods_item;
    }

    @Override
    public void convert(ViewHolder holder, Goods goods, int position) {
        TextView tv_goods_name = holder.getView(R.id.tv_goods_name);
        TextView tv_goods_price = holder.getView(R.id.tv_goods_price);
        TextView tv_goods_price_old = holder.getView(R.id.tv_goods_price_old);
        ImageView img_goods = holder.getView(R.id.img_goods);
        tv_goods_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        WidgetUtil.setTextNonNull(tv_goods_name, goods.getName());
        WidgetUtil.setTextPrice(tv_goods_price, "￥", goods.getDiscountPrice());
        WidgetUtil.setTextPrice(tv_goods_price_old, "￥", goods.getOriginalPrice());
        if (goods.getImages() != null && goods.getImages().size() > 0) {
            G.img(context, goods.getImages().get(0).getUrl(), img_goods);
        }
    }
}
