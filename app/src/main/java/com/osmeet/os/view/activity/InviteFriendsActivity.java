package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.InviteFriendsContract;
import com.osmeet.os.presenter.InviteFriendsPresenter;
import com.osmeet.os.view.panel.InviteFriendsRecyclerPanel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class InviteFriendsActivity extends BaseActivity<InviteFriendsContract.IPresenter> implements InviteFriendsContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new InviteFriendsPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_invite_friends;
    }


    InviteFriendsRecyclerPanel inviteFriendsRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                inviteFriendsRecyclerPanel = new InviteFriendsRecyclerPanel(context, mPresenter)
        );
    }

    @BindView(R.id.bt_send)
    Button bt_send;

    @OnClick(R.id.bt_send)
    void send() {
        List<String> idList = inviteFriendsRecyclerPanel.getUserIdList();
        if (idList == null || idList.size() == 0) return;
        mPresenter.inviteFriends(idList);

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
        fl_panel.addView(getPanelView(0));
        inviteFriendsRecyclerPanel.bindView("bt", bt_send);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadFriendList(0);
    }


    @Override
    public void showFriendList(@NonNull List<User> userList, int pageNum) {
        inviteFriendsRecyclerPanel.setDataList(userList, pageNum);
    }

    @Override
    public void showInviteFriendList(@NonNull List<MatchInvite2> matchInvite2List) {
        if (matchInvite2List.size() > 0){
            mPresenter.toast(context.getString(R.string.invite_success));
            mPresenter.finish();
        }

    }
}
