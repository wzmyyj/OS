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

public interface UserInfoContract {
    interface IView extends IBaseView {
        void showUserInfo(@NonNull User user);

        void showInvite(boolean isSuccess, int what);
    }

    interface IPresenter extends IBasePresenter, I.MatchBegin, I.ImageLook {
        void setUserId(@NonNull String userId);

        void setUnitId(@NonNull String unitId);

        void setInviteId(@NonNull String inviteId);

        String getUserId();

        String getUnitId();

        String getInviteId();

        int getMode();

        void loadUserInfo();

        void matchInvite();

        void matchInvite_accept();

        void report(@NonNull String content);

        void block();
    }
}
