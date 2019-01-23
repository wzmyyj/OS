package com.osmeet.os.app.application;

import android.app.Application;

import com.osmeet.os.app.bean.RcToken;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import top.wzmyyj.wzm_sdk.tools.L;
import top.wzmyyj.wzm_sdk.tools.P;
import top.wzmyyj.wzm_sdk.tools.T;

/**
 * Created by yyj on 2019/01/23.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class RcManager {
    private RcManager() {

    }

    private static class Holder {
        private static RcManager manager = new RcManager();
    }

    public static RcManager getInstance(Application context) {
        return Holder.manager.setContext(context);
    }

    private Application context;

    private RcManager setContext(Application context) {
        this.context = context;
        return this;
    }

    public void setmRcToken(RcToken mRcToken) {
        if (mRcToken == null) return;
        this.mRcToken = mRcToken;
        P.create(context).putString("RcToken", mRcToken.getToken())
                .commit();
    }

    public void clearToken() {
        this.mRcToken = null;
        P.create(context).putString("RcToken", null)
                .commit();
    }

    private RcToken mRcToken;

    public RcToken getmRcToken() {
        if (mRcToken == null) {
            mRcToken = new RcToken();
            String token = P.create(context).getString("RcToken", "");
            mRcToken.setToken(token);
        }
        return mRcToken;

    }

    public void connect() {
        if (mRcToken == null) return;
        RongIM.connect(mRcToken.getToken(), new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
            }

            @Override
            public void onSuccess(String userId) {
                L.d("Success userId= " + userId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                T.s("ErrorCode=" + errorCode);
            }
        });
    }

}