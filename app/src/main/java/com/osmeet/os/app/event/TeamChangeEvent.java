package com.osmeet.os.app.event;

/**
 * Created by yyj on 2018/12/26. email: 2209011667@qq.com
 */

public class TeamChangeEvent {

    private String teamId;

    public TeamChangeEvent(String teamId) {
        this.teamId = teamId;
    }


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
