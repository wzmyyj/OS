package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.InviteListContract;
import com.osmeet.os.view.adapter.ivd.InviteGroupIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteListRecyclerPanel extends BaseRecyclerPanel<MatchInvite.Group, InviteListContract.IPresenter> {
    public InviteListRecyclerPanel(Context context, InviteListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<MatchInvite.Group>> ivd) {
        ivd.add(new InviteGroupIVD(context));
    }

    @Override
    public void update() {
        mPresenter.loadMatchInviteList();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        String id = mData.get(position).getStore().getId();
        if (!TextUtils.isEmpty(id)) {
            mPresenter.goStore(id);
            mPresenter.finish();
        } else {
            mPresenter.toast("Store Id is a empty value!");
        }
    }
}
