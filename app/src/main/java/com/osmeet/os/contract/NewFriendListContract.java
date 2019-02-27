package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IAgreeNewFriend;
import com.osmeet.os.contract.ic.INewFriendList;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface NewFriendListContract {

    interface IView extends BaseContract.IView,
            INewFriendList.V,
            IAgreeNewFriend.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            INewFriendList.P,
            IAgreeNewFriend.P,
            I.UserInfo2 {
    }

}
