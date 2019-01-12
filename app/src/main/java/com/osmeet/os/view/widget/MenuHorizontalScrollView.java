package com.osmeet.os.view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;

/**
 * Created by yyj on 2018/12/27. email: 2209011667@qq.com
 */

public class MenuHorizontalScrollView extends HorizontalScrollView {

    private int mRightWeith = 200;
    private LinearLayout mWapper;
    private View mContent;
    private View mMenu;
    private boolean once;
    private boolean isOpen = false;

    public MenuHorizontalScrollView(Context context) {
        this(context, null);
    }

    public MenuHorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mWapper = (LinearLayout) getChildAt(0);
            mContent = mWapper.getChildAt(0);
            mMenu = mWapper.getChildAt(1);

            mContent.getLayoutParams().width = MockUtil.getScreenWidth(getContext());
            mContent.requestLayout();

            mRightWeith = DensityUtil.dp2px(getContext(), 80);

            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (getScrollX() == 0 && (ev.getX() < mContent.getWidth() - mRightWeith)) {
            getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (isOpen) {
                    if (scrollX < mMenu.getWidth() * 4 / 5) {
                        this.smoothScrollTo(0, 0);
                        isOpen = false;
                    } else {
                        this.smoothScrollTo(mMenu.getWidth(), 0);
                    }
                } else {
                    if (scrollX >= mMenu.getWidth() / 5) {
                        this.smoothScrollTo(mMenu.getWidth(), 0);
                        isOpen = true;
                    } else {
                        this.smoothScrollTo(0, 0);
                    }
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }


    /**
     * 打开菜单
     */
    public void openMenu() {
        if (isOpen)
            return;
        this.smoothScrollTo(mMenu.getWidth(), 0);
        isOpen = true;
    }

    public void closeMenu() {
        if (!isOpen)
            return;
        this.smoothScrollTo(0, 0);
        isOpen = false;
    }

    /**
     * 切换菜单
     */
    public void toggle() {
        if (isOpen) {
            closeMenu();
        } else {
            openMenu();
        }
    }

    public void setRightWeith(int rightWeith) {
        this.mRightWeith = rightWeith;
    }
}
