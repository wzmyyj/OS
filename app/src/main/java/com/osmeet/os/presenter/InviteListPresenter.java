package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.InviteListContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteListPresenter extends BasePresenter<InviteListContract.IView> implements InviteListContract.IPresenter {

    public InviteListPresenter(Activity activity, InviteListContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void loadMatchInviteList() {

    }
}