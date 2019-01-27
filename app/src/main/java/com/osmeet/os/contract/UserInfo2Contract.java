package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 * 用户资料。
 */

public interface UserInfo2Contract {
    interface IView extends IBaseView {
        void showUserInfo(@NonNull User user);
    }

    interface IPresenter extends IBasePresenter, I.Chat {

        String getUserId();

        void loadUserInfo();

        void addFriend(@NonNull String message);


    }
}
