package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.SearchContract;
import com.osmeet.os.presenter.SearchPresenter;

import java.util.List;

public class SearchActivity extends BaseActivity<SearchContract.IPresenter> implements SearchContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new SearchPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void showSearchUserResult(@NonNull List<User> userList, @NonNull String word, int pageNum) {

    }

    @Override
    public void showSearchStoreResult(@NonNull List<Store> storeList, @NonNull String word, int pageNum) {

    }
}

