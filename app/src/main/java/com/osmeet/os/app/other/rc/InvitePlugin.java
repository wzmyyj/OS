package com.osmeet.os.app.other.rc;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.osmeet.os.R;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.view.activity.ChatActivity;

import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;


/**
 * Created by yyj on 2019/02/01.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InvitePlugin implements IPluginModule {
    @Override
    public Drawable obtainDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.rc_ext_plugin_invite_selector);
    }

    @Override
    public String obtainTitle(Context context) {
        return context.getString(R.string.invite_friends);
    }

    @Override
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        ChatActivity chatActivity = (ChatActivity) fragment.getActivity();
        if (chatActivity != null) {
            ChatContract.IPresenter chatPresenter = chatActivity.getPresenter();
            chatPresenter.goChatInvite();
        }

    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {

    }
}
