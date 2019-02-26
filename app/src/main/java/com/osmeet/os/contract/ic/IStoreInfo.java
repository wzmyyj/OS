package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IStoreInfo {
    interface V {
        void showStoreInfo(@NonNull Store store);
    }

    interface P {
        void loadStoreInfo();
    }
}
