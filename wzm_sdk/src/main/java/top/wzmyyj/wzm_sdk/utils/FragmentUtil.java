package top.wzmyyj.wzm_sdk.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class FragmentUtil {

    public static void addFragment(@NonNull FragmentManager fm, @IdRes int containerViewId,
                                   Fragment fragment, @Nullable String tag) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }

    public static void replaceFragment(@NonNull FragmentManager fm, @IdRes int containerViewId,
                                       Fragment fragment, @Nullable String tag) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }
}
