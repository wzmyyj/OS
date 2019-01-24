package com.osmeet.os.app.java;

import android.text.TextUtils;

import java.util.List;

/**
 * Created by yyj on 2019/01/24.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class StringUtil {
    public static String str(String[] strings,String x){
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            if (TextUtils.isEmpty(s)) continue;
            builder.append(s);
            builder.append(x);
        }
        int i = builder.lastIndexOf(x);
        if (i > 0)
            builder.deleteCharAt(i);
        return builder.toString();
    }

    public static String str(List<String> stringList, String x){
        StringBuilder builder = new StringBuilder();
        for (String s : stringList) {
            if (TextUtils.isEmpty(s)) continue;
            builder.append(s);
            builder.append(x);
        }
        int i = builder.lastIndexOf(x);
        if (i > 0)
            builder.deleteCharAt(i);
        return builder.toString();
    }
}
