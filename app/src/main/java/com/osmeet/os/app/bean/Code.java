package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/25.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Code {

    public static final String CODE_BEGIN = "www.osmeet.com/";
    public static final int CODE_UN_KNOW = -0x1;
    public static final int CODE_OS_BUT_USELESS = 0;
    public static final int CODE_USER_ID = 0x1;
    public static final int CODE_TRADE_ID = 0x10;
    public static final int CODE_STORE_ID = 0x11;
    public static final int CODE_GOODS_ID = 0x100;

    private int code;
    private String info;

    public Code() {
    }

    public Code(int type, String info) {
        this.code = type;
        this.info = info;
    }

    public int getType() {
        return code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
