package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.InviteFriendsContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteFriendsPresenter extends BasePresenter<InviteFriendsContract.IView> implements InviteFriendsContract.IPresenter {

    public InviteFriendsPresenter(Activity activity, InviteFriendsContract.IView iv) {
        super(activity, iv);
    }
}
