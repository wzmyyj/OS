package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IDeleteFriend {
    interface V {
        void showDeleteFriend(@NonNull String userId, boolean isSuccess);
    }

    interface P {
        void deleteFriend(@NonNull String userId);
    }
}
