package com.osmeet.os.app.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by yyj on 2019/01/08. email: 2209011667@qq.com
 */

public class ApkUtil {
    @SuppressWarnings("deprecation")
    public static boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> info = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (info != null) {
            for (int i = 0; i < info.size(); i++) {
                String pn = info.get(i).packageName;
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
