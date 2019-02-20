package com.osmeet.os.view.activity;

import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.AccountContract;
import com.osmeet.os.presenter.AccountPresenter;
import com.osmeet.os.view.panel.AccountNeScrollPanel;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountActivity extends BaseActivity<AccountContract.IPresenter> implements AccountContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new AccountPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }


    AccountNeScrollPanel accountNeScrollPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                accountNeScrollPanel = new AccountNeScrollPanel(context, mPresenter)
        );
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

