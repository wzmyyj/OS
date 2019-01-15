package com.osmeet.os.base.application;

import android.annotation.SuppressLint;
import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.application.WZM_Application;


/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

@SuppressLint("Registered")
public class BaseApplication extends WZM_Application {

    private List<Activity> mActivityList = null;
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mActivityList == null) {
            mActivityList = new ArrayList<>();
        }
        baseApplication = this;
    }

    public static BaseApplication getInstance() {
        return baseApplication;
    }


    public void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        mActivityList.remove(activity);
    }

    public void finish(Class<?> cls) {
        for (Activity activity : mActivityList) {
            if (activity.getClass() == cls) {
                activity.finish();
            }
        }
    }

    public void finishAll() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing())
                activity.finish();
        }
        mActivityList.clear();
    }

    public void finishAllWithout(Activity a) {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing() && activity != a)
                activity.finish();
        }
    }
}
