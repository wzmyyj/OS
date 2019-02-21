package com.osmeet.os.presenter;

import android.app.Activity;
import android.os.Handler;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.RcToken;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.LaunchContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LaunchPresenter extends BasePresenter<LaunchContract.IView> implements LaunchContract.IPresenter {

    public LaunchPresenter(Activity activity, LaunchContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void checkPermission() {

    }

    @Override
    public void init() {
        App.getInstance().getLanguageManager().initLanguage(context);
        App.getInstance().setMyInfo(null);
        if (!App.getInstance().getToken().isEmpty()) {
            loadMyInfo();
            connectRc();
        }
    }


    private void connectRc() {
        if (!App.getInstance().getRcToken().isEmpty()) {
            App.getInstance().connectRc();
            return;
        }
        new UserModel().user_getRyToken(new PObserver<Box<RcToken>>() {
            @Override
            public void onNext(Box<RcToken> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    App.getInstance().setRcToken(box.getData());
                    App.getInstance().connectRc();
                }
            }
        });
    }

    private void loadMyInfo() {
        new UserModel().user(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    User user = box.getData();
                    App.getInstance().setMyInfo(user);
                }
            }
        });
    }

    private long delayMillis() {
        return 1000;
    }

    private void goTo() {
        if (App.getInstance().getSetting().isOnce()) {
            goGuide();// 前往引导页。
        } else if (App.getInstance().getSetting().isAd()) {
            goAd();// 前往广告。
        } else if (App.getInstance().getToken().isEmpty()) {
            goLogin();// 前往登录。
        } else if (App.getInstance().getMyInfo() == null) {
            App.getInstance().clearToken();
            goLogin();
        } else if (!App.getInstance().getMyInfo().isComplete()) {
            goPopInfo();
        } else {
            goMain();
        }
        finish(mView.FINISH_FADE_IN_OUT);
    }

    @Override
    public void go() {
        new Handler().postDelayed(this::goTo, delayMillis());
    }


}
