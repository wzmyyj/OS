package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.StoreContract;
import com.osmeet.os.presenter.StorePresenter;
import com.osmeet.os.view.fragment.StoreInfoFragment;
import com.osmeet.os.view.fragment.UserInfoFragment;
import com.osmeet.os.view.panel.StoreFrontPanel;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.adapter.InitFragmentPagerAdapter;
import top.wzmyyj.wzm_sdk.fragment.InitFragment;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 * 商店详情。
 */

public class StoreActivity extends BaseActivity<StoreContract.IPresenter> implements StoreContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new StorePresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_store;
    }

    StoreFrontPanel storeFrontPanel;
    StoreInfoFragment storeInfoFragment;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(storeFrontPanel = new StoreFrontPanel(context, mPresenter));
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;
    @BindView(R.id.vp_content)
    ViewPager mViewPager;

    private List<InitFragment> mFragmentList = new ArrayList<>();
    private InitFragmentPagerAdapter mAdapter;

    @SuppressWarnings("unchecked")
    public <F extends InitFragment> F getFragment(int i) {
        if (i < 0 || i > mFragmentList.size() - 1) return null;
        return (F) mFragmentList.get(i);
    }

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
        storeInfoFragment = new StoreInfoFragment();
        mFragmentList.add(storeInfoFragment);
        mAdapter = new InitFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList) {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //super.destroyItem(container, position, object);
            }
        };
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter);
        try {
            mViewPager.setPageTransformer(false, Transformer.Accordion.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadStoreInfo();
        mPresenter.loadMatchUnitList();
    }

    @Override
    protected void initListener() {
        super.initListener();
//        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                storeFrontPanel.whenSwitch(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    @Override
    public void showStoreInfo(@NonNull Store store) {
        storeInfoFragment.setStore(store);
        storeFrontPanel.setStore(store);
    }

    @Override
    public void showMatchUnitList(@NonNull List<MatchUnit> matchUnitList) {

        mFragmentList.clear();
        mFragmentList.add(storeInfoFragment);
        for (int i = 0; i < matchUnitList.size(); i++) {
            UserInfoFragment userInfoFragment = new UserInfoFragment();
            userInfoFragment.setUserId(matchUnitList.get(i).getUser().getId());
            userInfoFragment.setUnitId(matchUnitList.get(i).getId());
            mFragmentList.add(userInfoFragment);
        }
        mAdapter.notifyDataSetChanged();

        List<User> userList = new ArrayList<>();
        for (MatchUnit matchUnit : matchUnitList) {
            User user = matchUnit.getUser();
            userList.add(user);
        }
        storeFrontPanel.setUserList(userList);
    }

    public void setCurrentItem(int i) {
        mViewPager.setCurrentItem(i, false);
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

}

