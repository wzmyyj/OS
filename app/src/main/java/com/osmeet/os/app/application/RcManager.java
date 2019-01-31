package com.osmeet.os.app.application;

import android.app.Application;
import android.net.Uri;

import com.osmeet.os.app.bean.RcToken;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.model.net.service.UserService;
import com.osmeet.os.model.net.utils.ReOk;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;
import top.wzmyyj.wzm_sdk.tools.L;
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

    public void init() {
        RongIM.init(context);
        RongIM.setUserInfoProvider(userId -> {
            User user = ReOk.bind().create(UserService.class).user_info(userId).blockingLast().getData();
            String name = user.getUsername();
            String avatar_url = "";
            if (user.getAvatar() != null) {
                avatar_url = user.getAvatar().getUrl();
            }
            return new UserInfo(userId, name, Uri.parse(avatar_url));//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
        }, true);
    }

    public void setRcToken(RcToken mRcToken) {
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

    public void connect() {
        if (getRcToken()==null) return;
        RongIM.connect(getRcToken().getToken(), new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {

            }

            @Override
            public void onSuccess(String userId) {
                L.d("Success userId= " + userId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                L.e("ErrorCode=" + errorCode);
            }
        });
    }

}
