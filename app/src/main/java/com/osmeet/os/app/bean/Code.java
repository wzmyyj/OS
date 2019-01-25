package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/25.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Code {
    private int type;
    private String info;
    private String whole;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWhole() {
        return whole;
    }

    public void setWhole(String whole) {
        this.whole = whole;
    }

    public static Code decode(String s) {
        if (s == null) return null;
        Code code = new Code();
        code.setWhole(s);
        if(!s.contains("www.osmeet.com")){
            code.setType(-1);
        }else if(!s.contains("userId")){
            code.setType(1);
            code.setInfo("");
        }else if(s.contains("storeId")){

        }else{

        }
        return code;
    }
}
