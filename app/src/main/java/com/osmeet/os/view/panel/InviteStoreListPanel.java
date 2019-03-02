package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.event.StoreChooseEvent;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.ChatInviteContract;
import com.osmeet.os.view.adapter.ivd.Store2IVD;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/31.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InviteStoreListPanel extends BaseRecyclerPanel<Store, ChatInviteContract.IPresenter> {
    public InviteStoreListPanel(Context context, ChatInviteContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Store>> ivd) {
        ivd.add(new Store2IVD(context));
    }

    @Override
    protected void update() {
        mPresenter.loadStoreList(0);
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        EventBus.getDefault().post(new StoreChooseEvent(mData.get(position)));
        mPresenter.finish();

    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadStoreList(nextPageNum());
    }
}
