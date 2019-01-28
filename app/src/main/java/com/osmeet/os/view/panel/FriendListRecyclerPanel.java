package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.FriendListContract;
import com.osmeet.os.view.adapter.ivd.FriendIVD;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FriendListRecyclerPanel extends BaseRecyclerPanel<User, FriendListContract.IPresenter> {
    public FriendListRecyclerPanel(Context context, FriendListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<User>> ivd) {
        ivd.add(new FriendIVD(context));
    }

    @Override
    protected void update() {
        mPresenter.loadFriendList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadFriendList(nextPageNum());
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        mPresenter.goUserInfo2(mData.get(position - 1).getId());
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        this.mLongClickPosition = position;
        menu();
        return true;
    }

    private int mLongClickPosition = -1;

    protected void menu() {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.delete));
        BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                    switch (index) {
                        case 0:
                            dialog();
                            break;
                    }
                }, true, context.getString(R.string.cancel)
        ).setTitle(context.getString(R.string.please_choose));
    }

    private void dialog() {
        SelectDialog.show(context, context.getString(R.string.warm),
                context.getString(R.string.delete_this_friend),
                context.getString(R.string.ok), (dialog, which) ->
                        mPresenter.deleteFriend(mData.get(mLongClickPosition - 1).getId()),
                context.getString(R.string.cancel), (dialog, which) -> {
                });
    }

    public void removeFriend(@NonNull String userId) {
        for (User user : mData) {
            if (user.getId().equals(userId)) {
                mData.remove(user);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void setNewFriendNum(int num) {
        if (num == 0) {
            WidgetUtil.setTextNonNull(tv_desc, "");
        } else {
            WidgetUtil.setTextNonNull(tv_desc, "+" + num);
        }
    }


    private TextView tv_desc;

    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_friend_list_header, null);
        ImageView img_avatar = mHeader.findViewById(R.id.img_avatar);
        TextView tv_name = mHeader.findViewById(R.id.tv_name);
        tv_desc = mHeader.findViewById(R.id.tv_desc);
        G.img(context, R.mipmap.ic_menu_add_friends, img_avatar);
        WidgetUtil.setTextNonNull(tv_name, context.getString(R.string.new_friends));
        WidgetUtil.setTextColor(tv_desc, R.color.colorPay);
        mHeader.setOnClickListener(v -> mPresenter.goNewFriends());
    }
}
