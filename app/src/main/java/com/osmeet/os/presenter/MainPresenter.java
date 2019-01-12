package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

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
        userModel = new UserModel();
    }

    @Override
    public void loadMyInfo() {
        if (App.MyInfo != null && App.ISCOMPLETE) {
            mView.showMyInfo(App.MyInfo);
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
                    User user = box.getData();
                    if (user.getExamineStatus() != -1
                            && user.getAvatar() != null
                            && user.getSex() > 0
                            && !TextUtils.isEmpty(user.getUsername())
                            && !TextUtils.isEmpty(user.getUsername())) {
                        log("用户信息完整！");
                        App.setComplete(true);
                        App.setMyInfo(user);
                        mView.showMyInfo(user);
                    } else {
                        log("用户信息不完整！");
                        App.setComplete(false);
                        goPopInfoAndFinish();
                    }
                }
            }
        });
    }

    private void goPopInfoAndFinish() {
        goPopInfo();
        toast("用户信息不完整，请完善信息！");
        finish();
        mActivity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

}
