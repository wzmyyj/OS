package com.osmeet.os.app.utils;

import java.security.MessageDigest;

/**
 * Created by yyj on 2018/12/06. email: 2209011667@qq.com
 */

public class MD5Util {

    /**
     * 利用MD5进行加密
     */
    public static String encrypt(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        byte[] by = str.getBytes();
        byte[] md5Bytes = md5.digest(by);

        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();

    }
}
