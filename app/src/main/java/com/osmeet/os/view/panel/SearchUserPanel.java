package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.SearchContract;
import com.osmeet.os.view.adapter.ivd.SearchUserIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/24.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SearchUserPanel extends BaseRecyclerPanel<User, SearchContract.IPresenter> {
    public SearchUserPanel(Context context, SearchContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<User>> ivd) {
        ivd.add(new SearchUserIVD(context));
    }


    @Override
    protected void update() {
        if (getTag() != null)
            mPresenter.searchUser(getTag().toString(), 0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        if (getTag() != null)
            mPresenter.searchUser(getTag().toString(), nextPageNum());
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        mPresenter.goUserInfo2(mData.get(position).getId());
    }
}
