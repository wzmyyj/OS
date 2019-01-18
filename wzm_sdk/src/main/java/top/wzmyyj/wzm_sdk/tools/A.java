package top.wzmyyj.wzm_sdk.tools;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by yyj on 2018/08/10.
 *
 * 补间动画封装类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class A {

    /**
     * Animation Set
     */
    private AnimationSet animSet;

    /**
     * private constructor
     */
    private A() {
        animSet = new AnimationSet(true);
    }

    /**
     * @return new A();
     */
    public static A create() {
        return new A();
    }

    /**
     * TranslateAnimation
     *
     * @param fromX .
     * @param toX .
     * @param fromY .
     * @param toY .
     * @return this
     */
    public A t(int fromX, int toX, int fromY, int toY) {
        TranslateAnimation t = new TranslateAnimation(fromX, toX, fromY, toY);
        animSet.addAnimation(t);
        return this;
    }

    /**
     * RotateAnimation
     *
     * @param fromDegrees .
     * @param toDegrees .
     * @param pivotXType .
     * @param pivotXValue .
     * @param pivotYType .
     * @param pivotYValue .
     * @return this
     */
    public A r(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
               int pivotYType, float pivotYValue) {
        RotateAnimation r = new RotateAnimation(fromDegrees, toDegrees,
                pivotXType, pivotXValue,
                pivotYType, pivotYValue);
        animSet.addAnimation(r);
        return this;
    }

    /**
     * ScaleAnimation
     *
     * @param fromX .
     * @param toX .
     * @param fromY .
     * @param toY .
     * @param pivotXType .
     * @param pivotXValue .
     * @param pivotYType .
     * @param pivotYValue .
     * @return this
     */
    public A s(float fromX, float toX, float fromY, float toY,
               int pivotXType, float pivotXValue,
               int pivotYType, float pivotYValue) {
        ScaleAnimation s = new ScaleAnimation(fromX, toX, fromY, toY,
                pivotXType, pivotXValue,
                pivotYType, pivotYValue);
        animSet.addAnimation(s);
        return this;
    }

    public A s(float fromX, float toX, float fromY, float toY,
               float pivotXValue,
               float pivotYValue) {
        ScaleAnimation s = new ScaleAnimation(fromX, toX, fromY, toY,
                pivotXValue,
                pivotYValue);
        animSet.addAnimation(s);
        return this;
    }

    public A s(float fromX, float toX, float fromY, float toY) {
        ScaleAnimation s = new ScaleAnimation(fromX, toX, fromY, toY);
        animSet.addAnimation(s);
        return this;
    }

    /**
     * AlphaAnimation
     *
     * @param fromAlpha .
     * @param toAlpha .
     * @return this
     */
    public A a(float fromAlpha, float toAlpha) {
        AlphaAnimation a = new AlphaAnimation(fromAlpha, toAlpha);
        animSet.addAnimation(a);
        return this;
    }

    /**
     * @param duration .
     * @return this
     */
    public A duration(long duration) {
        animSet.setDuration(duration);
        return this;
    }

    /**
     * @param repeatMode .
     * @return this
     */
    public A repeatMode(int repeatMode) {
        animSet.setRepeatMode(repeatMode);
        return this;
    }

    /**
     * @param fillAfter .
     * @return this
     */
    public A fillAfter(boolean fillAfter) {
        animSet.setFillAfter(fillAfter);
        return this;
    }

    /**
     * @param fillBefore .
     * @return this
     */
    public A fillBefore(boolean fillBefore) {
        animSet.setFillBefore(fillBefore);
        return this;
    }

    /**
     * @param startOffset .
     * @return this
     */
    public A setStartOffset(long startOffset) {
        animSet.setStartOffset(startOffset);
        return this;
    }

    /**
     * Animation.AnimationListener
     *
     * @param listener .
     * @return this
     */
    public A listener(Animation.AnimationListener listener) {
        if (listener != null)
            animSet.setAnimationListener(listener);
        return this;
    }

    /**
     * @return this
     */
    public A reset() {
        animSet.reset();
        return this;
    }

    /**
     * @return animSet
     */
    public AnimationSet getAnim() {
        return animSet;
    }


    /**
     * view start animation
     *
     * @param view .
     */
    public void into(View view) {
        view.setAnimation(animSet);
    }


    /**
     * a Animation.AnimationListener
     */
    public static abstract class Listener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }



        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
