package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/02/21.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class GeTui {

    private String storeId;
    private String teamId;
    private String type;

    public static final String newInvite = "INVITE";
    public static final String unknowInvite = "unknow";
    public static final String acceptInvite = "ACCEPT";
    public static final String cancelInvite = "CANCEL";
    public static final String timeConfirm = "TIME_CONFIRM";
    public static final String beforeMeet = "BEFORE_MEET";
    public static final String meetConfirm = "MEET_CONFIRM";
    public static final String parentFinish = "PARTNER_FINISH";
    public static final String meetFinish = "MEET_FINISH";

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
