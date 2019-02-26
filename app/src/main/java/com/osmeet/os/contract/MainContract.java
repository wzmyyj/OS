package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 主页面。
 */

public interface MainContract {

    interface IView extends BaseContract.IView {
        void showMyInfo(@NonNull User user);
    }

    interface IPresenter extends BaseContract.IPresenter, I.PopInfo {
        void loadMyInfo();

        void sendLocation(double lng, double lat);
    }

}
