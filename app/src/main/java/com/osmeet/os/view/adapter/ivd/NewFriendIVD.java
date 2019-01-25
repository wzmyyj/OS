package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Friend;
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

public class NewFriendIVD extends BaseIVD<Friend> {

    public NewFriendIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_new_friend_item;
    }

    @Override
    public void convert(ViewHolder holder, final Friend friend, final int position) {
        User user = friend.getUser();
        ImageView img_avatar = holder.getView(R.id.img_avatar);
        TextView tv_name = holder.getView(R.id.tv_name);
        TextView tv_desc = holder.getView(R.id.tv_desc);

        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar);
        WidgetUtil.setTextNonNull(tv_name, user.getUsername());
        WidgetUtil.setTextNonNull(tv_desc, friend.getMessage());

        Button bt_add = holder.getView(R.id.bt_add);
        switch (friend.getStatus()) {
            case Friend.APPLY:
                bt_add.setText(R.string.agree);
                bt_add.setBackgroundResource(R.drawable.bg_button_add);
                break;
            case Friend.CANCEL:
                bt_add.setText(R.string.cancel);
                bt_add.setBackgroundResource(R.drawable.bg_button_gray);
                break;
            case Friend.AGREE:
                bt_add.setText(R.string.already_add);
                bt_add.setBackgroundResource(R.drawable.bg_button_gray);
                break;
            case Friend.REFUSE:
                bt_add.setText(R.string.refuse);
                bt_add.setBackgroundResource(R.drawable.bg_button_gray);
                break;
            case Friend.DELETE:
                bt_add.setText(R.string.delete);
                bt_add.setBackgroundResource(R.drawable.bg_button_gray);
                break;
            default:
                bt_add.setText(R.string.block);
                bt_add.setBackgroundResource(R.drawable.bg_button_gray);
                break;
        }


        bt_add.setOnClickListener(v -> {
            if (onAddClickListener != null) {
                onAddClickListener.onClick(v, friend, position);
            }
        });

    }

    private OnAddClickListener onAddClickListener;

    public NewFriendIVD setOnAddClickListener(OnAddClickListener onAddClickListener) {
        this.onAddClickListener = onAddClickListener;
        return this;
    }

    public interface OnAddClickListener {
        void onClick(View v, Friend friend, int position);
    }

}
