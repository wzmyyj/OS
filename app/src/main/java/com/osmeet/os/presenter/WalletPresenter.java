package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.WalletContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class WalletPresenter extends BasePresenter<WalletContract.IView> implements WalletContract.IPresenter {

    public WalletPresenter(Activity activity, WalletContract.IView iv) {
        super(activity, iv);
    }
}
