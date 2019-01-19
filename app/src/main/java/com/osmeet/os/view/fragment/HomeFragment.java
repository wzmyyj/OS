package com.osmeet.os.view.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Category;
import com.osmeet.os.app.tools.G;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.HomeContract;
import com.osmeet.os.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.adapter.InitFragmentPagerAdapter;
import top.wzmyyj.wzm_sdk.fragment.InitFragment;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.TabLayoutUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class HomeFragment extends BaseFragment<HomeContract.IPresenter> implements HomeContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new HomePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @BindView(R.id.tab_top)
    TabLayout mTabLayout;
    @BindView(R.id.vp_content)
    ViewPager mViewPager;
    @BindView(R.id.abl_top)
    AppBarLayout mAppBarLayout;

    private List<InitFragment> mFragmentList = new ArrayList<>();
    private InitFragmentPagerAdapter mAdapter;

    @Override
    protected void initView() {
        super.initView();
        mAdapter = new InitFragmentPagerAdapter(getChildFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mAdapter);
    }


    @Override
    protected void initListener() {
        super.initListener();
        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            int h = DensityUtil.dp2px(context, 45);
            int h2 = DensityUtil.dp2px(context, 60);
            int h3 = DensityUtil.dp2px(context, 45);
            float scale = (-1f) * verticalOffset / h;// 0->1
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mTabLayout.getLayoutParams();
            int he = (int) (h2 - scale * (h2 - h3));
            if (params.height != he) {// 防止不动时，反复重新绘制。
                params.height = he;
                mTabLayout.requestLayout();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadCategoryList();
    }

    private boolean isOnce = false;

    // 该方法只能执行一次。
    @Override
    public void showCategoryList(@NonNull List<Category> categoryList) {
        if (isOnce) return;
        isOnce = true;
        int size = categoryList.size();
        if (size == 0) return;

        mFragmentList.clear();
        for (int i = 0; i < size; i++) {
            HomeStoreFragment homeStoreFragment = new HomeStoreFragment();
            homeStoreFragment.setCategoryId(categoryList.get(i).getId());
            homeStoreFragment.setTitle(categoryList.get(i).getName());
            mFragmentList.add(homeStoreFragment);
        }

        mAdapter.notifyDataSetChanged();
        mTabLayout.setupWithViewPager(mViewPager);

        setTabLayoutStyle(mTabLayout, categoryList);
    }

    private void setTabLayoutStyle(TabLayout tabLayout, final List<Category> categoryList) {
        // 自定义TabLayout.Tab样式。

        TabLayoutUtil.setStyle(tabLayout, new TabLayoutUtil.TabLayoutStyle() {
            List<View> viewList = new ArrayList<>();
            List<TextView> textViewList = new ArrayList<>();
            List<ImageView> imageViewList = new ArrayList<>();

            @Override
            public void setCustomView(TabLayout.Tab tab) {
                if (tab == null) return;
                View customView = tab.setCustomView(R.layout.layout_home_tab_item).getCustomView();
                if (customView == null) return;
                int p = tab.getPosition();
                View view = customView.findViewById(R.id.v_tab_item_indicator);
                TextView textView = customView.findViewById(R.id.tv_tab_item_text);
                textView.setText(categoryList.get(p).getName());
                ImageView imageView = customView.findViewById(R.id.img_tab_item_bg);
                String url = categoryList.get(p).getLogo().getUrl();
                G.img(getActivity(), url, imageView);
                viewList.add(view);
                textViewList.add(textView);
                imageViewList.add(imageView);
            }

            @Override
            public void setTabSelected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                WidgetUtil.setTextColor(textViewList.get(p), R.color.colorWhite);
                viewList.get(p).setVisibility(View.VISIBLE);
            }

            @Override
            public void setTabUnselected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                WidgetUtil.setTextColor(textViewList.get(p), R.color.colorGray_b);
                viewList.get(p).setVisibility(View.GONE);
            }

            @Override
            public void setTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
