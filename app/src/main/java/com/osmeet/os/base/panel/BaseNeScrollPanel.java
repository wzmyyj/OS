package com.osmeet.os.base.panel;

import android.content.Context;

import com.osmeet.os.base.contract.IBasePresenter;

import butterknife.ButterKnife;
import top.wzmyyj.wzm_sdk.panel.NeScrollPanel;


/**
 * Created by yyj on 2018/08/16. email: 2209011667@qq.com
 */

public abstract class BaseNeScrollPanel<P extends IBasePresenter> extends NeScrollPanel {
    protected P mPresenter;

    public BaseNeScrollPanel(Context context, P p) {
        super(context);
        this.mPresenter = p;
        checkPresenterIsNull();
    }

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this, contentView);
    }
}
