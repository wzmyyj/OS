package top.wzmyyj.wzm_sdk.tools;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;


/**
 * Created by yyj on 2018/01/10.
 *
 * Toast封装类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class T {

    /**
     * Application
     */
    private static Application app;

    /**
     * private constructor
     */
    private T() {
    }

    /**
     * @param app Application.
     */
    public static void init(Application app) {
        T.app = app;
    }

    /**
     * show short toast
     *
     * @param msg .
     */
    public static void s(String msg) {
        if (app == null) return;
        s(app, msg);
    }

    /**
     * show long toast
     *
     * @param msg .
     */
    public static void l(String msg) {
        if (app == null) return;
        l(app, msg);
    }

    /**
     * show short toast
     *
     * @param context .
     * @param msg .
     */
    public static void s(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * show long toast
     *
     * @param context .
     * @param msg .
     */
    public static void l(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
