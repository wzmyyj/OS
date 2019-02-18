package com.osmeet.os.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.InputDialog;
import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.event.StoreChooseEvent;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.presenter.ChatPresenter;
import com.osmeet.os.view.fragment.ConChatFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.tools.Sure;
import top.wzmyyj.wzm_sdk.utils.FragmentUtil;
import top.wzmyyj.wzm_sdk.utils.StatusBarUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

public class ChatActivity extends BaseActivity<ChatContract.IPresenter> implements ChatContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ChatPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    protected void initSome(Bundle savedInstanceState) {
        super.initSome(savedInstanceState);
        StatusBarUtil.initStatusBar(activity, false);
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @OnClick(R.id.img_menu)
    void menu() {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.report));
        list.add(context.getString(R.string.block));
        BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                    switch (index) {
                        case 0:
                            reportDialog();
                            break;
                        case 1:
                            blockDialog();
                            break;
                    }
                }, true, context.getString(R.string.cancel)
        ).setTitle(context.getString(R.string.please_choose));
    }

    private void reportDialog() {
        InputDialog.show(context, context.getString(R.string.report),
                context.getString(R.string.report_reason),
                context.getString(R.string.submit), (dialog, inputText) -> {
                    mPresenter.report(inputText);
                    dialog.dismiss();
                }, context.getString(R.string.cancel), (dialog, which) ->
                        mPresenter.toast(context.getString(R.string.cancel))
        );
    }


    private void blockDialog() {
        SelectDialog.show(context, context.getString(R.string.warm),
                context.getString(R.string.block_this_user),
                context.getString(R.string.ok), (dialog, which) -> mPresenter.block(),
                context.getString(R.string.cancel), (dialog, which) -> {
                });
    }

    @BindView(R.id.tv_title)
    TextView tv_title;
    private ConChatFragment conChatFragment;


    @Override
    protected void initView() {
        super.initView();

        conChatFragment = new ConChatFragment();
        FragmentUtil.add(getSupportFragmentManager(), R.id.fl_fragment, conChatFragment, "");
        Sure.sure(activity.getIntent().getData() != null, "Intent Data is null!");
        if (getIntent().getData() != null) {
            WidgetUtil.setTextNonNull(tv_title, getIntent().getData().getQueryParameter("title"));
        }

    }


    @Override
    protected void initEvent() {
        super.initEvent();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe
    public void onEvent(StoreChooseEvent event) {
        String userId = conChatFragment.getTargetId();
//        if (userId == null) mPresenter.toast("GG");
        if (event.getStore() != null && userId != null) {
            mPresenter.inviteFriends(event.getStore().getId(), userId);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showInviteFriendList(@NonNull List<MatchInvite2> matchInvite2List) {
        mPresenter.log("matchInvite2List.size=" + matchInvite2List.size());
    }
}

