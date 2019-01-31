package com.osmeet.os.view.activity;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.InputDialog;
import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.UserInfo2Contract;
import com.osmeet.os.presenter.UserInfo2Presenter;
import com.osmeet.os.view.panel.UserInfo2RecyclerPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

public class UserInfo2Activity extends BaseActivity<UserInfo2Contract.IPresenter> implements UserInfo2Contract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new UserInfo2Presenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_panel;
    }

    UserInfo2RecyclerPanel userInfo2RecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(userInfo2RecyclerPanel = new UserInfo2RecyclerPanel(context, mPresenter));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        setTopBar();
        fl_panel.addView(getPanelView(0));
        fl_panel.addView(mTopBar);
        userInfo2RecyclerPanel.bindView("v", ll_tap_bar);
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
        img_back.setOnClickListener(v -> mPresenter.finish());
        ImageView img_menu = mTopBar.findViewById(R.id.img_menu);
        img_menu.setOnClickListener(v -> {
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
        });
    }

    private void reportDialog() {
        InputDialog.show(context, context.getString(R.string.report),
                context.getString(R.string.report_reason),
                context.getString(R.string.submit), (dialog, inputText) -> {
                    mPresenter.report(inputText);
                    dialog.dismiss();
                }, context.getString(R.string.cancel), (dialog, which) -> {
                    mPresenter.toast(context.getString(R.string.cancel));
                });
    }


    private void blockDialog() {
        SelectDialog.show(context, context.getString(R.string.warm),
                context.getString(R.string.block_this_user),
                context.getString(R.string.ok), (dialog, which) -> mPresenter.block(),
                context.getString(R.string.cancel), (dialog, which) -> {
                });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadUserInfo();
    }

    @Override
    public void showUserInfo(@NonNull User user) {
        userInfo2RecyclerPanel.setUser(user);
        // bar
        WidgetUtil.setTextNonNull(tv_name_top, user.getUsername());
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar_top);
    }
}

