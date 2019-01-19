package top.wzmyyj.wzm_sdk.java;

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
     * @param arr .
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
     * @param n .
     * @return random int[]
     */
    public static int[] getInt(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        sort(a);
        return a;
    }


    /**
     * @param list .
     * @param <A> .
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
     * @param list .
     * @param start .
     * @param end .
     * @param <A> .
     */
    public static <A> void sort(List<A> list, int start, int end) {
        if (list == null || list.size() == 0) return;

        if (start < 0 || end > list.size() - 1 || end - start <= 1) return;

        for (int i = start; i < end + 1; i++) {
            Random random = new Random();
            int p = random.nextInt(i - start + 1) + start;
            A tmp = list.get(i);
            list.set(i, list.get(p));
            list.set(p, tmp);
        }
    }
}