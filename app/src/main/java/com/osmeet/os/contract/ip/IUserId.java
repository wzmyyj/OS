package com.osmeet.os.contract.ip;

import android.support.annotation.NonNull;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IUserId {

    default void setUserId(@NonNull String userId){

    }

    String getUserId();
}
