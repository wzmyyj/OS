package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.UpdateInfoContract;
import com.osmeet.os.presenter.UpdateInfoPresenter;
import com.osmeet.os.view.panel.UpdateInfoNeScrollPanel;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateInfoActivity extends BaseActivity<UpdateInfoContract.IPresenter> implements UpdateInfoContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new UpdateInfoPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_info;
    }

    UpdateInfoNeScrollPanel updateInfoNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(updateInfoNeScrollPanel = new UpdateInfoNeScrollPanel(context, mPresenter));
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @OnClick(R.id.tv_save)
    void save() {
        updateInfoNeScrollPanel.save();
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMyInfo();
    }

    @Override
    public void showMyInfo(@NonNull User user) {
        updateInfoNeScrollPanel.setUser(user);
    }
}

