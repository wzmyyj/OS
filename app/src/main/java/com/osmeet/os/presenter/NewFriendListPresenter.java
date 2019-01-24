package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.NewFriendListContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class NewFriendListPresenter extends BasePresenter<NewFriendListContract.IView> implements NewFriendListContract.IPresenter {

    public NewFriendListPresenter(Activity activity, NewFriendListContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void loadNewFriendList(int pageNum) {

    }

    @Override
    public void postAgreeNewFriend(@NonNull String userId) {

    }
}
