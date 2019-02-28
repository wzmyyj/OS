package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.utils.DistanceUtil;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.contract.ic.IStoreInfo;
import com.osmeet.os.view.activity.StoreActivity;
import com.osmeet.os.view.adapter.ivd.StoryIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import top.wzmyyj.wzm_sdk.widget.TabMenu;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StoreInfoRecyclerPanel extends BaseRecyclerPanel<Story, StoreInfoContract.IPresenter> {
    public StoreInfoRecyclerPanel(Context context, StoreInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
    }


    @Override
    public void update() {
        mPresenter.loadStoreInfo();
        mPresenter.loadStoryList(0);

        StoreActivity storeActivity = getActivity();
        if (storeActivity != null) {
            IStoreInfo.P mPresenter2 = storeActivity.getPresenter();
            if (mPresenter2 != null)
                mPresenter2.loadStoreInfo();
        }

    }

    @Override
    protected void loadMore() {
        super.loadMore();
//        mPresenter.loadStoryList(nextPageNum());
    }

    @Override
    protected void initView() {
        super.initView();
        // 消除mRecyclerView刷新的动画。
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 || position == mData.size() + 1 ? 2 : 1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

//    @Override
//    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//        super.onItemClick(view, holder, position);
//    }

    private Store store;

    public void setStore(@NonNull Store store) {
        this.store = store;

        WidgetUtil.setTextNonNull(tv_store_name, store.getName());
        WidgetUtil.setTextNonNull(tv_store_place, store.getIntroduce());
        WidgetUtil.setTextNonNull(tv_store_distance, DistanceUtil.distance(store.getLat(), store.getLng()));

    }


    private TextView tv_store_name;
    private TextView tv_store_distance;
    private TextView tv_store_place;


    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_store_info_header, null);
        tv_store_name = mHeader.findViewById(R.id.tv_store_name);
        tv_store_distance = mHeader.findViewById(R.id.tv_store_distance);
        tv_store_place = mHeader.findViewById(R.id.tv_store_place);

        TabMenu tm_menu = mHeader.findViewById(R.id.tm_menu);
        tm_menu.addTab("chat", R.mipmap.ic_shop_chat, v -> chat());
//        tm_menu.addTab("favor", R.mipmap.ic_shop_favor);
//        tm_menu.addTab("map", R.mipmap.ic_shop_map);
        tm_menu.addTab("camera", R.mipmap.ic_shop_camera, v -> camera());

    }

    private void chat() {
        if (store == null || store.getBoss() == null) return;
        mPresenter.goChat(store.getBoss().getId(), store.getName());
    }

    private void camera() {

    }


    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }


}
