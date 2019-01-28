package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Token;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.java.MD5Util;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.LoginContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LoginPresenter extends BasePresenter<LoginContract.IView> implements LoginContract.IPresenter {

    private UserModel userModel;

    public LoginPresenter(Activity activity, LoginContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel();
    }

    @Override
    public void checkToken() {
        if (!App.getInstance().getToken().isEmpty()) {
            goMainAndFinish();
        }
    }

    private void goMainAndFinish() {
        goMain();
        finish(mView.FINISH_FADE_IN_OUT);
    }

    private void goPopInfoAndFinish() {
        goPopInfo();
        toast(getContext().getString(R.string.please_pop_user_info));
        finish(mView.FINISH_FADE_IN_OUT);
    }


    private String zoneCode;
    private String phone;

    @Override
    public void checkExists(String zoneCode, String phone) {
        this.zoneCode = zoneCode;
        this.phone = phone;
        userModel.user_existsByPhone(new PObserver<Box<Boolean>>() {
            @Override
            public void onNext(Box<Boolean> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData()) {
                    mView.showWhat(mView.LOGIN_SMS);
                    toast(getContext().getString(R.string.account_exist_please_login));
                } else {
                    mView.showWhat(mView.LOGIN_REGISTER);
                    toast(getContext().getString(R.string.account_not_exist_please_register));
                }
            }
        }, zoneCode, phone);
    }

    @Override
    public void loginSMS(String smsCode) {
        userModel.user_loginByPhone(new PObserver<Box<Token>>() {
            @Override
            public void onNext(Box<Token> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    App.getInstance().setToken(box.getData());
                    toast(getContext().getString(R.string.login_success));
                    loadUserInfo();
                }
            }
        }, zoneCode, phone, smsCode);
    }

    @Override
    public void loginPassword(String password) {
        String md5password = MD5Util.encrypt(password);
        userModel.user_loginByPhone(new PObserver<Box<Token>>() {

            @Override
            public void onNext(Box<Token> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    App.getInstance().setToken(box.getData());
                    toast(getContext().getString(R.string.login_success));
                    loadUserInfo();
                }
            }
        }, zoneCode, phone, md5password);
    }

    @Override
    public void register(String smsCode, String password) {
        String md5password = MD5Util.encrypt(password);
        userModel.user_registerByPhoneAndPass(new PObserver<Box<Token>>() {
            @Override
            public void onNext(Box<Token> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    App.getInstance().setToken(box.getData());
                    toast(getContext().getString(R.string.register_success_please_pop_info));
                    goPopInfoAndFinish();
                }
            }
        }, zoneCode, phone, smsCode, md5password);
    }


    @Override
    public void loadUserInfo() {
        userModel.user(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    mView.showFail(1, "Fail");
                    return;
                }
                if (box.getData() != null) {
                    User user = box.getData();
                    if (user.getExamineStatus() != -1
                            && user.getAvatar() != null
                            && user.getSex() > 0
                            && !TextUtils.isEmpty(user.getUsername())
                            && !TextUtils.isEmpty(user.getUsername())) {
                        App.getInstance().setComplete(true);
                        goMainAndFinish();
                    } else {
                        App.getInstance().setComplete(true);
                        goPopInfoAndFinish();
                    }
                }
                mView.showSuccess(1, "Success");


            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.showFail(1, "Fail");
            }
        });
    }

    @Override
    public void needSMSCode() {
        userModel.user_sendCode0000(new PObserver<Box<String>>() {

            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                }
            }
        }, zoneCode, phone);
    }
}
