package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.osmeet.os.app.bean.Story;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.view.adapter.FixStaggeredMultiItemTypeAdapter;
import com.osmeet.os.view.adapter.ivd.StoryIVD;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.tools.Sure;


/**
 * Created by yyj on 2019/03/17.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class StoryRecyclerPanel<P extends BaseContract.IPresenter> extends BaseRecyclerPanel<Story, P> {
    public StoryRecyclerPanel(Context context, P p) {
        super(context, p);
    }

    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
    }

    @Override
    protected void initView() {
        super.initView();
        // 消除mRecyclerView刷新的动画。
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        Sure.sure(mHeader != null && mFooter != null, "mHeader or mFooter can not be null!");
    }


    @NonNull
    @Override
    protected RecyclerView.LayoutManager layoutManager() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        return layoutManager;
    }

    @Override
    protected MultiItemTypeAdapter<Story> getMultiItemTypeAdapter(Context context, List<Story> data) {
        return new FixStaggeredMultiItemTypeAdapter<Story>(context, data) {
            @Override
            protected boolean isHeaderViewPosition(int position) {
                return position == 0;
            }

            @Override
            protected boolean isFooterViewPosition(int position) {
                return position == mData.size() + 1;
            }

        };
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                layoutManager.invalidateSpanAssignments();
            }
        });
    }

}
