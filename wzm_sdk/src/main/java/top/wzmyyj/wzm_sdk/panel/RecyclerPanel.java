package top.wzmyyj.wzm_sdk.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.EmptyWrapper;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.R;
import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;

/**
 * Created by wzm on 2018/04/23.
 * <p>
 * Recycler SmartRefresh Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class RecyclerPanel<T> extends RefreshPanel
        implements MultiItemTypeAdapter.OnItemClickListener {

    protected RecyclerView mRecyclerView;
    protected FrameLayout mFrameLayout;
    protected List<T> mData = new ArrayList<>();
    protected final List<IVD<T>> mIVD = new ArrayList<>();
    protected RecyclerView.Adapter mAdapter;
    protected View mHeader;
    protected View mFooter;

    protected View mEmpty;


    public RecyclerPanel(Context context) {
        super(context);
    }


    @SuppressLint("InflateParams")
    @Override
    protected void setRootView() {
        view = mInflater.inflate(R.layout.panel_sr, null);
    }


    @Override
    protected void initView() {
        mFrameLayout = view.findViewById(R.id.frameLayout);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        setRefreshLayout(mRefreshLayout);
        mRecyclerView.setLayoutManager(layoutManager());

        setFirstData();
        setIVD(mIVD);
        if (mIVD.size() == 0) {
            defaultIVD();
        }
        MultiItemTypeAdapter<T> multiItemTypeAdapter = new MyMultiItemTypeAdapter(context, mData);
        for (IVD<T> ivd : mIVD) {
            multiItemTypeAdapter.addItemViewDelegate(ivd);
        }
        multiItemTypeAdapter.setOnItemClickListener(this);
        mAdapter = multiItemTypeAdapter;

        setHeader();
        setFooter();
        if (mHeader != null || mFooter != null) {
            HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
            if (mHeader != null)
                headerAndFooterWrapper.addHeaderView(mHeader);
            if (mFooter != null)
                headerAndFooterWrapper.addFootView(mFooter);
            mAdapter = headerAndFooterWrapper;
        }

        setEmpty();
        if (mEmpty != null) {
            EmptyWrapper emptyWrapper = new EmptyWrapper(mAdapter);
            emptyWrapper.setEmptyView(mEmpty);
            mAdapter = emptyWrapper;
        }

        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * @return a RecyclerView.LayoutManager.
     */
    @NonNull
    protected RecyclerView.LayoutManager layoutManager() {
        return new LinearLayoutManager(context);
    }

    /**
     * @param <A> extends RecyclerView.Adapter.
     * @return mAdapter.
     */
    @SuppressWarnings("unchecked")
    public <A extends RecyclerView.Adapter> A getAdapter() {
        return (A) mAdapter;
    }

    /**
     * when mIVD.size() is 0, add default IVD. just use look.
     */
    private void defaultIVD() {
        mIVD.add(new SingleIVD<T>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_default_ivd;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                holder.setText(R.id.tv_item, "item: " + position);
            }
        });
    }

    /**
     * setFirstData.
     */
    protected void setFirstData() {

    }


    protected abstract void setIVD(List<IVD<T>> ivd);


    /**
     * setHeader.
     */
    protected void setHeader() {
    }


    /**
     * setFooter.
     */
    protected void setFooter() {
    }

    /**
     * setEmpty.
     */
    protected void setEmpty() {

    }

    class MyMultiItemTypeAdapter extends MultiItemTypeAdapter<T> {

        MyMultiItemTypeAdapter(Context context, List<T> data) {
            super(context, data);
        }

        @Override
        public void onViewRecycled(@NonNull ViewHolder holder) {
            super.onViewRecycled(holder);
            viewRecycled(holder);
        }
    }

    protected void viewRecycled(@NonNull ViewHolder holder) {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void refresh() {
        update();
    }

    @Override
    protected void loadMore() {

    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }

    /**
     * 排序.
     */
    protected void sort() {

    }

    /**
     * notifyDataSetChanged.
     */
    protected void notifyDataSetChanged() {
        sort();
        mAdapter.notifyDataSetChanged();
        updateHeaderAndFooter();
        updateEmpty();
    }

    /**
     * update mHeader And mFooter.
     */
    protected void updateHeaderAndFooter() {

    }

    /**
     * update mEmpty.
     */
    protected void updateEmpty() {

    }


}
