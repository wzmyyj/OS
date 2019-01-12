package com.osmeet.os.base.application;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.application.WZM_Application;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public class BaseApplication extends WZM_Application {

    protected static List<Activity> mActivityList = null;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mActivityList == null) {
            mActivityList = new ArrayList<>();
        }
    }

    public static void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        mActivityList.remove(activity);
    }

    public static void finish(Class<?> cls) {
        for (Activity activity : mActivityList) {
            if (activity.getClass() == cls) {
                activity.finish();
            }
        }
    }

    public static void finishAll() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing())
                activity.finish();
        }
        mActivityList.clear();
    }
}
