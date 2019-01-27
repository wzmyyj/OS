package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.UserInfo2Contract;
import com.osmeet.os.model.net.FriendModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class UserInfo2Presenter extends BasePresenter<UserInfo2Contract.IView> implements UserInfo2Contract.IPresenter {

    private UserModel userModel;
    private FriendModel friendsModel;

    public UserInfo2Presenter(Activity activity, UserInfo2Contract.IView iv) {
        super(activity, iv);
        userModel = new UserModel();
        friendsModel = new FriendModel();
    }


    @Override
    public String getUserId() {
        return getActivity().getIntent().getStringExtra("userId");
    }

    @Override
    public void loadUserInfo() {
        String userId = getActivity().getIntent().getStringExtra("userId");
        if (TextUtils.isEmpty(userId)) {
            toast("User Id is a empty value!");
            return;
        }
        userModel.user_info(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showUserInfo(box.getData());
                }
            }
        }, userId);

    }

    @Override
    public void addFriend(@NonNull String message) {
        String userId = getActivity().getIntent().getStringExtra("userId");
        if (TextUtils.isEmpty(userId)) {
            toast("User Id is a empty value!");
            return;
        }
        friendsModel.friends_add(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast("申请成功！");

            }
        }, userId, message);
    }
}
