package com.osmeet.os.app.bean;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class MatchInvite {

    private String id;
    private int inviteMode;
    private MatchUnit invitedMatchUnit;
    private MatchUnit matchUnit;// 发起邀请的单位。
    private Store store;
    private int status;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInviteMode(int inviteMode) {
        this.inviteMode = inviteMode;
    }

    public int getInviteMode() {
        return inviteMode;
    }

    public void setInvitedMatchUnit(MatchUnit invitedMatchUnit) {
        this.invitedMatchUnit = invitedMatchUnit;
    }

    public MatchUnit getInvitedMatchUnit() {
        return invitedMatchUnit;
    }

    public void setMatchUnit(MatchUnit matchUnit) {
        this.matchUnit = matchUnit;
    }

    public MatchUnit getMatchUnit() {
        return matchUnit;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


    public static class Group {
        Store store;
        List<MatchInvite> inviteList;

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

    @NonNull
    public static List<Group> getGroupList(List<MatchInvite> matchInviteList) {
        List<Group> groupList = new ArrayList<>();
        if (matchInviteList == null || matchInviteList.size() == 0) return groupList;
        /*分组算法**/
        @SuppressLint("UseSparseArrays")
        Map<String, List<MatchInvite>> miIdMap = new HashMap<>();
        for (MatchInvite invite : matchInviteList) {
            List<MatchInvite> tempList = miIdMap.get(invite.getStore().getId());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(invite);
                miIdMap.put(invite.getStore().getId(), tempList);
            } else {
                /*某个invite之前已经存放过了,则直接追加数据到原来的List里**/
                tempList.add(invite);
            }
        }
        for (Map.Entry<String, List<MatchInvite>> entry : miIdMap.entrySet()) {
            Group msi = new Group();
            msi.setInviteList(entry.getValue());
            msi.setStore(entry.getValue().get(0).getStore());
            groupList.add(msi);
        }
        return groupList;

    }
}
