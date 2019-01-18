package top.wzmyyj.wzm_sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yyj on 2018/12/28.
 *
 * 可以控制是否可滑动的ViewPager。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class SlideViewPager extends ViewPager {
    public SlideViewPager(@NonNull Context context) {
        super(context);
    }

    public SlideViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean isSlide = true;

    /**
     * @return
     */
    public boolean isSlide() {
        return isSlide;
    }

    /**
     * @param slide
     */
    public void setSlide(boolean slide) {
        isSlide = slide;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isSlide && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide && super.onInterceptTouchEvent(ev);
    }
}
