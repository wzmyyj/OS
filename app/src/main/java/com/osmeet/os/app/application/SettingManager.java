package com.osmeet.os.app.application;

import android.app.Application;

import top.wzmyyj.wzm_sdk.tools.P;

/**
 * Created by yyj on 2018/12/28. email: 2209011667@qq.com
 * 单例。
 */

public class SettingManager {
    private SettingManager() {

    }

    private static class Holder {
        private static SettingManager manager = new SettingManager();
    }

    public static SettingManager getInstance(Application context) {
        return Holder.manager.setContext(context);
    }

    private Application context;

    private SettingManager setContext(Application context) {
        this.context = context;
        return this;
    }

    public void setOsSex(int i) {
        P.create(context, "setting").putInt("os_sex", i)
                .commit();
    }

    public int getOsSex() {
        return P.create(context, "setting").getInt("os_sex", 0);
    }


    public void setOsDistance(int d) {
        P.create(context, "setting").putInt("os_distance", d)
                .commit();
    }

    public int getOsDistance() {
        return P.create(context, "setting").getInt("os_distance", 250);
    }

    public void setOsMaxAge(int i) {
        P.create(context, "setting").putInt("os_max_age", i)
                .commit();
    }

    public int getOsMaxAge() {
        return P.create(context, "setting").getInt("os_max_age", 38);
    }

    public void setOsMinAge(int i) {
        P.create(context, "setting").putInt("os_min_age", i)
                .commit();
    }

    public int getOsMinAge() {
        return P.create(context, "setting").getInt("os_min_age", 0);
    }


    public void setIsOnce(boolean isOnce) {
        P.create(context, "setting").putBoolean("os_is_once", isOnce)
                .commit();
    }

    public boolean isOnce() {
        return P.create(context, "setting").getBoolean("os_is_once", true);
    }


    public boolean isAd() {
        return false;
    }
}
