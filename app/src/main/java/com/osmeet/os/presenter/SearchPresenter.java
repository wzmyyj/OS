package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.SearchContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class SearchPresenter extends BasePresenter<SearchContract.IView> implements SearchContract.IPresenter {

    public SearchPresenter(Activity activity, SearchContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void searchUser(@NonNull String word, int pageNum) {

    }

    @Override
    public void searchStore(@NonNull String word, int pageNum) {

    }
}
