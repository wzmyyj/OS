package com.osmeet.os.presenter;

import android.app.Activity;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.RcToken;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MessageContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import top.wzmyyj.wzm_sdk.tools.L;
import top.wzmyyj.wzm_sdk.tools.T;

/**
 * Created by yyj on 2018/12/19. email: 2209011667@qq.com
 */

public class MessagePresenter extends BasePresenter<MessageContract.IView> implements MessageContract.IPresenter {

    private MatchModel matchModel;
    private UserModel userModel;

    public MessagePresenter(Activity activity, MessageContract.IView iv) {
        super(activity, iv);
        matchModel = new MatchModel();
        userModel = new UserModel();
    }

    @Override
    public void loadMatchTeamList() {
        matchModel.matchTeam_going(new PObserver<Box<ListContent<MatchTeam>>>() {
            @Override
            public void onNext(Box<ListContent<MatchTeam>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchTeamList(box.getData().getContent());
                }
            }
        }, 0, 100);
    }

    @Override
    public void loadMatchInviteList() {
        matchModel.matchInvite_getBeInvited(new PObserver<Box<ListContent<MatchInvite>>>() {
            @Override
            public void onNext(Box<ListContent<MatchInvite>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchInviteList(box.getData().getContent());
                }
            }

        }, 0, 100);
    }

    @Override
    public void loadRcToken() {
        if (!App.getInstance().getRcToken().isEmpty()) {
            connect(App.getInstance().getRcToken());
            return;
        }
        userModel.user_getRyToken(new PObserver<Box<RcToken>>() {
            @Override
            public void onNext(Box<RcToken> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    App.getInstance().setRcToken(box.getData());
                    connect(box.getData());
                }
            }
        });
    }

    public void connect(RcToken mRcToken) {
        if (mRcToken == null) return;
        RongIM.connect(mRcToken.getToken(), new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
            }

            @Override
            public void onSuccess(String userId) {
                L.d("Success userId= " + userId);
                mView.showRcTokenConnect(true);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                T.s("ErrorCode=" + errorCode);
                mView.showRcTokenConnect(false);
            }
        });
    }
}
