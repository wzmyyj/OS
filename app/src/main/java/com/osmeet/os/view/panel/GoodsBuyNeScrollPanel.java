package com.osmeet.os.view.panel;

import android.content.Context;

import com.osmeet.os.R;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.GoodsBuyContract;


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
}
