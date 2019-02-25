package top.wzmyyj.wzm_sdk.panel;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by wzm on 2018/04/23.
 *
 * Init Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class InitPanel extends Panel {

    /**
     * @param context .
     */
    public InitPanel(Context context) {
        super(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSome(savedInstanceState);
        initView();
        initData();
        initListener();
        initEvent();
    }

    /**
     * set root view
     */
    protected abstract void setRootView();

    /**
     * do something init.
     *
     * @param savedInstanceState .
     */
    protected void initSome(Bundle savedInstanceState) {
        setRootView();
    }

    /**
     * do something about view.
     */
    protected abstract void initView();

    /**
     * do something about data.
     */
    protected abstract void initData();

    /**
     * do something about listener.
     */
    protected abstract void initListener();

    /**
     * do something about event.
     */
    protected void initEvent() {
    }
}
