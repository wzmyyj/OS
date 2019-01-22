package com.osmeet.os.view.fragment;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.HomeStoreContract;
import com.osmeet.os.presenter.HomeStorePresenter;
import com.osmeet.os.view.panel.HomeStoreRecyclerPanel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class HomeStoreFragment extends BaseFragment<HomeStoreContract.IPresenter> implements HomeStoreContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new HomeStorePresenter(activity, this);
        if (!TextUtils.isEmpty(categoryId)) {
            mPresenter.setCategoryId(categoryId);
        }
    }

    private String categoryId;

    public void setCategoryId(@NonNull String categoryId) {// 必须。
        this.categoryId = categoryId;
        if (mPresenter != null) {
            mPresenter.setCategoryId(categoryId);
        }
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
        mPresenter.log(mPresenter.getCategoryId());
        mPresenter.loadStoreList(0);
    }

    @Override
    public void showStoreList(@NonNull List<Store> storeList, int pageNum) {
        List<Store> list = new ArrayList<>();
        list.addAll(storeList);
        list.addAll(storeList);
        list.addAll(storeList);
        list.addAll(storeList);
        list.addAll(storeList);
        list.addAll(storeList);
        list.addAll(storeList);
        storeListRecyclerPanel.setDataList(list, pageNum == 0);
    }
}
