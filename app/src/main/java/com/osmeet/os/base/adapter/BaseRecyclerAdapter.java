package com.osmeet.os.base.adapter;

import android.content.Context;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.IvdRecyclerAdapter;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class BaseRecyclerAdapter<T> extends IvdRecyclerAdapter<T> {

    public BaseRecyclerAdapter(Context context, List<T> data) {
        super(context, data);
    }
}
