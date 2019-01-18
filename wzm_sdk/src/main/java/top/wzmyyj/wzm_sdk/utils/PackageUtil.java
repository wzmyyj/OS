package top.wzmyyj.wzm_sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by yyj on 2018/08/21
 *
 * 获取版本号，包名等工具类。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class PackageUtil {

    /**
     * 获取应用版本号名称。
     *
     * @param context
     * @return 应用版本号名称(String)
     */
    public static String getVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo infro = manager.getPackageInfo(context.getPackageName(), 0);
            return infro.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取应用版本号。
     *
     * @param context
     * @return 应用版本号(int)
     */
    public static int getVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo infro = manager.getPackageInfo(context.getPackageName(), 0);
            return infro.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获取应用包名。
     *
     * @param context
     * @return 应用包名(String)
     */
    public static String getPackageName(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo infro = manager.getPackageInfo(context.getPackageName(), 0);
            return infro.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}