package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Friend;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface NewFriendListContract {

    interface IView extends BaseContract.IView {
        void showNewFriendList(@NonNull List<Friend> friendList, int pageNum);

        void showAgreeNewFriend(@NonNull String userId);
    }

    interface IPresenter extends BaseContract.IPresenter, I.UserInfo2 {

        void loadNewFriendList(int pageNum);

        void postAgreeNewFriend(@NonNull String userId);
    }

}
