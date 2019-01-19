package com.osmeet.os.view.panel;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.GoodsBuyContract;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by yyj on 2019/01/16. email: 2209011667@qq.com
 */

public class GoodsBuyNeScrollPanel extends BaseNeScrollPanel<GoodsBuyContract.IPresenter> {

    public GoodsBuyNeScrollPanel(Context context, GoodsBuyContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_goods_buy_content;
    }

    @Override
    protected void update() {

    }

    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.img_goods_image)
    ImageView img_goods_image;
    @BindView(R.id.tv_goods_num)
    TextView tv_goods_num;
    @BindView(R.id.tv_goods_sum_price)
    TextView tv_goods_sum_price;

    @OnClick(R.id.img_goods_num_move)
    void move() {
        if (simpleGoods == null) return;
        if (count <= 0) return;
        count--;
        setPrice();
    }

    @OnClick(R.id.img_goods_num_add)
    void add() {
        if (simpleGoods == null) return;
        if (count >= 100) return;
        count++;
        setPrice();
    }

    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout.setEnablePureScrollMode(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        simpleGoods = mPresenter.getSimpleGoods();
        if (simpleGoods != null) {
            G.img(context, simpleGoods.getImageUrl(), img_goods_image);
            WidgetUtil.setTextNonNull(tv_goods_name, simpleGoods.getName());
            setPrice();
        }
    }

    private void setPrice() {
        WidgetUtil.setTextNumber(tv_goods_num, count);
        WidgetUtil.setTextPrice(tv_goods_sum_price, "￥", simpleGoods.getDiscountPrice() * count);
        TextView v1 = getBindView("v1");
        if (v1 != null) {
            WidgetUtil.setTextPrice(v1, "￥", simpleGoods.getDiscountPrice() * count);
        }
        TextView v2 = getBindView("v2");
        if (v2 != null) {
            WidgetUtil.setTextPrice(v2, "￥", simpleGoods.getOriginalPrice() * count);
        }

    }

    private Goods.SimpleGoods simpleGoods;
    private int count = 1;

    public void pay() {
        if (count == 0) return;
        mPresenter.buyGoods(simpleGoods.getId(), count);
    }

}
