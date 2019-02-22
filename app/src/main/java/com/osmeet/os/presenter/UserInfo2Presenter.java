package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Report;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.UserInfo2Contract;
import com.osmeet.os.model.net.AttentionModel;
import com.osmeet.os.model.net.FriendModel;
import com.osmeet.os.model.net.ReportModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class UserInfo2Presenter extends BasePresenter<UserInfo2Contract.IView> implements UserInfo2Contract.IPresenter {

    private UserModel userModel;
    private FriendModel friendsModel;
    private String userId;

    public UserInfo2Presenter(Activity activity, UserInfo2Contract.IView iv) {
        super(activity, iv);
        userModel = new UserModel().bind((AppCompatActivity) activity);
        friendsModel = new FriendModel().bind((AppCompatActivity) activity);
        userId = getActivity().getIntent().getStringExtra("userId");
        Sure.sure(!TextUtils.isEmpty(userId), "User Id is a empty value!");
    }


    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void loadUserInfo() {
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
        friendsModel.friends_add(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(getContext().getString(R.string.apply_success));

            }
        }, userId, message);
    }

    @Override
    public void report(@NonNull String content) {
        new ReportModel().report(new PObserver<Box<Report>>() {
            @Override
            public void onNext(Box<Report> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(context.getString(R.string.report_success));
            }
        }, new Report(Report.REPORT_USER, userId, content));
    }

    @Override
    public void block() {
        new AttentionModel().block_post(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(context.getString(R.string.block_success));
            }
        }, userId);

    }
}
