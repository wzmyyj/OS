package top.wzmyyj.wzm_sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by yyj on 2018/06/29.
 *
 * 状态栏相关。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */
public class StatusBarUtil {


    /**
     * 状态栏设置
     * @param context
     * @param isTint
     */
    public static void initStatusBar(Activity context, boolean isTint) {
        initStatusBar(context, isTint, false, false);
    }

    /**
     * @param context
     * @param isTint
     * @param isDark
     */
    public static void initStatusBar(Activity context, boolean isTint, boolean isDark) {
        initStatusBar(context, isTint, isDark, false);
    }


    /**
     * @param context
     * @param isTint
     * @param isDark
     * @param isTransparent
     */
    @SuppressLint("InlinedApi")
    public static void initStatusBar(Activity context, boolean isTint, boolean isDark, boolean isTransparent) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        Window window = context.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        int flag = window.getDecorView().getWindowSystemUiVisibility();
        // 沉浸式
        if (isTint) {
            flag |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

        } else {
            flag |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        }

        // 文字
        if (isDark) {
            flag |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            flag |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        }
        window.getDecorView().setSystemUiVisibility(flag);
        // 背景颜色
        if (isTransparent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

    /**
     * 获取状态栏高度。
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

    /**
     * 让view高度=状态栏高度。
     *
     * @param context
     * @param views
     */
    public static void fitsStatusBarView(Context context, @NonNull View... views) {
        for (View view : views) {
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.height = getStatusBarHeight(context);
        }
    }

    /**
     * 隐藏状态栏。
     *
     * @param context
     */
    public static void fullScreen(Activity context) {
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 显示状态栏。
     *
     * @param context
     */
    public static void notFullScreen(Activity context) {
        context.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
