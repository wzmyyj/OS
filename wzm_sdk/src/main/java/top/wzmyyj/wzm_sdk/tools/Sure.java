package top.wzmyyj.wzm_sdk.tools;

import android.support.annotation.NonNull;

/**
 * Created by yyj on 2019/01/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Sure {
    /**
     * @param is is true.
     * @param msg .
     */
    public static void sure(boolean is, @NonNull String msg) {
        if (!is) {
            throw new RuntimeException(msg);
        }
    }
}
