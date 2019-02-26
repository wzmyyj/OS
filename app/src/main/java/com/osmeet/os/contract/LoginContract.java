package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 登录与注册。
 */

public interface LoginContract {

    interface IView extends BaseContract.IView {

        int LOGIN_PASSWORD = 1;
        int LOGIN_SMS = 2;
        int LOGIN_REGISTER = 3;

        void showWhat(int w);

        void showBack();

        void showLoadUserInfo(boolean isSuccess);
    }

    interface IPresenter extends BaseContract.IPresenter, I.Main, I.PopInfo {

        void checkToken();

        void checkExists(String zoneCode, String phone);

        void loginSMS(String smsCode);

        void loginPassword(String password);

        void register(String smsCode, String password);

        void needSMSCode();

        void afterLogin();

    }

}
