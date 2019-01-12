package top.wzmyyj.wzm_sdk.tools;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;


/**
 * Created by wzm on 2018/01/10. email: 2209011667@qq.com
 * Toast封装类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class T {

    private static Application app;

    private T() {
    }

    public static void init(Application app) {
        T.app = app;
    }

    public static void s(String msg) {
        if (app == null) return;
        s(app, msg);
    }

    public static void l(String msg) {
        if (app == null) return;
        l(app, msg);
    }

    public static void s(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


    public static void l(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
