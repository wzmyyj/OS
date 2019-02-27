package com.osmeet.os.contract.ic;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Store;

import java.util.List;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IMyStoreList {
    interface V {
        void showMyStoreList(@NonNull List<Store> storeList);
    }

    interface P {
        void loadMyStoreList();
    }
}
