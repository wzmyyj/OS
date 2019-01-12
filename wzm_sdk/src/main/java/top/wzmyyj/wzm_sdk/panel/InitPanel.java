package top.wzmyyj.wzm_sdk.panel;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by wzm on 2018/04/23. email: 2209011667@qq.com
 */


public abstract class InitPanel extends Panel {

    public InitPanel(Context context) {
        super(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRootView();
        initSome(savedInstanceState);
        initView();
        initData();
        initListener();
        initEvent();
    }

    protected abstract void setRootView();

    protected void initSome(Bundle savedInstanceState) {
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected void initEvent() {
    }
}
