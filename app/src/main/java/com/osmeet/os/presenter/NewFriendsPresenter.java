package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.NewFriendsContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class NewFriendsPresenter extends BasePresenter<NewFriendsContract.IView> implements NewFriendsContract.IPresenter {

    public NewFriendsPresenter(Activity activity, NewFriendsContract.IView iv) {
        super(activity, iv);
    }
}
