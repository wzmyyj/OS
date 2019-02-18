package com.osmeet.os.app.event;

import com.osmeet.os.app.bean.Store;

/**
 * Created by yyj on 2019/01/31.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class StoreChooseEvent {
    private Store store;

    public StoreChooseEvent(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
