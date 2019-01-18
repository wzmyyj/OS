package top.wzmyyj.wzm_sdk.utils;

import android.support.design.widget.TabLayout;

/**
 * Created by yyj on 2018/12/19.
 *
 * TabLayout设置样式。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class TabLayoutUtil {
    /**
     * @param tabLayout .
     * @param tabLayoutStyle .
     */
    public static void setStyle(TabLayout tabLayout, final TabLayoutStyle tabLayoutStyle) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tabLayoutStyle.setCustomView(tab);
            if (tab == null) continue;
            if (tab.isSelected()) {
                tabLayoutStyle.setTabSelected(tab);
            } else {
                tabLayoutStyle.setTabUnselected(tab);
            }
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayoutStyle.setTabSelected(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayoutStyle.setTabUnselected(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tabLayoutStyle.setTabReselected(tab);
            }
        });
    }

    /**
     * TabLayout Style.
     */
    public interface TabLayoutStyle {
        void setCustomView(TabLayout.Tab tab);

        void setTabSelected(TabLayout.Tab tab);

        void setTabUnselected(TabLayout.Tab tab);

        void setTabReselected(TabLayout.Tab tab);
    }
}
