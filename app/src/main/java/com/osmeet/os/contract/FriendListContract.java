package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IDeleteFriend;
import com.osmeet.os.contract.ic.IFriendList;
import com.osmeet.os.contract.ic.INewFriendNum;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface FriendListContract {

    interface IView extends BaseContract.IView,
            IFriendList.V,
            INewFriendNum.V,
            IDeleteFriend.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IFriendList.P,
            INewFriendNum.P,
            IDeleteFriend.P,
            I.NewFriends,
            I.UserInfo2 {

    }

}
