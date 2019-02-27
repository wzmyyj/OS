package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Friend;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface INewFriendList {
    interface V {
        void showNewFriendList(@NonNull List<Friend> friendList, int pageNum);
    }

    interface P {
        void loadNewFriendList(int pageNum);
    }
}
