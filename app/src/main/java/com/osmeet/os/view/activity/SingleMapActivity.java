package com.osmeet.os.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.kongzue.dialog.v2.BottomMenu;
import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.SingleMapContract;
import com.osmeet.os.presenter.SingleMapPresenter;
import com.osmeet.os.view.panel.SingleMapPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SingleMapActivity extends BaseActivity<SingleMapContract.IPresenter> implements SingleMapContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new SingleMapPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_map;
    }


    SingleMapPanel singleMapPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(singleMapPanel = new SingleMapPanel(context, mPresenter));
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @OnClick(R.id.img_more)
    void more() {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.open_amap));
        BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                    switch (index) {
                        case 0:
                            singleMapPanel.goToAMap();
                            break;
                    }
                }, true, context.getString(R.string.cancel)
        ).setTitle(context.getString(R.string.please_choose));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        singleMapPanel.onSaveInstanceState(outState);
    }

}

