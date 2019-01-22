package com.osmeet.os.base.adapter;

import android.content.Context;

import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class BaseIVD<T> extends SingleIVD<T> {

    public BaseIVD(Context context) {
        super(context);
    }
}
