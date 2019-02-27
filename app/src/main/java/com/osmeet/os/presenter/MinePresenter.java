package com.osmeet.os.presenter;


import android.support.v4.app.Fragment;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class MinePresenter extends BasePresenter<MineContract.IView> implements MineContract.IPresenter {

    private UserModel userModel;

    public MinePresenter(Fragment fragment, MineContract.IView iv) {
        super(fragment, iv);
        userModel = new UserModel().bind(fragment);
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
    public void loadStoryList(int pageNum) {
        mView.showStoryList(Story.testList(20),pageNum);
    }
}
