package top.wzmyyj.wzm_sdk.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wzm on 2018/04/17. email: 2209011667@qq.com
 */


public class ViewTitlePagerAdapter extends PagerAdapter {
    private List<String> titles;
    private List<View> viewList;
    private boolean isLoop;


    public ViewTitlePagerAdapter(List<View> viewList) {
        this(viewList, null, false);
    }

    public ViewTitlePagerAdapter(List<View> viewList, List<String> titles) {
        this(viewList, titles, false);
    }

    public ViewTitlePagerAdapter(List<View> viewList, boolean isLoop) {
        this(viewList, null, isLoop);
    }

    public ViewTitlePagerAdapter(List<View> viewList, List<String> titles, boolean isLoop) {
        this.viewList = viewList;
        this.titles = titles;
        this.isLoop = isLoop;
    }


    public int getCount() {
        if (isLoop) {
            return Integer.MAX_VALUE;
        } else {
            return viewList.size();
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        if (isLoop) {
            View v = viewList.get(position % viewList.size());
            ViewGroup parent = (ViewGroup) v.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }

            container.addView(v);
            return v;
        }
        container.addView(viewList.get(position));
        return viewList.get(position);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles == null) {
            return null;
        }
        if (isLoop) {
            return titles.get(position % titles.size());
        }
        return titles.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
