package top.wzmyyj.wzm_sdk.utils;

import java.util.List;
import java.util.Random;


/**
 * Created by wzm on 2018/5/4.
 *
 * 随机排序。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class RandomSortUtil {

    /**
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Random random = new Random();
            int p = random.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[p];
            arr[p] = tmp;
        }
    }

    /**
     * @param l
     * @return random int[]
     */
    public static int[] getInt(int l) {
        int[] a = new int[l];

        for (int i = 0; i < l; i++) {
            a[i] = i;
        }
        sort(a);
        return a;
    }


    /**
     * @param list
     * @param <A>
     */
    public static <A> void sort(List<A> list) {
        if (list == null || list.size() == 0) return;
        for (int i = 1; i < list.size(); i++) {
            Random random = new Random();
            int p = random.nextInt(i + 1);
            A tmp = list.get(i);
            list.set(i, list.get(p));
            list.set(p, tmp);
        }
    }

    /**
     * @param list
     * @param m
     * @param n
     * @param <A>
     */
    public static <A> void sort(List<A> list, int m, int n) {
        if (list == null || list.size() == 0) return;

        if (m < 0 || n > list.size() - 1 || n - m <= 1) return;

        for (int i = m; i < n + 1; i++) {
            Random random = new Random();
            int p = random.nextInt(i - m + 1) + m;
            A tmp = list.get(i);
            list.set(i, list.get(p));
            list.set(p, tmp);
        }
    }
}