package com.osmeet.os.presenter;

import android.support.v4.app.Fragment;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.MessageContract;
import com.osmeet.os.model.net.FriendModel;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2018/12/19. email: 2209011667@qq.com
 */

public class MessagePresenter extends BasePresenter<MessageContract.IView> implements MessageContract.IPresenter {

    private MatchModel matchModel;
    private FriendModel friendModel;

    public MessagePresenter(Fragment fragment, MessageContract.IView iv) {
        super(fragment, iv);
        matchModel = new MatchModel().bind(fragment);
        friendModel = new FriendModel().bind(fragment);
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
    public void loadNewFriendNum() {
        friendModel.friends_meNum(new PObserver<Box<Integer>>() {
            @Override
            public void onNext(Box<Integer> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showNewFriendNum(box.getData());
                }
            }
        });
    }


}
