package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.InviteListContract;
import com.osmeet.os.view.panel.bean.MatchStoreInvite;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;


/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteListRecyclerPanel extends BaseRecyclerPanel<MatchStoreInvite, InviteListContract.IPresenter> {
    public InviteListRecyclerPanel(Context context, InviteListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<MatchStoreInvite>> ivd) {
        ivd.add(new SingleIVD<MatchStoreInvite>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_message_invite_item;
            }

            @Override
            public void convert(ViewHolder holder, MatchStoreInvite matchStore, int position) {

            }
        });
    }

    @Override
    public void update() {

    }


    public void matchInviteList(@NonNull List<MatchInvite> matchInviteList) {
        if (matchInviteList.size() == 0) return;
        List<MatchStoreInvite> msiList=new ArrayList<>();

        Store store=matchInviteList.get(0).getMatchUnit().getStore();
        MatchStoreInvite msi=new MatchStoreInvite(store);
        msiList.add(msi);
        int j=0;
        for(int i=0;i<matchInviteList.size();i++){
            if(matchInviteList.get(i).getMatchUnit().getStore().getId().equals(msiList.get(j).getStore().getId())){
                msiList.get(j).addInvite(matchInviteList.get(i));
            }else{

            }
        }

    }

}
