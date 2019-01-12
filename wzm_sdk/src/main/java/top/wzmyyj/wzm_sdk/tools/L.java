package top.wzmyyj.wzm_sdk.tools;

import android.util.Log;

/**
 * Created by wzm on 2018/01/10. email: 2209011667@qq.com
 * 日志打印类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class L {
    private static String TAG = "WZM";
    private static boolean debug = true;


    private L() {
    }

    public static void setTAG(String TAG) {
        L.TAG = TAG;
    }

    public static void setDebug(boolean debug) {
        L.debug = debug;
    }

    public static void v(String msg) {
        if (debug)
            Log.v(TAG, check(msg));
    }

    public static void d(String msg) {
        if (debug)
            Log.d(TAG, check(msg));
    }

    public static void i(String msg) {
        if (debug)
            Log.i(TAG, check(msg));
    }

    public static void w(String msg) {
        if (debug)
            Log.w(TAG, check(msg));
    }

    public static void e(String msg) {
        if (debug)
            Log.e(TAG, check(msg));
    }

    private static String check(String msg) {
        return msg == null ? "msg is null" : msg;
    }

}
