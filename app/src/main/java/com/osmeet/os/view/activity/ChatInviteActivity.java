package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ChatInviteContract;
import com.osmeet.os.presenter.ChatInvitePresenter;
import com.osmeet.os.view.panel.InviteStoreListPanel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class ChatInviteActivity extends BaseActivity<ChatInviteContract.IPresenter> implements ChatInviteContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ChatInvitePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat_invite;
    }


    InviteStoreListPanel inviteStoreListPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(inviteStoreListPanel = new InviteStoreListPanel(context, mPresenter));
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        mSwipeBackLayout.setEdgeTrackingEnabled(
                SwipeBackLayout.EDGE_BOTTOM);// 没有TOP的，差评。(╯‵□′)╯︵┻━┻
        fl_panel.addView(getPanelView(0));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadStoreList(0);
    }

    @Override
    public void showStoreList(@NonNull List<Store> storeList, int pageNum) {
        inviteStoreListPanel.setDataList(storeList, pageNum);
    }
}

