package com.osmeet.os.view.panel.bean;

import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.Store;

import java.util.List;

/**
 * Created by yyj on 2019/01/13. email: 2209011667@qq.com
 */

public class MatchStoreInvite {
    Store store;
    List<MatchInvite> inviteList;

    public MatchStoreInvite() {
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<MatchInvite> getInviteList() {
        return inviteList;
    }

    public void setInviteList(List<MatchInvite> inviteList) {
        this.inviteList = inviteList;
    }
}
