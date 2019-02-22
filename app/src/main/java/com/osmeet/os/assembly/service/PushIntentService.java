package com.osmeet.os.assembly.service;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.GeTui;
import com.osmeet.os.app.event.InviteListChangeEvent;
import com.osmeet.os.app.event.TeamChangeEvent;
import com.osmeet.os.app.event.TeamListChangeEvent;
import com.osmeet.os.app.tools.I;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;

import top.wzmyyj.wzm_sdk.tools.L;

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
        try {
            String msgContent = new String(msg.getPayload(), "UTF-8");
            L.d("MId:" + msg.getMessageId() + "\n"
                    + "Cid" + msg.getClientId() + "\n"
                    + "Pkg:" + msg.getPkgName() + "\n"
                    + "Tid:" + msg.getTaskId() + "\n"
                    + "Content:" + msgContent + "\n"
            );

            Gson gson = new Gson();
            GeTui geTui = gson.fromJson(msgContent, GeTui.class);

            Message m = Message.obtain();
            m.obj = geTui;
            eventHandler.sendMessage(m);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        T.s(context, msg.getMessageId());
    }


    EventHandler eventHandler = new EventHandler();

    private static class EventHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            GeTui geTui = (GeTui) msg.obj;
            String type = geTui.getType();
            String teamId = geTui.getTeamId();
            if (GeTui.acceptInvite.equals(type)) {
                EventBus.getDefault().post(new InviteListChangeEvent(true));
                EventBus.getDefault().post(new TeamListChangeEvent(true));
            } else if (GeTui.newInvite.equals(type)) {
                EventBus.getDefault().post(new InviteListChangeEvent(true));
            } else if (GeTui.cancelInvite.equals(type)) {
                EventBus.getDefault().post(new InviteListChangeEvent(true));
            } else if (GeTui.beforeMeet.equals(type)
                    || GeTui.meetConfirm.equals(type)
                    || GeTui.meetFinish.equals(type)
                    || GeTui.timeConfirm.equals(type)
                    || GeTui.parentFinish.equals(type)) {
                EventBus.getDefault().post(new TeamChangeEvent(teamId));
                EventBus.getDefault().post(new TeamListChangeEvent(true));
            } else if (GeTui.unknowInvite.equals(type)) {
                L.d("unknowInvite");
            }
        }
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
        L.d("GGGGG" + msg.getContent());
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
        if (App.getInstance() == null) {
            I.goLaunchActivity(context);
        }
    }
}