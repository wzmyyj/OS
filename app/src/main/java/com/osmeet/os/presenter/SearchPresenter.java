package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.SearchContract;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class SearchPresenter extends BasePresenter<SearchContract.IView> implements SearchContract.IPresenter {

    private UserModel userModel;
    private StoreModel storeModel;

    public SearchPresenter(Activity activity, SearchContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel().bind((AppCompatActivity) activity);
        storeModel = new StoreModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void searchUser(@NonNull String word, int pageNum) {
        userModel.user_searchUser(new PObserver<Box<ListContent<User>>>() {
            @Override
            public void onNext(Box<ListContent<User>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showSearchUserResult(box.getData().getContent(), word, pageNum);
                }
            }
        }, word, pageNum, 20);
    }

    @Override
    public void searchStore(@NonNull String word, int pageNum) {
        storeModel.store_findByCondition(new PObserver<Box<ListContent<Store>>>() {
            @Override
            public void onNext(Box<ListContent<Store>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showSearchStoreResult(box.getData().getContent(), word, pageNum);
                }
            }
        }, new ConditionBody(word), pageNum, 20);
    }
}
