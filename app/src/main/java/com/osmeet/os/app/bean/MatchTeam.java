package com.osmeet.os.app.bean;

import java.io.Serializable;

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
    private long meetTime;

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

    public long getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(long meetTime) {
        this.meetTime = meetTime;
    }

    public void changeAB() {
        int tmp = this.atimeStatus;
        this.atimeStatus = this.btimeStatus;
        this.btimeStatus = tmp;

        long tl = this.awantMeetTime;
        this.awantMeetTime = this.bwantMeetTime;
        this.bwantMeetTime = tl;

        MatchUnit unit = this.unita;
        this.unita = this.unitb;
        this.unitb = unit;
    }


    public static class SimpleMatchTeam implements Serializable {
        private String id;
        private String store_id;
        private String store_name;
        private String store_logo;
        private String user1_id;
        private String user1_name;
        private String user1_avatar;
        private String user2_id;
        private String user2_name;
        private String user2_avatar;
        private int matchStatus;

        public SimpleMatchTeam(MatchTeam matchTeam) {
            this.id = matchTeam.getId();
            Store store = matchTeam.getStore();
            if (store != null) {
                this.store_id = store.getId();
                this.store_name = store.getName();
                if (store.getName() != null) {
                    this.store_logo = store.getLogoImage().getUrl();
                }
            }
            User user1 = matchTeam.getUnita().getUser();
            if (user1 != null) {
                this.user1_id = user1.getId();
                this.user1_name = user1.getUsername();
                if (user1.getAvatar() != null) {
                    this.user1_avatar = user1.getAvatar().getUrl();
                }
            }

            User user2 = matchTeam.getUnita().getUser();
            if (user2 != null) {
                this.user2_id = user2.getId();
                this.user2_name = user2.getUsername();
                if (user2.getAvatar() != null) {
                    this.user2_avatar = user2.getAvatar().getUrl();
                }
            }
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getStore_logo() {
            return store_logo;
        }

        public void setStore_logo(String store_logo) {
            this.store_logo = store_logo;
        }

        public String getUser1_id() {
            return user1_id;
        }

        public void setUser1_id(String user1_id) {
            this.user1_id = user1_id;
        }

        public String getUser1_name() {
            return user1_name;
        }

        public void setUser1_name(String user1_name) {
            this.user1_name = user1_name;
        }

        public String getUser1_avatar() {
            return user1_avatar;
        }

        public void setUser1_avatar(String user1_avatar) {
            this.user1_avatar = user1_avatar;
        }

        public String getUser2_id() {
            return user2_id;
        }

        public void setUser2_id(String user2_id) {
            this.user2_id = user2_id;
        }

        public String getUser2_name() {
            return user2_name;
        }

        public void setUser2_name(String user2_name) {
            this.user2_name = user2_name;
        }

        public String getUser2_avatar() {
            return user2_avatar;
        }

        public void setUser2_avatar(String user2_avatar) {
            this.user2_avatar = user2_avatar;
        }

        public int getMatchStatus() {
            return matchStatus;
        }

        public void setMatchStatus(int matchStatus) {
            this.matchStatus = matchStatus;
        }
    }
}
