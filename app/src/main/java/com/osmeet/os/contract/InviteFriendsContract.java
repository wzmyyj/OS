package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.MatchInvite2;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.contract.BaseContract;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 邀请好友。
 */

public interface InviteFriendsContract {

    interface IView extends BaseContract.IView {

        void showFriendList(@NonNull List<User> userList, int pageNum);

        void showInviteFriendList(@NonNull List<MatchInvite2> matchInvite2List);
    }

    interface IPresenter extends BaseContract.IPresenter {

        void loadFriendList(int pageNum);

        void inviteFriends(@NonNull List<String> userIdList);
    }

}
