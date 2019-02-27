package com.osmeet.os.base.panel;

import android.content.Context;

import com.osmeet.os.base.contract.BaseContract;

import butterknife.ButterKnife;
import top.wzmyyj.wzm_sdk.panel.PanelGroup;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public abstract class BasePanelGroup<P extends BaseContract.IPresenter> extends PanelGroup {
    protected P mPresenter;

    public BasePanelGroup(Context context, P p) {
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
