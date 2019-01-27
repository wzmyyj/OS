package com.osmeet.os.app.application;

import android.app.Application;

import com.osmeet.os.app.bean.RcToken;

import top.wzmyyj.wzm_sdk.tools.P;

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

    public RcToken getRcToken() {
        if (mRcToken == null) {
            mRcToken = new RcToken();
            String token = P.create(context).getString("RcToken", "");
            mRcToken.setToken(token);
        }
        return mRcToken;

    }

}
