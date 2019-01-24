package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.HomeStoreContract;
import com.osmeet.os.view.adapter.ivd.HomeStoreIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2018/12/10. email: 2209011667@qq.com
 */

public class HomeStoreRecyclerPanel extends BaseRecyclerPanel<Store, HomeStoreContract.IPresenter> {
    public HomeStoreRecyclerPanel(Context context, HomeStoreContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Store>> ivd) {
        ivd.add(new HomeStoreIVD(context));
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    @Override
    protected boolean isEnableLoadMore() {
        return true;
    }


    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        String id = mData.get(position).getId();
        if (!TextUtils.isEmpty(id)) {
            mPresenter.goStore(id);
        } else {
            mPresenter.toast("Store Id is a empty value!");
        }
    }

    @Override
    public void update() {
        mPresenter.log(mPresenter.getCategoryId());
        mPresenter.loadStoreList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadStoreList(nextPageNum());
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }
}
