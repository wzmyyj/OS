package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class MinePresenter extends BasePresenter<MineContract.IView> implements MineContract.IPresenter {

    private UserModel userModel;
    private StoreModel storeModel;

    public MinePresenter(Activity activity, MineContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel();
        storeModel = new StoreModel();
    }

    @Override
    public void loadMyInfo() {
        if (App.getInstance().getMyInfo() != null) {
            mView.showMyInfo(App.getInstance().getMyInfo());
            return;
        }
        freshMyInfo();
    }

    @Override
    public void freshMyInfo() {
        userModel.user(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    User user = box.getData();
                    App.getInstance().setMyInfo(user);
                    App.getInstance().refreshRcUser(user);
                    mView.showMyInfo(user);
                }
            }
        });
    }

    @Override
    public void loadMyStoreList() {
        storeModel.store_getStore(new PObserver<Box<List<Store>>>() {
            @Override
            public void onNext(Box<List<Store>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                List<Store> storeList = new ArrayList<>();
                if (box.getData() != null) {
                    storeList.addAll(box.getData());
                }
                mView.showMyStoreList(storeList);
            }
        });
    }
}
