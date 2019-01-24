package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Friend;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.NewFriendListContract;
import com.osmeet.os.view.adapter.ivd.NewFriendIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class NewFriendListRecyclerPanel extends BaseRecyclerPanel<Friend, NewFriendListContract.IPresenter> {
    public NewFriendListRecyclerPanel(Context context, NewFriendListContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Friend>> ivd) {
        ivd.add(new NewFriendIVD(context) {
            @Override
            public void convert(ViewHolder holder, final Friend friend, int position) {
                super.convert(holder, friend, position);
                holder.setOnClickListener(R.id.bt_add, v -> {
                    if (friend.getStatus() == Friend.APPLY) {
                        mPresenter.postAgreeNewFriend(friend.getUser().getId());
                    }
                });
            }
        });
    }

    @Override
    protected void update() {
        mPresenter.loadNewFriendList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadNewFriendList(nextPageNum());
    }

    public void agreeSuccess(@NonNull String userId) {
        for (Friend friend : mData) {
            if (friend.getUser().getId().equals(userId)) {
                friend.setStatus(Friend.AGREE);
                notifyDataSetChanged();
                break;
            }
        }
    }

//    @SuppressLint("InflateParams")
//    @Override
//    protected void setHeader() {
//        super.setHeader();
//        mHeader = mInflater.inflate(R.layout.layout_new_friend_header, null);
//        mHeader.findViewById(R.id.img_scan).setOnClickListener(v -> mPresenter.goScan());
//        mHeader.findViewById(R.id.img_friend_list).setOnClickListener(v -> mPresenter.goFriendList());
//
//        ImageView img_avatar = mHeader.findViewById(R.id.img_avatar);
//        User user = App.getInstance().getMyInfo();
//        if (user.getAvatar() != null) {
//            G.img(context, user.getAvatar().getUrl(), img_avatar);
//        }
//        img_avatar.setOnClickListener(v -> mPresenter.goVisitCard());
//    }
}
