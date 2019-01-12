package top.wzmyyj.wzm_sdk.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;

/**
 * Created by yyj on 2019/01/04. email: 2209011667@qq.com
 * activity横竖屏设置。
 */

public class OrientationUtil {

    /***
     * 竖屏。
     */
    public static void portrait(Activity activity) {
        if (activity.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }


    /***
     * 横屏。
     */
    public static void landscape(Activity activity) {
        if (activity.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
