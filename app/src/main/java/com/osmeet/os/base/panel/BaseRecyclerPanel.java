package com.osmeet.os.base.panel;

import android.content.Context;

import com.osmeet.os.base.contract.BaseContract;

import top.wzmyyj.wzm_sdk.panel.RecyclerPanel;


/**
 * Created by yyj on 2018/07/06. email: 2209011667@qq.com
 */

public abstract class BaseRecyclerPanel<T,P extends BaseContract.IPresenter> extends RecyclerPanel<T> {

    protected P mPresenter;

    public BaseRecyclerPanel(Context context, P p) {
        super(context);
        this.mPresenter = p;
        checkPresenterIsNull();
    }

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

}
