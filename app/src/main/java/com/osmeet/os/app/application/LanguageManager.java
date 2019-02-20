package com.osmeet.os.app.application;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

import top.wzmyyj.wzm_sdk.tools.P;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 * 单例。
 */

public final class LanguageManager {
    private LanguageManager() {

    }

    private static class Holder {
        private static LanguageManager manager = new LanguageManager();
    }

    public static LanguageManager getInstance() {
        return Holder.manager;
    }


    private P p;

    public void init(Context context) {
        p = P.create(context, "language");
    }

    public static final int SYSTEM = 0;
    public static final int SIMPLIFIED_CHINESE = 1;
    public static final int ENGLISH = 2;


    public void setLanguage(int i) {
        p.putInt("language", i).commit();
    }

    public int getLanguage() {
        return p.getInt("language", 0);
    }

    public void initLanguage(Context context) {
        initLanguage(context, getLanguage());
    }

    private void initLanguage(Context context, int i) {
        Resources resources = context.getResources();//获得res资源对象
        Configuration config = resources.getConfiguration();//获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();//获得屏幕参数：主要是分辨率，像素等。
        switch (i) {
            case SIMPLIFIED_CHINESE:
                config.locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case ENGLISH:
                config.locale = Locale.ENGLISH;
                break;
            default:
                config.locale = Locale.getDefault();
        }
        resources.updateConfiguration(config, dm);
    }


}
