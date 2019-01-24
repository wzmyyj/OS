package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Friend;
import com.osmeet.os.app.event.FriendListChangeEvent;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.NewFriendListContract;
import com.osmeet.os.model.net.FriendModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class NewFriendListPresenter extends BasePresenter<NewFriendListContract.IView> implements NewFriendListContract.IPresenter {

    private FriendModel friendModel;

    public NewFriendListPresenter(Activity activity, NewFriendListContract.IView iv) {
        super(activity, iv);
        friendModel = new FriendModel();
    }

    @Override
    public void loadNewFriendList(final int pageNum) {
        friendModel.friends_me(new PObserver<Box<ListContent<Friend>>>() {
            @Override
            public void onNext(Box<ListContent<Friend>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showNewFriendList(box.getData().getContent(), pageNum);
                }
            }
        }, pageNum, 20);
    }

    @Override
    public void postAgreeNewFriend(@NonNull final String userId) {
        friendModel.friends_agree(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                mView.showAgreeNewFriend(userId);
                EventBus.getDefault().post(new FriendListChangeEvent(true));
            }
        }, userId);
    }
}
