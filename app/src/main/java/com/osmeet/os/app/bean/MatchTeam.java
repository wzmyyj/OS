package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class MatchTeam {

    public static final String Wait_Accept_Meet_Time = "W-MT";
    public static final String Confirm_Meet_Time = "B";

    public static final String Begin_Checking = "C";
    public static final String Invite_Checking = "C-1";
    public static final String Invitee_Checking = "C-2";

    public static final String CheckingComplete = "D";
    public static final String Invite_Comment = "D-1";
    public static final String Invitee_Comment = "D-2";

    public static final String Invite_Not_Comment = "S-1";
    public static final String Invitee_Not_Comment = "S-2";
    public static final String Both_Comment = "S-3";
    public static final String Both_No_Comment = "S-4";

    public static final String Invite_Not_Checking = "O-1";
    public static final String Invitee_Not_Checking = "O-2";
    public static final String Both_Not_Checking = "0-3";
    public static final String Exceed_Rule_Time_Not_Confirm_Meet_Time = "0-4";

    public static final String Invite_Cancel_Meet = "Q-1";
    public static final String Invitee_Cancel_Meet = "Q-2";
    public static final String Unknow = "Q-3";


    public static final int MATCH_NOW = 0;
    public static final int MATCH_SUCCESS = 1;
    public static final int MATCH_FAIL = 2;
    public static final int MATCH_CANCEL = -1;

    private String id;
    private long matchEndTime;
    private long matchStartTime;
    private Store store;
    private MatchUnit unita;
    private MatchUnit unitb;
    private String togetherState;
    private int atimeStatus;
    private long awantMeetTime;
    private int btimeStatus;
    private long bwantMeetTime;
    private int matchStatus;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMatchEndTime(long matchEndTime) {
        this.matchEndTime = matchEndTime;
    }

    public long getMatchEndTime() {
        return matchEndTime;
    }

    public void setMatchStartTime(long matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    public long getMatchStartTime() {
        return matchStartTime;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setUnita(MatchUnit unita) {
        this.unita = unita;
    }

    public MatchUnit getUnita() {
        return unita;
    }

    public void setUnitb(MatchUnit unitb) {
        this.unitb = unitb;
    }

    public MatchUnit getUnitb() {
        return unitb;
    }


    public String getTogetherState() {
        return togetherState;
    }

    public void setTogetherState(String togetherState) {
        this.togetherState = togetherState;
    }

    public int getAtimeStatus() {
        return atimeStatus;
    }

    public void setAtimeStatus(int atimeStatus) {
        this.atimeStatus = atimeStatus;
    }

    public long getAwantMeetTime() {
        return awantMeetTime;
    }

    public void setAwantMeetTime(long awantMeetTime) {
        this.awantMeetTime = awantMeetTime;
    }

    public int getBtimeStatus() {
        return btimeStatus;
    }

    public void setBtimeStatus(int btimeStatus) {
        this.btimeStatus = btimeStatus;
    }

    public long getBwantMeetTime() {
        return bwantMeetTime;
    }

    public void setBwantMeetTime(long bwantMeetTime) {
        this.bwantMeetTime = bwantMeetTime;
    }

    public int getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(int matchStatus) {
        this.matchStatus = matchStatus;
    }
}
