package top.wzmyyj.wzm_sdk.activity;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.R;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.TabLayoutUtil;
import top.wzmyyj.wzm_sdk.widget.SlideViewPager;

/**
 * Created by wzm on 2018/04/18.
 * <p>
 * ViewPager+Fragment Activity
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class PagerFragmentActivity extends InitActivity {

    protected List<Fragment> mFragmentList = new ArrayList<>();
    protected TabLayout mTabLayout;
    protected SlideViewPager mViewPager;
    protected FragmentPagerAdapter mAdapter;

    protected List<FT> mFTs = new ArrayList<>();

    protected class FT {
        public Fragment fragment;
        public String str;
        public int icon_unselected;// 默认的。
        public int icon_selected;// 选中的。

        public FT(Fragment fragment, String str, int icon_unselected, int icon_selected) {
            this.fragment = fragment;
            this.str = str;
            this.icon_unselected = icon_unselected;
            this.icon_selected = icon_selected;
        }
    }

    @Override
    protected boolean swipeBackEnable() {
        return false;
    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_pager_fragment);
    }


    @Override
    protected void initView() {
        mViewPager = (SlideViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public Fragment getItem(int a) {
                return mFragmentList.get(a);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        int tabHeight = initTabHeight();
        if (tabHeight != mTabLayout.getHeight()) {
            mTabLayout.getLayoutParams().height = tabHeight;
            mTabLayout.requestLayout();
        }

        initFTs(mFTs);
        if (mFTs == null || mFTs.size() == 0) {
            return;
        }
        int i = 0;
        for (FT ft : mFTs) {
            mFragmentList.add(ft.fragment);
            if (++i >= 6) break;
        }
        mAdapter.notifyDataSetChanged();
        setTabTextColor();
        initTabStyle();
        defaultTabStyle();
        TabLayoutUtil.setStyle(mTabLayout, mTabLayoutStyle);
        int which = firstWhich();
        if (which < mFragmentList.size())
            mViewPager.setCurrentItem(which, false);
    }

    /**
     * @param fts list of FT.
     */
    protected abstract void initFTs(List<FT> fts);


    protected int text_color_selected;
    protected int text_color_unselected;


    @SuppressLint("NewApi")
    protected void setTabTextColor() {
        text_color_selected = getResources().getColor(R.color.colorGray_6, null);
        text_color_unselected = getResources().getColor(R.color.colorGray_b, null);

    }

    /**
     * @return tab height.
     */
    protected int initTabHeight() {
        return DensityUtil.dp2px(context, 55);
    }

    private TabLayoutUtil.TabLayoutStyle mTabLayoutStyle;

    /**
     * @param tabLayoutStyle style.
     */
    protected void setTabLayoutStyle(TabLayoutUtil.TabLayoutStyle tabLayoutStyle) {
        this.mTabLayoutStyle = tabLayoutStyle;
    }

    /**
     * 给mTabLayoutStyle赋值。
     */
    protected void initTabStyle() {
        // setTabLayoutStyle()：
    }


    private void defaultTabStyle() {
        if (mTabLayoutStyle == null) {
            // 设置默认样式。
            setTabLayoutStyle(new TabLayoutUtil.TabLayoutStyle() {
                final List<ImageView> imageViewList = new ArrayList<>();
                final List<TextView> textViewList = new ArrayList<>();

                @Override
                public void setCustomView(TabLayout.Tab tab) {
                    if (tab == null) return;
                    View customView = tab.setCustomView(R.layout.layout_tab).getCustomView();
                    if (customView == null) return;
                    TextView tv_tab = customView.findViewById(R.id.tv_tab);
                    tv_tab.setText(mFTs.get(tab.getPosition()).str);
                    ImageView img_tab = customView.findViewById(R.id.img_tab);
                    imageViewList.add(img_tab);
                    textViewList.add(tv_tab);
                }

                @Override
                public void setTabSelected(TabLayout.Tab tab) {
                    int p = tab.getPosition();
                    imageViewList.get(p).setImageResource(mFTs.get(p).icon_selected);
                    textViewList.get(p).setTextColor(text_color_selected);
                }

                @Override
                public void setTabUnselected(TabLayout.Tab tab) {
                    int p = tab.getPosition();
                    imageViewList.get(p).setImageResource(mFTs.get(p).icon_unselected);
                    textViewList.get(p).setTextColor(text_color_unselected);
                }

                @Override
                public void setTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }


    /**
     * @return which.
     */
    protected int firstWhich() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


}
