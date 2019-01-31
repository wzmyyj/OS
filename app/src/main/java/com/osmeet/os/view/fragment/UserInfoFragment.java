package com.osmeet.os.view.fragment;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.presenter.UserInfoPresenter;
import com.osmeet.os.view.activity.StoreActivity;
import com.osmeet.os.view.panel.UserInfoRecyclerPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class UserInfoFragment extends BaseFragment<UserInfoContract.IPresenter> implements UserInfoContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new UserInfoPresenter(activity, this);
    }


    public void setInit(String userId, String unitId, String inviteId) {
        this.userId = userId;
        this.unitId = unitId;
        this.inviteId = inviteId;
    }

    private String userId;
    private String unitId;
    private String inviteId;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

    UserInfoRecyclerPanel userInfoRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(userInfoRecyclerPanel = new UserInfoRecyclerPanel(context, mPresenter).inFragment(this));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        setTopBar();
        fl_panel.addView(getPanelView(0));
        fl_panel.addView(mTopBar);
        userInfoRecyclerPanel.bindView("v", ll_tap_bar);
    }

    private View mTopBar;
    private TextView tv_name_top;
    private ImageView img_avatar_top;
    private LinearLayout ll_tap_bar;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_info_top_bar, null);
        tv_name_top = mTopBar.findViewById(R.id.tv_name_top);
        img_avatar_top = mTopBar.findViewById(R.id.img_avatar_top);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        ImageView img_back = mTopBar.findViewById(R.id.img_back);
        img_back.setOnClickListener(v -> ((StoreActivity) activity).setCurrentItem(0));
        ImageView img_menu = mTopBar.findViewById(R.id.img_menu);
        img_menu.setOnClickListener(v -> {
            List<String> list = new ArrayList<>();
            list.add(context.getString(R.string.report));
            list.add(context.getString(R.string.block));
            BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                        switch (index) {
                            case 0:
                                mPresenter.toast(text);
                                break;
                            case 1:
                                mPresenter.toast(text);
                                break;
                        }
                    }, true,
                    context.getString(R.string.cancel)
            ).setTitle(context.getString(R.string.please_choose));
        });
    }


    @Override
    protected void initData() {
        super.initData();
        mPresenter.setUserId(userId);
        mPresenter.setUnitId(unitId);
        mPresenter.setInviteId(inviteId);
        mPresenter.loadUserInfo();
    }

    @Override
    public void showUserInfo(@NonNull User user) {
        userInfoRecyclerPanel.setUser(user);
        // bar
        WidgetUtil.setTextNonNull(tv_name_top, user.getUsername());
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar_top);
    }

    @Override
    public void showInvite(boolean isSuccess, int what) {
        if (isSuccess) {
            if (what == 1) {
                userInfoRecyclerPanel.showMatchSuccess(true);
            } else if (what == 2) {
                SelectDialog.show(context, context.getString(R.string.tip),
                        context.getString(R.string.he_invite_before),
                        context.getString(R.string.yes), (dialog, which) -> mPresenter.matchInvite_accept(),
                        context.getString(R.string.no), (dialog, which) -> {
                        });
            }
        } else {
            userInfoRecyclerPanel.showMatchSuccess(false);
        }
    }
}