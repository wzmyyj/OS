package top.wzmyyj.wzm_sdk.tools;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yyj on 2018/01/10.
 * <p>
 * 日志打印类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class L {
    /**
     * Default Log TAG
     */
    private static final String WZM_TAG = "WZM";

    /**
     * Log TAG
     */
    private static String TAG = WZM_TAG;

    /**
     * is debug
     */
    private static boolean debug = true;

    /**
     * private constructor.
     */
    private L() {
    }

    /**
     * @param TAG tag.
     */
    public static void setTAG(String TAG) {
        L.TAG = TAG;
    }

    /**
     * @param debug is debug.
     */
    public static void setDebug(boolean debug) {
        L.debug = debug;
    }

    /**
     * verbose log.
     *
     * @param msg .
     */
    public static void v(String msg) {
        if (debug)
            Log.v(TAG, check(msg));
    }

    /**
     * debug log.
     *
     * @param msg .
     */
    public static void d(String msg) {
        if (debug)
            Log.d(TAG, check(msg));
    }

    /**
     * info log.
     *
     * @param msg .
     */
    public static void i(String msg) {
        if (debug)
            Log.i(TAG, check(msg));
    }

    /**
     * warn log.
     *
     * @param msg .
     */
    public static void w(String msg) {
        if (debug)
            Log.w(TAG, check(msg));
    }

    /**
     * error log.
     *
     * @param msg .
     */
    public static void e(String msg) {
        if (debug)
            Log.e(TAG, check(msg));
    }

    /**
     * check msg if null
     *
     * @param msg .
     * @return not null string
     */
    private static String check(String msg) {
        return msg == null ? "msg is null" : msg;
    }

    /**
     * json log.
     *
     * @param msg .
     */
    public static void json(String msg) {
        if (debug)
            Log.d(TAG, getPrettyJson(check(msg)));
    }

    private static final int JSON_INDENT = 2;

    /**
     * @param str .
     * @return json .
     */
    private static String getPrettyJson(String str) {
        try {
            String jsonStr = str.trim();
            if (jsonStr.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(jsonStr);
                return jsonObject.toString(JSON_INDENT);
            }
            if (jsonStr.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonStr);
                return jsonArray.toString(JSON_INDENT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Invalid Json, Please Check: " + str;
    }

}
