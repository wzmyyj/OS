package top.wzmyyj.wzm_sdk.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by yyj on 2018/05/01。
 *
 * 屏幕相关。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MockUtil {

    /***
     * 获取屏幕宽度
     *
     * @param context
     * @return 屏幕宽度（px）
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null) return -1;
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return 屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null) return -1;
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }


    /**
     * 获取状态栏高度
     *
     * @param context
     * @return 高度（px）
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resultId = context.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resultId > 0) {
            result = context.getResources().getDimensionPixelSize(resultId);
        }
        return result;
    }
}

