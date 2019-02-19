package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InviteFriendIVD extends BaseIVD<User> {

    public InviteFriendIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_invite_friend_item;
    }

    @Override
    public void convert(ViewHolder holder, final User user, final int position) {
        ImageView img_avatar = holder.getView(R.id.img_avatar);
        TextView tv_name = holder.getView(R.id.tv_name);
        TextView tv_desc = holder.getView(R.id.tv_desc);
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar);
        WidgetUtil.setTextNonNull(tv_name, user.getUsername());
        WidgetUtil.setTextNonNull(tv_desc, user.getJob());

        ImageView img_select = holder.getView(R.id.img_select);

        if (select != null) {
            if (select.isSelect(user, position)) {
                img_select.setImageResource(R.mipmap.ic_gou_blue);
            } else {
                img_select.setImageResource(R.drawable.bg_button_gray);
            }
        }

    }

    private Select select;

    public InviteFriendIVD setSelect(Select select) {
        this.select = select;
        return this;
    }

    public interface Select {
        boolean isSelect(User user, int position);
    }
}
