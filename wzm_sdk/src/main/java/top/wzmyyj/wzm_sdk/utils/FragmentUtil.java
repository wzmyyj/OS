package top.wzmyyj.wzm_sdk.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yyj on 2019/01/02.
 *
 * 添加fragment的两种方式。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FragmentUtil {

    /**
     * @param fm
     * @param containerViewId
     * @param fragment
     * @param tag
     */
    public static void addFragment(@NonNull FragmentManager fm, @IdRes int containerViewId,
                                   Fragment fragment, @Nullable String tag) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }

    /**
     * @param fm
     * @param containerViewId
     * @param fragment
     * @param tag
     */
    public static void replaceFragment(@NonNull FragmentManager fm, @IdRes int containerViewId,
                                       Fragment fragment, @Nullable String tag) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }
}
