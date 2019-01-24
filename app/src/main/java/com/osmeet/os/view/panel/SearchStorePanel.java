package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.SearchContract;
import com.osmeet.os.view.adapter.ivd.SearchStoreIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/24.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SearchStorePanel extends BaseRecyclerPanel<Store, SearchContract.IPresenter> {
    public SearchStorePanel(Context context, SearchContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Store>> ivd) {
        ivd.add(new SearchStoreIVD(context));
    }

    @Override
    protected void update() {
        if (getTag() != null)
            mPresenter.searchStore(getTag().toString(), 0);
    }


    @Override
    protected void loadMore() {
        super.loadMore();
        if (getTag() != null)
            mPresenter.searchStore(getTag().toString(), nextPageNum());
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        mPresenter.goStore(mData.get(position).getId());
    }
}
