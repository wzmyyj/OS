package top.wzmyyj.wzm_sdk.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.FrameLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

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
    protected SmartRefreshLayout mRefreshLayout;
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
        mRefreshLayout.setHeaderHeight(100);
        mRefreshLayout.setFooterHeight(100);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setPrimaryColorsId(R.color.colorRefresh, R.color.colorWhite);
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

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(getDelayed_l());
                loadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(getDelayed_r());
                refresh();
            }
        });
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
     * updateWithView.
     */
    @Override
    public void updateWithView() {
        mRefreshLayout.autoRefresh();
        refresh();
        mRefreshLayout.finishRefresh(getDelayed_r());
    }

    /**
     * updateView.
     */
    protected void updateView() {

    }
}
