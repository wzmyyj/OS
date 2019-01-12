package com.osmeet.os.app.tools;

import android.view.View;
import android.view.animation.Animation;

import top.wzmyyj.wzm_sdk.tools.A;

/**
 * Created by yyj on 2018/12/09. email: 2209011667@qq.com
 * 统一动画管理类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class AA {

    private final static long Duration_1 = 800;
    private final static long Duration_2 = 1000;


    // 第一组。
    public static void next(View v1, View v2) {
        next_out(v1);
        next_in(v2);
    }

    public static void next_out(final View v) {
        next_out(v, null);
    }

    public static void next_out(final View v, Animation.AnimationListener listener) {
        int h = v.getHeight();
        A.create()
                .a(1, 0)
                .t(0, 0, 0, -h / 2)
                .s(1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f)
                .listener(listener != null ? listener : new A.Listener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        v.setVisibility(View.INVISIBLE);
                    }
                })
                .duration(Duration_1)
                .fillAfter(false)
                .into(v);
    }

    public static void next_in(final View v) {
        next_in(v, null);
    }

    public static void next_in(final View v, Animation.AnimationListener listener) {
        int h = v.getHeight();
        A.create()
                .a(0, 1)
                .t(0, 0, h / 2, 0)
                .s(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f)
                .listener(listener != null ? listener : new A.Listener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        v.setVisibility(View.VISIBLE);
                    }

                })
                .duration(Duration_1)
                .fillAfter(false)
                .into(v);
    }

    public static void back(View v1, View v2) {
        back_in(v1);
        back_out(v2);
    }

    public static void back_in(final View v) {
        back_in(v, null);
    }

    public static void back_in(final View v, Animation.AnimationListener listener) {
        int h = v.getHeight();
        A.create()
                .a(0, 1)
                .t(0, 0, -h / 2, 0)
                .s(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f)
                .listener(listener != null ? listener : new A.Listener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        v.setVisibility(View.VISIBLE);
                    }

                })
                .duration(Duration_1)
                .fillAfter(false)
                .into(v);
    }

    public static void back_out(final View v) {
        back_out(v, null);
    }

    public static void back_out(final View v, Animation.AnimationListener listener) {
        int h = v.getHeight();
        A.create()
                .a(1, 0)
                .t(0, 0, 0, h / 2)
                .s(1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f)
                .listener(listener != null ? listener : new A.Listener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        v.setVisibility(View.INVISIBLE);
                    }
                })
                .duration(Duration_1)
                .fillAfter(false)
                .into(v);
    }

    // 第二组。

    public static void enlarge2narrow(final View v) {
        A.create()
                .s(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
                .listener(new A.Listener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        A.create()
                                .s(2, 1, 2, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
                                .duration(Duration_2 / 2)
                                .fillAfter(false)
                                .into(v);
                    }
                })
                .duration(Duration_2 / 2)
                .fillAfter(true)
                .into(v);
    }

    public static void narrow2enlarge(final View v) {
        A.create()
                .s(1, 0.5f, 1, 0.5f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.5f)
                .listener(new A.Listener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        A.create()
                                .s(0.5f, 1, 0.5f, 1, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.5f)
                                .duration(Duration_2 / 2)
                                .fillAfter(false)
                                .into(v);
                    }
                })
                .duration(Duration_2 / 2)
                .fillAfter(true)
                .into(v);
    }

    public static void enlargeFromEnd(final View v) {
        A.create()
                .a(0, 1)
                .s(0.5f, 1, 0.5f, 1, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f)
                .duration(Duration_2 / 2)
                .fillAfter(false)
                .into(v);
    }


    // 第三组。

    public static void enlarge(final View v) {
        enlarge(v, null);
    }

    public static void enlarge(final View v, Animation.AnimationListener listener) {
        A.create()
                .a(0, 1)
                .s(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
                .listener(listener)
                .duration(Duration_2)
                .fillAfter(false)
                .into(v);
    }

    public static void appear(final View v) {
        appear(v, null);
    }

    public static void appear(final View v, Animation.AnimationListener listener) {
        A.create()
                .a(0, 1)
                .listener(listener)
                .duration(Duration_2)
                .fillAfter(false)
                .into(v);
    }


}
