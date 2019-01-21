package com.osmeet.os.base.adapter;

import android.content.Context;

import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class BaseRecyclerIVD<T> extends SingleIVD<T> {

    protected Context context;

    public BaseRecyclerIVD(Context context) {
        this.context = context;
    }


}
