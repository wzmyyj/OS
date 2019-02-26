package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface FriendListContract {

    interface IView extends BaseContract.IView {

        void showFriendList(@NonNull List<User> userList, int pageNum);

        void showNewFriendNum(int num);

        void showDeleteFriend(@NonNull String userId,boolean isSuccess);
    }

    interface IPresenter extends BaseContract.IPresenter, I.NewFriends, I.UserInfo2 {

        void loadFriendList(int pageNum);

        void loadNewFriendNum();

        void deleteFriend(@NonNull String userId);
    }

}
