package com.osmeet.os.app.application;

import android.content.Context;
import android.net.Uri;

import com.osmeet.os.app.bean.RcToken;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.other.rc.InviteMessage;
import com.osmeet.os.app.other.rc.InviteMessageProvider;
import com.osmeet.os.app.other.rc.MyExtensionModule;
import com.osmeet.os.model.net.service.UserService;
import com.osmeet.os.model.net.utils.ReOk;

import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongExtensionManager;
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

public final class RcManager {
    private RcManager() {

    }

    private static class Holder {
        private static RcManager manager = new RcManager();
    }

    public static RcManager getInstance() {
        return Holder.manager;
    }

    private P p;

    public void init(Context context) {
        p=P.create(context,"rc");
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

        RongIM.registerMessageType(InviteMessage.class);
        RongIM.registerMessageTemplate(new InviteMessageProvider());
        setMyExtensionModule();
    }


    public void refreshUserInfo(User user) {
        String avatar_url = "";
        if (user.getAvatar() != null) {
            avatar_url = user.getAvatar().getUrl();
        }
        RongIM.getInstance().refreshUserInfoCache(
                new UserInfo(user.getId(), user.getUsername(), Uri.parse(avatar_url)));
    }

    public void setRcToken(RcToken mRcToken) {
        if (mRcToken == null) return;
        this.mRcToken = mRcToken;
        p.putString("RcToken", mRcToken.getToken()).commit();
    }

    public void clearToken() {
        this.mRcToken = null;
        RongIM.getInstance().logout();
        p.putString("RcToken", null).commit();
    }

    private RcToken mRcToken;

    public RcToken getRcToken() {
        if (mRcToken == null) {
            mRcToken = new RcToken();
            String token = p.getString("RcToken", "");
            mRcToken.setToken(token);
        }
        return mRcToken;

    }

    public void connect() {
        if (getRcToken() == null) return;
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


    private void setMyExtensionModule() {
        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule = null;
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    defaultModule = module;
                    break;
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
                RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());
            }
        }
    }

}
