package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.InviteListContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;


/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteListRecyclerPanel extends BaseRecyclerPanel<MatchInvite, InviteListContract.IPresenter> {
    public InviteListRecyclerPanel(Context context, InviteListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<MatchInvite>> ivd) {
        ivd.add(new SingleIVD<MatchInvite>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_message_invite_item;
            }

            @Override
            public void convert(ViewHolder holder, MatchInvite matchInvite, int position) {

            }
        });
    }

    @Override
    public void update() {

    }


    public void matchInviteList(@NonNull List<MatchInvite> matchInviteList) {

    }
}
