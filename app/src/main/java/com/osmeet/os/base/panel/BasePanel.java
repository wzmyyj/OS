package com.osmeet.os.base.panel;

import android.content.Context;
import android.view.View;

import com.osmeet.os.base.contract.IBasePresenter;

import butterknife.ButterKnife;
import top.wzmyyj.wzm_sdk.panel.GroupPanel;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public abstract class BasePanel<P extends IBasePresenter> extends GroupPanel {
    protected P mPresenter;

    public BasePanel(Context context, P p) {
        super(context);
        this.mPresenter = p;
        checkPresenterIsNull();
    }

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    protected abstract int getLayoutId();


    protected void setView(View view) {
        this.view = view;
    }


    @Override
    protected void setRootView() {
        view = mInflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, view);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
