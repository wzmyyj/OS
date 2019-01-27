package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface FriendListContract {

    interface IView extends IBaseView {

        void showFriendList(@NonNull List<User> userList, int pageNum);

        void showNewFriendNum(int num);

        void showDeleteFriend(@NonNull String userId,boolean isSuccess);
    }

    interface IPresenter extends IBasePresenter, I.NewFriends, I.UserInfo2 {

        void loadFriendList(int pageNum);

        void loadNewFriendNum();

        void deleteFriend(@NonNull String userId);
    }

}
