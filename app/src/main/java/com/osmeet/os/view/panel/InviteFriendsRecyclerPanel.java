package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.InviteFriendsContract;
import com.osmeet.os.view.adapter.ivd.InviteFriendIVD;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InviteFriendsRecyclerPanel extends BaseRecyclerPanel<User, InviteFriendsContract.IPresenter> {
    public InviteFriendsRecyclerPanel(Context context, InviteFriendsContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<User>> ivd) {
        ivd.add(new InviteFriendIVD(context).setSelect((user, position) ->
                userIdList.contains(user.getId())));
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
        User user = mData.get(position);
        if (!userIdList.contains(user.getId())) {
            userIdList.add(user.getId());
        } else {
            userIdList.remove(user.getId());
        }
        setButtonState();
        notifyDataSetChanged();
    }

    private List<String> userIdList = new ArrayList<>();

    public List<String> getUserIdList() {
        return userIdList;
    }

    private void setButtonState() {
        Button bt = getBindView("bt");
        if (bt == null) return;
        if (userIdList.size() > 0) {
            bt.setBackgroundResource(R.drawable.bg_button_add);
        } else {
            bt.setBackgroundResource(R.drawable.bg_button_gray);
        }
    }

}
