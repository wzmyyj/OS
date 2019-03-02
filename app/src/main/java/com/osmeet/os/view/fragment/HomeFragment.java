package com.osmeet.os.view.fragment;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Category;
import com.osmeet.os.base.fragment.BaseFragment;
import com.osmeet.os.contract.HomeContract;
import com.osmeet.os.presenter.HomePresenter;
import com.osmeet.os.view.adapter.DFragmentPagerAdapter;
import com.yanzhenjie.permission.AndPermission;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.fragment.InitFragment;
import top.wzmyyj.wzm_sdk.tools.T;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class HomeFragment extends BaseFragment<HomeContract.IPresenter> implements HomeContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new HomePresenter(fragment, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @OnClick({R.id.img_search, R.id.tv_search})
    void search() {
        mPresenter.goSearch();
    }

    @OnClick(R.id.img_scan)
    void scan() {
        AndPermission.with(activity)
                .permission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .onGranted(permissions -> mPresenter.goScan())
                .onDenied(permissions -> T.s("No Permission"))
                .start();
//        mPresenter.goScan();
    }

    @BindView(R.id.tab_top)
    TabLayout mTabLayout;
    @BindView(R.id.vp_content)
    ViewPager mViewPager;
    @BindView(R.id.abl_top)
    AppBarLayout mAppBarLayout;

    private List<InitFragment> mFragmentList = new ArrayList<>();
    private DFragmentPagerAdapter mAdapter;

    @Override
    protected void initView() {
        super.initView();
        mAdapter = new DFragmentPagerAdapter(getChildFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mAdapter);
    }

    @BindView(R.id.fl_bar)
    FrameLayout fl_bar;
    @BindView(R.id.tv_xx)
    TextView tv_xx;
    @BindView(R.id.v_bu)
    View v_bu;// 布。

    @Override
    protected void initListener() {
        super.initListener();
        tv_xx.setOnClickListener(v -> mPresenter.toast("This Is Center"));
        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {

            int h1 = DensityUtil.dp2px(context, 150);
            int h2 = DensityUtil.dp2px(context, 180);

            int v=-verticalOffset;
            if(v>h1) {
                float f = 1.0f * (v-h1)/ (h2-h1);// 0->1
                v_bu.setAlpha(f);
            }else{
                v_bu.setAlpha(0);
            }

        });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadCategoryList();
    }


    @Override
    public void showCategoryList(@NonNull List<Category> categoryList) {
        int size = categoryList.size();
        if (size == 0) return;

        mFragmentList.clear();
        for (int i = 0; i < size; i++) {
            HomeStoreFragment homeStoreFragment = HomeStoreFragment.newInstance(categoryList.get(i).getId());
            homeStoreFragment.setTitle(categoryList.get(i).getName());
            mFragmentList.add(homeStoreFragment);
        }

        mAdapter.notifyDataSetChanged();
        mTabLayout.clearOnTabSelectedListeners();
        mTabLayout.setupWithViewPager(mViewPager);
//        setTabLayoutStyle(mTabLayout, categoryList);
    }

//    private void setTabLayoutStyle(TabLayout tabLayout, final List<Category> categoryList) {
//        // 自定义TabLayout.Tab样式。
//
//        tabLayout.clearOnTabSelectedListeners();
//        tabLayout.setupWithViewPager(mViewPager);
//        TabLayoutUtil.setStyle(tabLayout, new TabLayoutUtil.TabLayoutStyle() {
//            List<View> viewList = new ArrayList<>();
//            List<TextView> textViewList = new ArrayList<>();
//            List<ImageView> imageViewList = new ArrayList<>();
//
//            @Override
//            public void setCustomView(TabLayout.Tab tab) {
//                if (tab == null) return;
//                View customView = tab.setCustomView(R.layout.layout_home_tab_item).getCustomView();
//                if (customView == null) return;
//                int p = tab.getPosition();
//                View view = customView.findViewById(R.id.v_tab_item_indicator);
//                TextView textView = customView.findViewById(R.id.tv_tab_item_text);
//                textView.setText(categoryList.get(p).getName());
//                ImageView imageView = customView.findViewById(R.id.img_tab_item_bg);
//                if (categoryList.get(p).getLogo() != null) {
//                    String url = categoryList.get(p).getLogo().getUrl();
//                    G.img(getActivity(), url, imageView);
//                } else {
//                    imageView.setImageResource(R.color.colorBlue);
//                }
//                viewList.add(view);
//                textViewList.add(textView);
//                imageViewList.add(imageView);
//            }
//
//            @Override
//            public void setTabSelected(TabLayout.Tab tab) {
//                int p = tab.getPosition();
//                WidgetUtil.setTextColor(textViewList.get(p), R.color.colorWhite);
//                viewList.get(p).setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void setTabUnselected(TabLayout.Tab tab) {
//                int p = tab.getPosition();
//                WidgetUtil.setTextColor(textViewList.get(p), R.color.colorGray_b);
//                viewList.get(p).setVisibility(View.GONE);
//            }
//
//            @Override
//            public void setTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
}
