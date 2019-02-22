package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MainContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class MainPresenter extends BasePresenter<MainContract.IView> implements MainContract.IPresenter {

    private UserModel userModel;

    public MainPresenter(Activity activity, MainContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void loadMyInfo() {
        if (App.getInstance().getMyInfo() != null) {
            mView.showMyInfo(App.getInstance().getMyInfo());
            return;
        }
        userModel.user(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }


                if (box.getData() != null) {
                    mView.showMyInfo(box.getData());
                }
            }
        });
    }

    @Override
    public void sendLocation(double lng, double lat) {
        userModel.user_updateAddress(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                log("" + box.getData());
            }
        }, lng, lat);
    }

}
