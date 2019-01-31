package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MatchTeamIVD extends BaseIVD<MatchTeam> {

    public MatchTeamIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_match_team_item;
    }

    @Override
    public void convert(ViewHolder holder, MatchTeam matchTeam, int position) {
        ImageView img_os_bg = holder.getView(R.id.img_os_bg);
        ImageView img_user_avatar_1 = holder.getView(R.id.img_user_avatar_1);
        ImageView img_user_avatar_2 = holder.getView(R.id.img_user_avatar_2);
        TextView tv_os_when = holder.getView(R.id.tv_os_when);
        ImageView img_store_logo = holder.getView(R.id.img_store_logo);

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
            G.img(context, store.getLogoImage().getUrl(), img_store_logo);
        }
        if (MatchTeam.Wait_Accept_Meet_Time.equals(matchTeam.getTogetherState())) {
            img_os_bg.setImageResource(R.color.colorWMT);
            WidgetUtil.setTextRes(tv_os_when, R.string.confirm_time);
            WidgetUtil.setTextColor(tv_os_when, R.color.colorWhite);
        } else if (matchTeam.getTogetherState().contains("B")
                || matchTeam.getTogetherState().contains("C")) {
            img_os_bg.setImageResource(R.color.colorOs);
            WidgetUtil.setTextRes(tv_os_when, R.string.punch_card);
            WidgetUtil.setTextColor(tv_os_when, R.color.colorGray_5);
        } else if (matchTeam.getTogetherState().contains("Q")) {
            img_os_bg.setImageResource(R.color.colorGray_b);
            WidgetUtil.setTextRes(tv_os_when, R.string.meet_was_finish);
            WidgetUtil.setTextColor(tv_os_when, R.color.colorWhite);
        } else {
            img_os_bg.setImageResource(R.color.colorLittleBlue);
            WidgetUtil.setTextRes(tv_os_when, R.string.write_story);
            WidgetUtil.setTextColor(tv_os_when, R.color.colorWhite);
        }


    }
}
