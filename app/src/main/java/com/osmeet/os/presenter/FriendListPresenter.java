package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.FriendListContract;
import com.osmeet.os.model.net.FriendModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FriendListPresenter extends BasePresenter<FriendListContract.IView> implements FriendListContract.IPresenter {

    private FriendModel friendModel;

    public FriendListPresenter(Activity activity, FriendListContract.IView iv) {
        super(activity, iv);
        friendModel = new FriendModel().bind((AppCompatActivity) activity);
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

    @Override
    public void deleteFriend(final @NonNull String userId) {
        friendModel.friends_delete(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                mView.showDeleteFriend(userId, true);
            }
        }, userId);
    }
}