package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.InviteListContract;
import com.osmeet.os.view.panel.bean.MatchStoreInvite;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                ImageView img_store_logo = holder.getView(R.id.img_store_logo);
                TextView tv_store_name = holder.getView(R.id.tv_store_name);
                TextView tv_store_invite_num = holder.getView(R.id.tv_store_invite_num);

                List<ImageView> imageViewList = new ArrayList<>();
                imageViewList.add(holder.getView(R.id.img_u_1));
                imageViewList.add(holder.getView(R.id.img_u_2));
                imageViewList.add(holder.getView(R.id.img_u_3));
                imageViewList.add(holder.getView(R.id.img_u_4));

                Store store = matchStore.getStore();
                if (store.getLogoImage() != null) {
                    G.img(context, store.getLogoImage().getUrl(), img_store_logo);
                }

                List<MatchInvite> inviteList = matchStore.getInviteList();
                WidgetUtil.setTextNotNull(tv_store_name, store.getName());
                WidgetUtil.setTextNumber(tv_store_invite_num, inviteList.size());

                for (int i = 0; i < 4 && i < inviteList.size(); i++) {
                    User user = inviteList.get(i).getMatchUnit().getUser();
                    if (user.getAvatar() != null) {
                        G.img(context, user.getAvatar().getUrl(), imageViewList.get(i));
                    }
                }
            }
        });
    }

    @Override
    public void update() {
        mPresenter.loadMatchInviteList();
    }


    public void matchInviteList(@NonNull List<MatchInvite> matchInviteList) {
        if (matchInviteList.size() == 0) return;


        /*分组算法**/
        @SuppressLint("UseSparseArrays")
        Map<String, List<MatchInvite>> miIdMap = new HashMap<>();
        for (MatchInvite invite : matchInviteList) {
            List<MatchInvite> tempList = miIdMap.get(invite.getMatchUnit().getStore().getId());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(invite);
                miIdMap.put(invite.getMatchUnit().getStore().getId(), tempList);
            } else {
                /*某个invite之前已经存放过了,则直接追加数据到原来的List里**/
                tempList.add(invite);
            }
        }


        List<MatchStoreInvite> msiList = new ArrayList<>();
        for (Map.Entry<String, List<MatchInvite>> entry : miIdMap.entrySet()) {
            MatchStoreInvite msi = new MatchStoreInvite();
            msi.setInviteList(entry.getValue());
            msi.setStore(entry.getValue().get(0).getMatchUnit().getStore());
            msiList.add(msi);
        }

        mData.clear();
        mData.addAll(msiList);
        notifyDataSetChanged();

    }

}
