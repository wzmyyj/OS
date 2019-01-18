package com.osmeet.os.app.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by yyj on 2018/12/09.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class InputSoftUtil {

    /**
     * 关闭输入法。
     *
     * @param activity
     */
    public static void close(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.hideSoftInputFromWindow(activity.getCurrentFocus() == null ?
                            null : activity.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);

    }

    /**
     * 打开输入法。
     *
     * @param activity
     */
    public static void open(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.showSoftInput(activity.getCurrentFocus(), InputMethodManager.SHOW_FORCED);

    }


    /**
     * 如果输入法打开则关闭，如果没打开则打开。
     *
     * @param activity
     */
    public static void toggle(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
