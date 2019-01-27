package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

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
        toast("用户信息不完整，请完善信息！");
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
                    toast("账号已存在，请登录！");
                } else {
                    mView.showWhat(mView.LOGIN_REGISTER);
                    toast("账号不存在，先注册！");
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
                    toast("登录成功!");
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
                    toast("登录成功!");
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
                    toast("注册成功:请完善信息！");
                    goPopInfoAndFinish();
                }
            }
        }, zoneCode, phone, smsCode, md5password);
    }


    @Override
    public void loadUserInfo() {
        log("正在获取用户信息!");
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
                        log("用户信息完整！");
                        App.getInstance().setComplete(true);
                        goMainAndFinish();
                    } else {
                        log("用户信息不完整！");
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
