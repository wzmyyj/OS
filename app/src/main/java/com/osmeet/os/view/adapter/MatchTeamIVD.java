package com.osmeet.os.view.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseRecyclerIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MatchTeamIVD extends BaseRecyclerIVD<MatchTeam> {

    public MatchTeamIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_message_match_item;
    }

    @Override
    public void convert(ViewHolder holder, MatchTeam matchTeam, int position) {
        ImageView img_os_bg = holder.getView(R.id.img_os_bg);
        ImageView img_user_avatar_1 = holder.getView(R.id.img_user_avatar_1);
        ImageView img_user_avatar_2 = holder.getView(R.id.img_user_avatar_2);
        TextView tv_os_when = holder.getView(R.id.tv_os_when);
        ImageView img_shop_logo = holder.getView(R.id.img_shop_logo);

        Store store = matchTeam.getStore();
        User user1 = matchTeam.getUnita().getUser();
        User user2 = matchTeam.getUnitb().getUser();

        if (user1.getAvatar() != null) {
            G.img(context, user1.getAvatar().getUrl(), img_user_avatar_1);
        }
        if (user2.getAvatar() != null) {
            G.img(context, user2.getAvatar().getUrl(), img_user_avatar_2);
        }
        if (store.getLogoImage() != null) {
            G.img(context, store.getLogoImage().getUrl(), img_shop_logo);
        }
        img_os_bg.setImageResource(R.color.colorLittleBlue);
        WidgetUtil.setTextNonNull(tv_os_when, "" + matchTeam.getUnita().getMatchStatus());
    }
}
