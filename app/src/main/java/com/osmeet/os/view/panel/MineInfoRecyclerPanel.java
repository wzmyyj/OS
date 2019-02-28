package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.view.adapter.ivd.StoryIVD;
import com.osmeet.os.view.panel.simple.UserInfoPanel;
import com.osmeet.os.view.widget.listener.AlphaReScrollListener;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class MineInfoRecyclerPanel extends BaseRecyclerPanel<Story, MineContract.IPresenter> {
    public MineInfoRecyclerPanel(Context context, MineContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }


    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
    }

    @Override
    public void update() {
        mPresenter.freshMyInfo();
        mPresenter.loadStoryList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
//        mPresenter.loadStoryList(nextPageNum());
    }


    private UserInfoPanel userInfoPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(userInfoPanel = new UserInfoPanel(context));
    }

    @Override
    protected void initView() {
        super.initView();
        // 消除mRecyclerView刷新的动画。
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRecyclerView.addOnScrollListener(new AlphaReScrollListener(context, this::barAlpha));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 || position == mData.size() + 1 ? 2 : 1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void barAlpha(float alpha) {
        View bar = getBindView("v");
        if (bar != null) {
            bar.setAlpha(alpha);
        }
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);

    }

    public void setUser(@NonNull User user) {
        userInfoPanel.setUser(user);

        if (user.getAvatar() != null) {
            G.img(context, user.getAvatar().getUrl(), img_avatar);
        }

    }


    private ImageView img_avatar;

    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_mine_info_header, null);
        img_avatar = mHeader.findViewById(R.id.img_user_avatar);
        FrameLayout fl_panel = mHeader.findViewById(R.id.fl_panel);
        fl_panel.addView(getPanelView(0));

        mHeader.findViewById(R.id.img_user_code)
                .setOnClickListener(v -> mPresenter.goVisitCard());

        mHeader.findViewById(R.id.tv_update_info)
                .setOnClickListener(v -> mPresenter.goUpdateInfo());

    }


    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }


}
