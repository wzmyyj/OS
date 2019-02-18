package com.osmeet.os.assembly.service;

import android.content.Context;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

import top.wzmyyj.wzm_sdk.tools.L;
import top.wzmyyj.wzm_sdk.tools.T;

/**
 * Created by yyj on 2019/01/12. email: 2209011667@qq.com
 */

public class PushIntentService extends GTIntentService {

    public PushIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        // 透传消息的处理，详看SDK demo
        L.d("MSG:" + msg.getMessageId());
        T.s(context, msg.getMessageId());
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        L.d("onReceiveClientId -> " + "clientid = " + clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage msg) {
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
    }
}