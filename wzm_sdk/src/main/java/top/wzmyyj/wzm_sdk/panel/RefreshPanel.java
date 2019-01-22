package top.wzmyyj.wzm_sdk.panel;

import android.content.Context;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import top.wzmyyj.wzm_sdk.R;

/**
 * Created by wzm on 2018/05/05.
 * <p>
 * Refresh Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class RefreshPanel extends PanelGroup {

    private static final int DEFAULT_DELAYED_REFRESH = 1500;
    private static final int DEFAULT_DELAYED_LOAD_MORE = 1000;

    protected int delayed_Refresh = DEFAULT_DELAYED_REFRESH;
    protected int delayed_LoadMore = DEFAULT_DELAYED_LOAD_MORE;

    protected SmartRefreshLayout mRefreshLayout;

    /**
     * @param context .
     */
    public RefreshPanel(Context context) {
        super(context);
    }


    protected void setRefreshLayout(SmartRefreshLayout refreshLayout) {
        refreshLayout.setHeaderHeight(100);
        refreshLayout.setFooterHeight(100);
        refreshLayout.setEnableRefresh(isEnableRefresh());
        refreshLayout.setEnableLoadMore(isEnableLoadMore());
        refreshLayout.setEnablePureScrollMode(isEnablePureScrollMode());
        refreshLayout.setPrimaryColorsId(R.color.colorRefresh, R.color.colorWhite);
    }

    protected boolean isEnableRefresh() {
        return true;
    }

    protected boolean isEnableLoadMore() {
        return false;
    }

    protected boolean isEnablePureScrollMode() {
        return false;
    }

    @Override
    protected void initListener() {
        if (mRefreshLayout == null) return;
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(delayed_Refresh);
                refresh();
            }

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(delayed_LoadMore);
                loadMore();
            }
        });
    }

    /**
     * refresh.
     */
    protected void refresh() {
        update();
    }

    /**
     * loadMore.
     */
    protected void loadMore() {
    }

    /**
     * update.
     */
    protected abstract void update();

    /**
     * updateWithView.
     */
    public void updateWithView() {
        mRefreshLayout.autoRefresh();
        refresh();
        mRefreshLayout.finishRefresh(delayed_Refresh);
    }

}
