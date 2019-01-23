package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.IView> implements UserInfoContract.IPresenter {

    private UserModel userModel;
    private MatchModel matchModel;

    public UserInfoPresenter(Activity activity, UserInfoContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel();
        matchModel = new MatchModel();
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

    private String unitId;

    @Override
    public void setUnitId(@NonNull String unitId) {
        this.unitId = unitId;
    }

    @Override
    public String getUnitId() {
        return this.unitId;
    }

    private String inviteId;

    @Override
    public void setInviteId(@NonNull String inviteId) {
        this.inviteId = inviteId;
    }

    @Override
    public String getInviteId() {
        return inviteId;
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

    private String getStoreId() {
        return getActivity().getIntent().getStringExtra("storeId");
    }

    private int getMode() {
        return getActivity().getIntent().getIntExtra("mode", 0);
    }

    @Override
    public void matchInvite() {
        String storeId = getStoreId();
        int mode = getMode();
        if (mode == 0) {
            matchModel.matchInvite(new PObserver<Box<MatchInvite>>() {
                @Override
                public void onNext(Box<MatchInvite> box) {
                    if (box.getCode() != 0) {
                        toast(box.getMessage());
                        mView.showFail(1, box.getMessage());
                        return;
                    }
                    if (box.getData() != null) {
                        mView.showSuccess(1, box.getData());
                    }
                }
            }, storeId, unitId);
        }else{
            matchModel.matchInvite_accept(new PObserver<Box<MatchTeam>>() {
                @Override
                public void onNext(Box<MatchTeam> box) {
                    if (box.getCode() != 0) {
                        toast(box.getMessage());
                        mView.showFail(1, box.getMessage());
                        return;
                    }
                    if (box.getData() != null) {
                        goMatchBegin();
                        mView.showSuccess(1, box.getData());
                    }
                }
            },inviteId);
        }
    }
}
