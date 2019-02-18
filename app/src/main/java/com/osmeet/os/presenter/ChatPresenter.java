package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.event.InviteListChangeEvent;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ChatPresenter extends BasePresenter<ChatContract.IView> implements ChatContract.IPresenter {

    public ChatPresenter(Activity activity, ChatContract.IView iv) {
        super(activity, iv);
    }

    @Override
    public void report(@NonNull String content) {

    }

    @Override
    public void block() {

    }

    @Override
    public void inviteFriends(@NonNull String storeId, @NonNull String userId) {
        List<String> userIdList = new ArrayList<>();
        userIdList.add(userId);
        new MatchModel().matchInvite_friends(new PObserver<Box<List<MatchInvite2>>>() {
            @Override
            public void onNext(Box<List<MatchInvite2>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showInviteFriendList(box.getData());
                }
            }
        }, storeId, userIdList);
    }

    @Override
    public void matchInvite_friends_accept(@NonNull String matchInviteId) {
        new MatchModel().matchInvite_friends_accept(new PObserver<Box<MatchTeam>>() {
            @Override
            public void onNext(Box<MatchTeam> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }

                if (box.getData() != null) {
                    EventBus.getDefault().post(new InviteListChangeEvent(true));
                    goMatchBegin(new MatchTeam.SimpleMatchTeam(box.getData()));
                    finish();
                }
            }

        }, matchInviteId);
    }
}
