package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 * 用户资料。
 */

public interface UserInfoContract {
    interface IView extends IBaseView {
        void showUserInfo(@NonNull User user);
    }

    interface IPresenter extends IBasePresenter {
        void setUserId(@NonNull String userId);

        void setUnitId(@NonNull String unitId);

        String getUserId();

        String getUnitId();

        void loadUserInfo();

        void matchInvite();
    }
}
