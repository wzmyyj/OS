package top.wzmyyj.wzm_sdk.utils;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ViewTitlePagerAdapter;
import top.wzmyyj.wzm_sdk.panel.Panel;

/**
 * Created by yyj on 2019/01/22.
 * <p>
 * Panel Util.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class PanelUtil {
    /**
     * @param panelList .
     * @param tabLayout .
     * @param viewPager .
     */
    public static void in(@NonNull List<Panel> panelList, @NonNull TabLayout tabLayout, @NonNull ViewPager viewPager) {
        List<View> viewList = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (Panel p : panelList) {
            viewList.add(p.getView());
            titles.add(p.getTitle());
        }
        ViewTitlePagerAdapter pagerAdapter = new ViewTitlePagerAdapter(viewList, titles);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * @param panel       .
     * @param frameLayout .
     */
    public static void in(Panel panel, FrameLayout frameLayout) {
        frameLayout.addView(panel.getView());
    }
}
