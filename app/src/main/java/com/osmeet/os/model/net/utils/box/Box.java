package com.osmeet.os.model.net.utils.box;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Box<T> {

    protected int code;
    protected String message;

    public Box(int code, String message) {
        this.code = code;
        this.message = message;
    }

    protected T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
