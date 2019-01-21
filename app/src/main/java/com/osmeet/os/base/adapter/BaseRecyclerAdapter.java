package com.osmeet.os.base.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class BaseRecyclerAdapter<T> extends MultiItemTypeAdapter<T> {
    public BaseRecyclerAdapter(Context context, List<T> data) {
        super(context, data);
    }
}
