package com.osmeet.os.app.event;

/**
 * Created by yyj on 2018/12/26. email: 2209011667@qq.com
 */

public class FriendListChangeEvent {

    private boolean isChange;

    public FriendListChangeEvent(boolean isChange) {
        this.isChange = isChange;
    }

    public boolean isChange() {
        return isChange;
    }

    public void setChange(boolean update) {
        isChange = update;
    }
}
