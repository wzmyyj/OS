package com.osmeet.os.view.activity;

import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.SettingContract;
import com.osmeet.os.presenter.SettingPresenter;
import com.osmeet.os.view.panel.SettingNeScrollPanel;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity<SettingContract.IPresenter> implements SettingContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new SettingPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    SettingNeScrollPanel settingNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(settingNeScrollPanel = new SettingNeScrollPanel(context, mPresenter));
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
    }
}
