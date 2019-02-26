package com.osmeet.os.view.fragment;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.presenter.StoreInfoPresenter;
import com.osmeet.os.view.panel.StoreInfoRecyclerPanel;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class StoreInfoFragment extends BaseFragment<StoreInfoContract.IPresenter> implements StoreInfoContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new StoreInfoPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

    StoreInfoRecyclerPanel storeInfoRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(storeInfoRecyclerPanel = new StoreInfoRecyclerPanel(context, mPresenter));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected boolean isRefreshRootView() {
        return true;
    }

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadStoreInfo();
    }


    @Override
    public void showStoreInfo(@NonNull Store store) {// 给自己的mPresenter调用。（刷新）
        storeInfoRecyclerPanel.setStore(store);
    }




    @Override
    public void showStoryList(@NonNull List<Story> storyList) {

    }
}
