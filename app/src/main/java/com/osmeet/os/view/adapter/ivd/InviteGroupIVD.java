package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InviteGroupIVD extends BaseIVD<MatchInvite.Group> {
    public InviteGroupIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_invite_item;
    }

    @Override
    public void convert(ViewHolder holder, MatchInvite.Group group, int position) {
        ImageView img_store_logo = holder.getView(R.id.img_store_logo);
        TextView tv_store_name = holder.getView(R.id.tv_store_name);
        TextView tv_store_invite_num = holder.getView(R.id.tv_store_invite_num);

        List<ImageView> imageViewList = new ArrayList<>();
        imageViewList.add(holder.getView(R.id.img_u_1));
        imageViewList.add(holder.getView(R.id.img_u_2));
        imageViewList.add(holder.getView(R.id.img_u_3));
        imageViewList.add(holder.getView(R.id.img_u_4));

        Store store = group.getStore();
        if (store.getLogoImage() != null) {
            G.img(context, store.getLogoImage().getUrl(), img_store_logo);
        }

        List<MatchInvite> inviteList = group.getInviteList();
        WidgetUtil.setTextNonNull(tv_store_name, store.getName());
        WidgetUtil.setTextNumber(tv_store_invite_num, inviteList.size());

        for (int i = 0; i < 4 && i < inviteList.size(); i++) {
            User user = inviteList.get(i).getMatchUnit().getUser();
            if (user.getAvatar() != null) {
                imageViewList.get(i).setVisibility(View.VISIBLE);
                G.img(context, user.getAvatar().getUrl(), imageViewList.get(i));
            } else {
                imageViewList.get(i).setVisibility(View.GONE);
            }
        }
    }
}
