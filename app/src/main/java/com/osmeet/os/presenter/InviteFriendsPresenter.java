package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.InviteFriendsContract;
import com.osmeet.os.model.net.FriendModel;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class InviteFriendsPresenter extends BasePresenter<InviteFriendsContract.IView> implements InviteFriendsContract.IPresenter {

    private FriendModel friendModel;
    private MatchModel matchModel;

    public InviteFriendsPresenter(Activity activity, InviteFriendsContract.IView iv) {
        super(activity, iv);
        friendModel = new FriendModel().bind((AppCompatActivity) activity);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void loadFriendList(final int pageNum) {
        friendModel.friends_page(new PObserver<Box<ListContent<User>>>() {
            @Override
            public void onNext(Box<ListContent<User>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showFriendList(box.getData().getContent(), pageNum);
                }
            }
        }, pageNum, 50);
    }

    @Override
    public void inviteFriends(@NonNull List<String> userIdList) {
        final String storeId = getActivity().getIntent().getStringExtra("storeId");
        if (TextUtils.isEmpty(storeId)) {
            toast("Store Id is a empty value!");
            return;
        }
        matchModel.matchInvite_friends(new PObserver<Box<List<MatchInvite2>>>() {
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
}
