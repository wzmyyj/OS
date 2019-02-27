package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IMyInfo {
    interface V {
        void showMyInfo(@NonNull User user);
    }

    interface P {
        void loadMyInfo();

        default void freshMyInfo() {

        }
    }
}
