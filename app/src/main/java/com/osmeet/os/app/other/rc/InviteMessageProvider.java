package com.osmeet.os.app.other.rc;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialog.v2.SelectDialog;
import com.osmeet.os.R;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.contract.ChatContract;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.view.activity.ChatActivity;

import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;
import top.wzmyyj.wzm_sdk.tools.L;
import top.wzmyyj.wzm_sdk.tools.T;

/**
 * Created by yyj on 2019/02/01.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


@ProviderTag(
        messageContent = InviteMessage.class,//（这里是你自定义的消息实体）
        showReadState = true
)
public class InviteMessageProvider extends IContainerItemProvider.MessageProvider<InviteMessage> {
    @Override
    public void bindView(View view, int i, InviteMessage inviteMessage, UIMessage uiMessage) {
        //根据需求，适配数据
        ViewHolder holder = (ViewHolder) view.getTag();
//
        if (uiMessage.getMessageDirection() == Message.MessageDirection.SEND) {//消息方向，自己发送的
            holder.ll_message.setBackgroundResource(io.rong.imkit.R.drawable.rc_ic_bubble_right);
        } else {
            holder.ll_message.setBackgroundResource(io.rong.imkit.R.drawable.rc_ic_bubble_left);
        }
        //AndroidEmoji.ensure((Spannable) holder.message.getText());//显示消息中的 Emoji 表情。

        holder.tv_name.setText(inviteMessage.getInvite().getStoreName());
        G.img(view.getContext(), Urls.OS_BASE + Urls.file_refBySize
                        + "?id=" + inviteMessage.getInvite().getStoreCoverImageId()
                        + "&size=256",
                holder.img_bg);
        G.img(view.getContext(), Urls.OS_BASE + Urls.file_refBySize
                        + "?id=" + inviteMessage.getInvite().getStoreLogoImageId()
                        + "&size=256",
                holder.img_logo);
    }

    @Deprecated
    @Override
    public Spannable getContentSummary(InviteMessage inviteMessage) {
        return new SpannableString("OS invite message.");
    }

    @Override
    public void onItemClick(View view, int i, final InviteMessage inviteMessage, UIMessage uiMessage) {
//        T.s("" + inviteMessage.getInvite().getMatchUnitId());

        if (uiMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            L.d("" + inviteMessage.getInvite().getMatchUnitId());
        } else {
            try {
                ChatActivity chatActivity = (ChatActivity) context;
                final ChatContract.IPresenter mPresenter = chatActivity.getPresenter();
                SelectDialog.show(context, context.getString(R.string.tip),
                        context.getString(R.string.accept_invite),
                        context.getString(R.string.ok), (dialog, which) ->
                                mPresenter.matchInvite_friends_accept(inviteMessage.getInvite().getMatchUnitId()),
                        context.getString(R.string.cancel), (dialog, which) -> {
                        });
            } catch (Exception e) {
                T.s(e.getMessage());
            }
        }


    }

    private Context context;

    @Override
    public View newView(Context context, ViewGroup viewGroup) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_chat_invite_message_item, null);
        ViewHolder holder = new ViewHolder();
        holder.tv_name = view.findViewById(R.id.tv_store_name);
        holder.img_bg = view.findViewById(R.id.img_bg);
        holder.img_logo = view.findViewById(R.id.img_store_avatar);
        holder.ll_message = view.findViewById(R.id.ll_message);
        view.setTag(holder);
        return view;
    }


    private static class ViewHolder {
        TextView tv_name;
        ImageView img_bg, img_logo;
        LinearLayout ll_message;
    }
}
