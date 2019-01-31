package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 主页面。
 */

public interface MainContract {

    interface IView extends IBaseView {
        void showMyInfo(@NonNull User user);
    }

    interface IPresenter extends IBasePresenter, I.PopInfo {
        void loadMyInfo();

        void sendLocation(double lng, double lat);
    }

}
