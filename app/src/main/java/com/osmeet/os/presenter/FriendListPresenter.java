package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.FriendListContract;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FriendListPresenter extends BasePresenter<FriendListContract.IView> implements FriendListContract.IPresenter {

    public FriendListPresenter(Activity activity, FriendListContract.IView iv) {
        super(activity, iv);
    }
}
