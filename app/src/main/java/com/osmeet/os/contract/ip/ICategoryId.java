package com.osmeet.os.contract.ip;

import android.support.annotation.NonNull;

/**
 * Created by yyj on 2019/02/27.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface ICategoryId {
    default void setCategoryId(@NonNull String categoryId) {

    }

    String getCategoryId();
}
