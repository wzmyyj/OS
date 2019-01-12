package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.MessageContract;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;


/**
 * Created by yyj on 2018/12/25. email: 2209011667@qq.com
 */

public class MessageNeScrollPanel extends BaseNeScrollPanel<MessageContract.IPresenter> {
    public MessageNeScrollPanel(Context context, MessageContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_message_content;
    }

    @Override
    public void update() {
        mPresenter.loadMatchTeamList();
        mPresenter.loadMatchTeamList();
    }

    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.fl_when_empty)
    FrameLayout fl_when_empty;
    private CommonAdapter mAdapter;
    private List<MatchTeam> mData;

    @Override
    protected void initView() {
        super.initView();
        mData = new ArrayList<>();
        rv_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rv_list.setAdapter(mAdapter = new CommonAdapter<MatchTeam>(context,
                R.layout.layout_message_os_item, mData) {

            @Override
            protected void convert(ViewHolder holder, MatchTeam matchTeam, int position) {
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
                WidgetUtil.setTextNotNull(tv_os_when, "" + matchTeam.getUnita().getMatchStatus());
            }
        });

    }

    @Override
    protected void initListener() {
        super.initListener();
        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            //当距离在[0,maxDistance]变化时，透明度在[0,255之间变化]
            int maxDistance = DensityUtil.dp2px(context, 150);
            int mDistance = 0;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                mDistance = scrollY;
                float percent = mDistance * 1f / maxDistance;//百分比
                View bar = mViewMap.get("v");
                if (bar != null)
                    bar.setAlpha(percent);
            }
        });
    }

    public void matchTeamList(@NonNull List<MatchTeam> matchTeamList) {
        if (matchTeamList.size() == 0) {
            fl_when_empty.setVisibility(View.VISIBLE);
        } else {
            fl_when_empty.setVisibility(View.GONE);
        }
        mData.clear();
        mData.addAll(matchTeamList);
        mAdapter.notifyDataSetChanged();
    }

    public void matchInviteList(@NonNull List<MatchInvite> matchInviteList) {

    }
}
