package com.osmeet.os.app.other;

import android.os.Parcel;

import io.rong.common.ParcelUtils;
import io.rong.imlib.model.MessageContent;

/**
 * Created by yyj on 2019/01/29.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InviteMessage extends MessageContent {

    String content;

    //给消息赋值。
    public InviteMessage(Parcel in) {
        content = ParcelUtils.readFromParcel(in);//该类为工具类，消息属性
        //这里可继续增加你消息的属性
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

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
