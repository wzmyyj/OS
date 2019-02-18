package com.osmeet.os.app.other.rc;

import android.os.Parcel;

import com.google.gson.Gson;
import com.osmeet.os.app.bean.FriendInvite;

import java.io.UnsupportedEncodingException;

import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;

/**
 * Created by yyj on 2019/01/29.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

@MessageTag(value = "OS:FriendInviteMessage", flag = MessageTag.ISCOUNTED | MessageTag.ISPERSISTED)
public class InviteMessage extends MessageContent {

    private FriendInvite invite;

    public FriendInvite getInvite() {
        return invite;
    }

    public void setInvite(FriendInvite invite) {
        this.invite = invite;
    }

    //给消息赋值。
    public InviteMessage(Parcel in) {
        this.invite = new FriendInvite();
        this.invite.setStatus(ParcelUtils.readIntFromParcel(in));//该类为工具类，消息属性
        this.invite.setMatchUnitId(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setStoreCoverImageId(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setStoreLogoImageId(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setStoreId(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setStoreName(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setStoreNameEn(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setUserId(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        this.invite.setUserName(ParcelUtils.readFromParcel(in));//该类为工具类，消息属性
        //这里可继续增加你消息的属性
    }

    public InviteMessage(byte[] data) {
        super(data);
        try {
            String jsonStr = new String(data, "UTF-8");
            FriendInvite invite = new Gson().fromJson(jsonStr, FriendInvite.class);
            if (invite != null) {
                this.invite = invite;
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public byte[] encode() {
        try {
            String json = new Gson().toJson(invite);
            return json.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        ParcelUtils.writeToParcel(dest, invite.getStatus());//该类为工具类，对消息中属性进行序列化
        ParcelUtils.writeToParcel(dest, invite.getMatchUnitId());
        ParcelUtils.writeToParcel(dest, invite.getStoreCoverImageId());
        ParcelUtils.writeToParcel(dest, invite.getStoreLogoImageId());
        ParcelUtils.writeToParcel(dest, invite.getStoreName());
        ParcelUtils.writeToParcel(dest, invite.getStoreNameEn());
        ParcelUtils.writeToParcel(dest, invite.getStoreId());
        ParcelUtils.writeToParcel(dest, invite.getUserId());
        ParcelUtils.writeToParcel(dest, invite.getUserName());
    }

    /**
     * 读取接口，目的是要从Parcel中构造一个实现了Parcelable的类的实例处理。
     */
    public static final Creator<InviteMessage> CREATOR = new Creator<InviteMessage>() {

        @Override
        public InviteMessage createFromParcel(Parcel source) {
            return new InviteMessage(source);
        }

        @Override
        public InviteMessage[] newArray(int size) {
            return new InviteMessage[size];
        }
    };


}
