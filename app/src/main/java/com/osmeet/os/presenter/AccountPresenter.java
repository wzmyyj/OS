package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.AccountContract;

/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class AccountPresenter extends BasePresenter<AccountContract.IView> implements AccountContract.IPresenter {

    public AccountPresenter(Activity activity, AccountContract.IView iv) {
        super(activity, iv);
    }
}