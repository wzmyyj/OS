package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Token {
    private String refreshToken;
    private String token;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearerToken() {
        return "Bearer " + token;
    }

    public boolean isEmpty() {
        return token == null || token.isEmpty();
    }
}
