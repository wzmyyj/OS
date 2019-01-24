package com.osmeet.os.app.event;

/**
 * Created by yyj on 2018/12/26. email: 2209011667@qq.com
 */

public class MyInfoUpdateEvent {

    private boolean isUpdate;

    public MyInfoUpdateEvent(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }
}
