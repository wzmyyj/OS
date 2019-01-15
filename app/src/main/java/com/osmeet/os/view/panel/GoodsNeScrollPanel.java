package com.osmeet.os.view.panel;

import android.content.Context;

import com.osmeet.os.R;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.GoodsContract;

/**
 * Created by yyj on 2019/01/15. email: 2209011667@qq.com
 */

public class GoodsNeScrollPanel extends BaseNeScrollPanel<GoodsContract.IPresenter> {
    public GoodsNeScrollPanel(Context context, GoodsContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_goods_content;
    }

    @Override
    protected void update() {

    }
}
