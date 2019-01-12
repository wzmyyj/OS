package com.osmeet.os.view.activity;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.SearchContract;
import com.osmeet.os.presenter.SearchPresenter;

public class SearchActivity extends BaseActivity<SearchContract.IPresenter> implements SearchContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new SearchPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

}

