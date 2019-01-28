package com.osmeet.os.view.panel;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.other.IvdVhHelper;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.MessageContract;
import com.osmeet.os.view.adapter.MatchTeamAdapter;
import com.osmeet.os.view.adapter.ivd.InviteGroupIVD;
import com.osmeet.os.view.widget.listener.AlphaNeScrollListener;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.fragment.IHistoryDataResultCallback;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.model.Conversation;
import top.wzmyyj.wzm_sdk.utils.FragmentUtil;


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
        mPresenter.loadMatchInviteList();
    }

    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.fl_when_empty)
    FrameLayout fl_when_empty;
    private MatchTeamAdapter mAdapter;
    private List<MatchTeam> mData;
    private IvdVhHelper<MatchInvite.Group> ivdVhHelper;

    private ConversationListFragment conversationListFragment;

    @Override
    protected void initView() {
        super.initView();
        mData = new ArrayList<>();
        rv_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rv_list.setAdapter(mAdapter = new MatchTeamAdapter(context, mData));

        ivdVhHelper = new IvdVhHelper<MatchInvite.Group>(context, new InviteGroupIVD(context), ll_invite);


        conversationListFragment = new ConversationListFragment();
        FragmentUtil.add(fragment.getChildFragmentManager(), R.id.fl_fragment, conversationListFragment, "");
    }

    Conversation.ConversationType[] mConversationsTypes;

    @Override
    protected void initData() {
        super.initData();
        Uri uri = Uri.parse("rong://" + context.getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//群组
                .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//订阅号
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")//系统
                .build();
        conversationListFragment.setUri(uri);
        conversationListFragment.setAdapter(new ConversationListAdapter(context));

        mConversationsTypes = new Conversation.ConversationType[]{Conversation.ConversationType.PRIVATE,
                Conversation.ConversationType.GROUP,
                Conversation.ConversationType.PUBLIC_SERVICE,
                Conversation.ConversationType.APP_PUBLIC_SERVICE,
                Conversation.ConversationType.SYSTEM
        };

        conversationListFragment.getConversationList(mConversationsTypes, new IHistoryDataResultCallback<List<Conversation>>() {
            @Override
            public void onResult(List<Conversation> conversations) {

            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    protected void initListener() {
        super.initListener();
        mNestedScrollView.setOnScrollChangeListener(
                new AlphaNeScrollListener(context, this::barAlpha));

        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                String matchId = mData.get(position).getId();
                if (!TextUtils.isEmpty(matchId)) {
                    mPresenter.goMatch(matchId);
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void barAlpha(float alpha) {
        View bar = getBindView("v");
        if (bar != null) {
            bar.setAlpha(alpha);
        }
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

    private boolean isHaveInvite = false;

    @OnClick(R.id.ll_invite)
    void go_invite() {
        if (isHaveInvite) {
            mPresenter.goInviteList();
        }

    }

    @BindView(R.id.ll_invite)
    LinearLayout ll_invite;
    @BindView(R.id.ll_invite_empty)
    LinearLayout ll_invite_empty;


    public void setMatchInviteGroup(MatchInvite.Group group) {
        if (group == null) {
            ll_invite_empty.setVisibility(View.VISIBLE);
            isHaveInvite = false;
        } else {
            ll_invite_empty.setVisibility(View.GONE);
            ivdVhHelper.convert(group);
            isHaveInvite = true;
        }
    }

}
