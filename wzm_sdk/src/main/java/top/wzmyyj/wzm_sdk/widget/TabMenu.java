package top.wzmyyj.wzm_sdk.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.R;


/**
 * Created by wzm on 2018/04/21.
 * <p>
 * 类似：口口口口口 。这个样子的一排按钮。TAT..
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class TabMenu extends LinearLayout {

    private static final String TAG = "TabMenu";

    private static final int ITEM_COUNT_MAX = 6;

    private int icon_size;
    private int text_size;
    private int item_bg;
    private int text_color;

    private final List<LinearLayout> layouts;
    private final List<ImageView> images;
    private final List<TextView> texts;
    private final List<Tab> tabList;

    private class Tab {
        private String text;
        private int icon;
        private OnClickListener onClickListener;

        Tab(String text, int icon, OnClickListener onClickListener) {
            this.text = text;
            this.icon = icon;
            this.onClickListener = onClickListener;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public OnClickListener getOnClickListener() {
            return onClickListener;
        }

        public void setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }


    }

    public List<Tab> getTabs() {
        return this.tabList;
    }

    public void clearTabs() {
        this.tabList.clear();
        updateItem();
    }

    public void addTab(String text, int icon) {
        if (tabList.size() == ITEM_COUNT_MAX) return;
        this.tabList.add(new Tab(text, icon, null));
        updateItem();
    }

    public void addTab(String text, int icon, OnClickListener onClickListener) {
        if (tabList.size() == ITEM_COUNT_MAX) return;
        this.tabList.add(new Tab(text, icon, onClickListener));
        updateItem();
    }

//    private OnMenuItemClickListener mMenuItemClickListener;
//
//    public void setOnMenuItemClickListener(
//            OnMenuItemClickListener mMenuItemClickListener) {
//        this.mMenuItemClickListener = mMenuItemClickListener;
//    }
//
//    public interface OnMenuItemClickListener {
//        void onClick(View view, int p);
//    }

    public void setMenuItemStyle(MenuItemStyle menuItemStyle) {
        if (menuItemStyle == null) return;
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            menuItemStyle.setStyle(layouts.get(i), images.get(i), texts.get(i));
        }
    }

    public interface MenuItemStyle {
        void setStyle(LinearLayout item, ImageView img, TextView tv);
    }

    private boolean once;

    public TabMenu(Context context) {
        this(context, null);
    }

    public TabMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        layouts = new ArrayList<>();
        images = new ArrayList<>();
        texts = new ArrayList<>();
        tabList = new ArrayList<>();

        if (!once) {
            this.setOrientation(LinearLayout.HORIZONTAL);
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.TabMenu, defStyle, 0);
            icon_size = (int) a.getDimension(R.styleable.TabMenu_icon_size, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25,
                            getResources().getDisplayMetrics()));
            text_size = (int) a.getDimension(R.styleable.TabMenu_android_textSize, TypedValue
                    .applyDimension(TypedValue.COMPLEX_UNIT_SP, 10,
                            getResources().getDisplayMetrics()));
            item_bg = a.getResourceId(R.styleable.TabMenu_item_bg, 0);
            text_color = a.getColor(R.styleable.TabMenu_android_textColor, 0x777777);
            a.recycle();
            init();
            once = true;
        }
    }

    private void init() {
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            final LinearLayout layout = new LinearLayout(this.getContext());
            this.addView(layout, i);
            layout.setVisibility(View.GONE);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setBackgroundResource(item_bg);
            layout.setClickable(true);
            LayoutParams param1 = new LayoutParams(
                    0, LayoutParams.MATCH_PARENT);
            param1.weight = 1;
            layout.setLayoutParams(param1);
            //icon
            ImageView img = new ImageView(this.getContext());
            layout.addView(img);
            LayoutParams param2 = new LayoutParams(
                    icon_size, icon_size);
            param2.topMargin = icon_size / 3;
            param2.gravity = Gravity.CENTER_HORIZONTAL;
            img.setLayoutParams(param2);
            //text
            TextView tv = new TextView(this.getContext());
            layout.addView(tv);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size);
            LayoutParams param3 = new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            param3.gravity = Gravity.CENTER_HORIZONTAL;
            tv.setLayoutParams(param3);
            tv.setGravity(Gravity.CENTER);

//            final int w = i;
//            layout.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mMenuItemClickListener != null) {
//                        mMenuItemClickListener.onClick(layout, w);
//                    }
//                }
//            });

            layouts.add(layout);
            images.add(img);
            texts.add(tv);
        }
    }


    public void updateItem() {
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            if (i < tabList.size()) {
                layouts.get(i).setOnClickListener(tabList.get(i).onClickListener);
                layouts.get(i).setVisibility(View.VISIBLE);
                images.get(i).setImageResource(tabList.get(i).icon);
                texts.get(i).setText(tabList.get(i).text);
            } else {
                layouts.get(i).setOnClickListener(null);
                layouts.get(i).setVisibility(View.GONE);
            }
        }
    }


    public void setItemTextColor(int text_color) {
        this.text_color = text_color;
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            texts.get(i).setTextColor(this.text_color);
        }
    }

    public void setItemTextSize(int text_size) {
        this.text_size = text_size;
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            texts.get(i).setTextSize(this.text_size);
        }
    }

    public void setItemIconSize(int icon_size) {
        this.icon_size = icon_size;
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            ViewGroup.LayoutParams param = images.get(i).getLayoutParams();
            param.height = icon_size;
            param.width = icon_size;
            images.get(i).requestLayout();
        }

    }

    public void setItemBg(@DrawableRes int item_bg) {
        this.item_bg = item_bg;
        for (int i = 0; i < ITEM_COUNT_MAX; i++) {
            layouts.get(i).setBackgroundResource(item_bg);
        }
    }

}