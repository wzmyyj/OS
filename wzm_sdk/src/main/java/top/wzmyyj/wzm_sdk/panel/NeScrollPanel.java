package top.wzmyyj.wzm_sdk.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.FrameLayout;

import top.wzmyyj.wzm_sdk.R;

/**
 * Created by wzm on 2018/05/05.
 * <p>
 * NeScroll SmartRefresh Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class NeScrollPanel extends RefreshPanel {

    protected NestedScrollView mNestedScrollView;
    protected FrameLayout mFrameLayout;
    protected View contentView;

    /**
     * @param context .
     */
    public NeScrollPanel(Context context) {
        super(context);
    }


    @SuppressLint("InflateParams")
    @Override
    protected void setRootView() {
        view = mInflater.inflate(R.layout.panel_ns, null);
    }

    @Override
    protected void initView() {
        mFrameLayout = view.findViewById(R.id.frameLayout);
        mNestedScrollView = view.findViewById(R.id.nestedScrollView);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        setRefreshLayout(mRefreshLayout);
        contentView = mInflater.inflate(getContentViewId(), null);
        mNestedScrollView.addView(contentView);

    }

    /**
     * @return LayoutRes.
     */
    @LayoutRes
    protected abstract int getContentViewId();

    @Override
    protected void initData() {

    }


    /**
     * refresh.
     */
    @Override
    protected void refresh() {
        update();
    }

    /**
     * loadMore.
     */
    @Override
    protected void loadMore() {

    }

    /**
     * updateView.
     */
    protected void updateView() {

    }
}
