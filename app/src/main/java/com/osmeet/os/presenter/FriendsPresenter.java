package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.FriendsContract;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FriendsPresenter extends BasePresenter<FriendsContract.IView> implements FriendsContract.IPresenter {

    public FriendsPresenter(Activity activity, FriendsContract.IView iv) {
        super(activity, iv);
    }
}
