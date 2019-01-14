package com.osmeet.os.app.application;

import android.app.Application;

import com.osmeet.os.app.bean.Token;
import com.osmeet.os.app.bean.User;

import top.wzmyyj.wzm_sdk.tools.P;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 单例。
 */

public class UserManager {

    private UserManager() {

    }

    private static class Holder {
        private static UserManager manager = new UserManager();
    }

    public static UserManager getInstance(Application context) {
        return Holder.manager.setContext(context);
    }

    private Application context;

    private UserManager setContext(Application context) {
        this.context = context;
        return this;
    }

    public void setToken(Token token) {
        if (token == null) return;
        this.mToken = token;
        P.create(context).putString("Token", token.getToken())
                .putString("RefreshToken", token.getRefreshToken())
                .commit();
    }

    public void clearToken() {
        this.mToken = null;
        this.myInfo = null;
        this.isComplete = false;
        P.create(context).putString("Token", null)
                .putString("RefreshToken", null)
                .commit();
    }

    private Token mToken;

    public Token getToken() {
        if (mToken == null) {
            String token = P.create(context).getString("Token", "");
            String refreshToken = P.create(context).getString("RefreshToken", "");
            mToken = new Token();
            mToken.setToken(token);
            mToken.setRefreshToken(refreshToken);
        }
        return mToken;

    }

    private User myInfo;

    private boolean isComplete;

    public User getMyInfo() {
        return myInfo;
    }

    public void setMyInfo(User myInfo) {
        this.myInfo = myInfo;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }


}
