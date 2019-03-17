package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.dialog.v2.InputDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.contract.UserInfo2Contract;
import com.osmeet.os.view.panel.simple.UserInfoPanel;
import com.osmeet.os.view.widget.listener.AlphaReScrollListener;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class UserInfo2RecyclerPanel extends StoryRecyclerPanel<UserInfo2Contract.IPresenter> {
    public UserInfo2RecyclerPanel(Context context, UserInfo2Contract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    public void update() {
        mPresenter.loadUserInfo();
        mPresenter.loadStoryList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadStoryList(nextPageNum());
    }

    private UserInfoPanel userInfoPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(userInfoPanel = new UserInfoPanel(context));
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRecyclerView.addOnScrollListener(new AlphaReScrollListener(context, this::barAlpha));
    }

    private void barAlpha(float alpha) {
        View bar = getBindView("v");
        if (bar != null) {
            bar.setAlpha(alpha);
        }
    }


    public void setUser(@NonNull User user) {
        userInfoPanel.setUser(user);

        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar);

        if (isFriend = user.getFriendRelationship() == 2) {
            tv_add_friend.setText(R.string.send_message);
        } else {
            tv_add_friend.setText(R.string.add_be_friends);
        }
        title = user.getUsername();
    }


    private ImageView img_avatar;
    private TextView tv_add_friend;
    private boolean isFriend = false;
    private String title;


    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_user_info_header, null);

        img_avatar = mHeader.findViewById(R.id.img_user_avatar);
        FrameLayout fl_panel = mHeader.findViewById(R.id.fl_panel);
        fl_panel.addView(getPanelView(0));

        tv_add_friend = mHeader.findViewById(R.id.tv_add_friend);
        tv_add_friend.setOnClickListener(v -> click());
    }

    private void click() {
        if (isFriend) {
            mPresenter.goChat(mPresenter.getUserId(), title);
        } else {
            addFriend();
        }
    }


    private void addFriend() {
        InputDialog.show(context,
                context.getString(R.string.add_be_friends),
                context.getString(R.string.greet_to_new_friend),
                context.getString(R.string.submit),
                (dialog, inputText) -> {
                    if (TextUtils.isEmpty(inputText)) return;
                    mPresenter.addFriend(inputText);
                    dialog.dismiss();
                },
                context.getString(R.string.cancel),
                (dialog, which) -> mPresenter.toast(context.getString(R.string.cancel))
        );
    }


    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }

}
