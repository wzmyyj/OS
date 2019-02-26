package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface PasswordContract {

    interface IView extends BaseContract.IView {


    }

    interface IPresenter extends BaseContract.IPresenter {

        void changePassword(@NonNull String password);
    }

}
