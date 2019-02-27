package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IAgreeNewFriend {
    interface V {
        void showAgreeNewFriend(@NonNull String userId);
    }

    interface P {
        void postAgreeNewFriend(@NonNull String userId);
    }
}
