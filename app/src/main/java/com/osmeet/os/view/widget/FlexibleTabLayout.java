package com.osmeet.os.view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;


/**
 * Created by yyj on 2019/02/25.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FlexibleTabLayout extends TabLayout {
    private static final String TAG = "FlexibleTabLayout";
    private boolean isMoveLeft;//左边是否能移动
    private boolean isMoveRight;
    private Rect normal = new Rect();//记录原来的位置
    private OnRefreshListener listener;
    float x = 0;//记录开始触摸的位置
    int xMove = 0;//移动的距离
    private int SCALE = 5;

    public FlexibleTabLayout(Context context) {
        super(context);
    }

    public FlexibleTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlexibleTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (x == 0) {
                    x = ev.getX();//记录位置
                }
                xMove = (int) (x - ev.getX()) / 2;//计算移动距离
                Log.e(TAG, "xMove:" + xMove + " isMoveLeft:" + isMoveLeft + "isMoveRight:" + isMoveRight);
                if (isMoveLeft && xMove <= 0 || isMoveRight && xMove >= 0) {//移动位置
                    this.layout(normal.left - xMove, normal.top, normal.right - xMove, normal.bottom);
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP://多点触摸
            case MotionEvent.ACTION_POINTER_INDEX_SHIFT:
                if (isMoveLeft && xMove <= 0 || isMoveRight && xMove >= 0) {
                    animation(xMove);//还原位置
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
//        Log.e(TAG, "scrollX:" + scrollX + " clampedX:" + clampedX + " hh: " + this.canScrollHorizontally(2));

        if (clampedX) {
            isMoveLeft = scrollX == 0;
            isMoveRight = !this.canScrollHorizontally(2);
            if (normal.isEmpty() || normal.top - normal.bottom == 0) {
                normal.set(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());//viewpager记录原来位置
            }
        } else {
            isMoveLeft = false;
            isMoveRight = false;
        }
    }

    /***
     * 回缩动画
     */
    public void animation(int moveX) {
        if (listener != null) {
            if (moveX > getWidth() / SCALE) {//滑动的距离超过屏幕的1/SCALE才回调
                listener.onLoadMore();
            } else if (moveX < -getWidth() / SCALE) {
                listener.onRefresh();
            }
        }
        this.layout(normal.left, normal.top, normal.right, normal.bottom);

        TranslateAnimation ta = new TranslateAnimation(-moveX, 0, 0, 0);
        ta.setDuration(200);
        this.startAnimation(ta);

        x = 0;
        xMove = 0;
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        this.listener = listener;
    }

    public interface OnRefreshListener {
        void onRefresh();

        void onLoadMore();
    }

}
