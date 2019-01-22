package com.osmeet.os.view.adapter;

import android.content.Context;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.adapter.BaseRecyclerAdapter;
import com.osmeet.os.view.adapter.ivd.GoodsIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class GoodsAdapter extends BaseRecyclerAdapter<Goods> {
    public GoodsAdapter(Context context, List<Goods> data) {
        super(context, data);
    }

    @Override
    protected void setIVD(List<IVD<Goods>> ivd) {
        ivd.add(new GoodsIVD(context));
    }
}
