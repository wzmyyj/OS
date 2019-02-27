package com.osmeet.os.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Report;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.model.net.AttentionModel;
import com.osmeet.os.model.net.ReportModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.IView> implements UserInfoContract.IPresenter {

    private UserModel userModel;

    public UserInfoPresenter(Fragment fragment, UserInfoContract.IView iv) {
        super(fragment, iv);
        userModel = new UserModel().bind(fragment);
    }

    private String userId;

    @Override
    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void loadUserInfo() {
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


    @Override
    public void loadStoryList(int pageNum) {
        mView.showStoryList(Story.testList(20),pageNum);
    }
}
