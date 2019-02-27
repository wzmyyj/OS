package com.osmeet.os.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.HomeStoreContract;
import com.osmeet.os.presenter.HomeStorePresenter;
import com.osmeet.os.view.panel.HomeStoreRecyclerPanel;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class HomeStoreFragment extends BaseFragment<HomeStoreContract.IPresenter> implements HomeStoreContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new HomeStorePresenter(fragment, this);
    }


    public static HomeStoreFragment newInstance(@NonNull String categoryId) {
        HomeStoreFragment homeStoreFragment = new HomeStoreFragment();
        Bundle bundle = new Bundle();
        bundle.putString("categoryId", categoryId);
        homeStoreFragment.setArguments(bundle);
        return homeStoreFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panel;
    }

    private HomeStoreRecyclerPanel storeListRecyclerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(storeListRecyclerPanel = new HomeStoreRecyclerPanel(context, mPresenter));
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
        if (getArguments() != null) {
            String categoryId = getArguments().getString("categoryId");
            if (categoryId == null) return;
            mPresenter.setCategoryId(categoryId);
            mPresenter.loadStoreList(0);
        }

    }

    @Override
    public void showStoreList(@NonNull List<Store> storeList, int pageNum) {
        storeListRecyclerPanel.setDataList(storeList, pageNum);
    }
}
