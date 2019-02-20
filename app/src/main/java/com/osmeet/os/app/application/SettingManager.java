package com.osmeet.os.app.application;

import android.content.Context;

import top.wzmyyj.wzm_sdk.tools.P;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 * 单例。
 */

public final class SettingManager {
    private SettingManager() {

    }

    private static class Holder {
        private static SettingManager manager = new SettingManager();
    }

    public static SettingManager getInstance() {
        return Holder.manager;
    }

    private P p;

    public void init(Context context) {
        p = P.create(context, "setting");
    }

    public void setOsSex(int i) {
        p.putInt("os_sex", i).commit();
    }

    public int getOsSex() {
        return p.getInt("os_sex", 0);
    }


    public void setOsDistance(int d) {
        p.putInt("os_distance", d).commit();
    }

    public int getOsDistance() {
        return p.getInt("os_distance", 100);
    }

    public void setOsMaxAge(int i) {
       p.putInt("os_max_age", i).commit();
    }

    public int getOsMaxAge() {
        return p.getInt("os_max_age", 55);
    }

    public void setOsMinAge(int i) {
        p.putInt("os_min_age", i).commit();
    }

    public int getOsMinAge() {
        return p.getInt("os_min_age", 18);
    }


    public void setIsOnce(boolean isOnce) {
        p.putBoolean("os_is_once", isOnce).commit();
    }

    public boolean isOnce() {
        return false;
//        return p.getBoolean("os_is_once", true);
    }


    public boolean isAd() {
        return false;
    }
}
