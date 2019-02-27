package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IFriendList {
    interface V {
        void showFriendList(@NonNull List<User> userList, int pageNum);
    }

    interface P {
        void loadFriendList(int pageNum);
    }
}
