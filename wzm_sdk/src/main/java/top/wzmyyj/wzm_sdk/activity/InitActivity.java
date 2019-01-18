package top.wzmyyj.wzm_sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by yyj on 2018/04/22.
 *
 * Init Activity.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class InitActivity extends SwipeBackActivity {


    /**
     * default edge size
     */
    private static final int DEFAULT_EDGE_SIZE = 100;

    protected SwipeBackLayout mSwipeBackLayout;
    protected Context context;
    protected Activity activity;
    protected LayoutInflater mInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activity = this;
        mInflater = getLayoutInflater();
        setSwipeBackEnable(swipeBackEnable());
        mSwipeBackLayout = getSwipeBackLayout();
        //设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        mSwipeBackLayout.setEdgeSize(edgeSize());
        setRootView();
        initSome(savedInstanceState);
        initView();
        initData();
        initListener();
        initEvent();
    }


    /**
     * 是否侧滑退出。
     *
     * @return swipeBackEnable
     */
    protected boolean swipeBackEnable() {
        return true;
    }

    /**
     * 边界的宽度。
     *
     * @return size
     */
    protected int edgeSize() {
        return DEFAULT_EDGE_SIZE;
    }

    /**
     * set root view
     */
    protected abstract void setRootView();

    /**
     * do something init.
     *
     * @param savedInstanceState bundle
     */
    protected void initSome(Bundle savedInstanceState) {
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
     * do something about listener
     */
    protected abstract void initListener();

    /**
     * do something about event
     */
    protected void initEvent() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        context = null;
        activity = null;
    }
}
