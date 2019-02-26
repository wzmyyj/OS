package com.osmeet.os.view.activity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kongzue.dialog.v2.BottomMenu;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.StoreContract;
import com.osmeet.os.presenter.StorePresenter;
import com.osmeet.os.view.adapter.DFragmentPagerAdapter;
import com.osmeet.os.view.fragment.StoreInfoFragment;
import com.osmeet.os.view.fragment.UserInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.fragment.InitFragment;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.TabLayoutUtil;

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

    private StoreInfoFragment storeInfoFragment;
    private List<UserInfoFragment> userInfoFragmentList = new ArrayList<>();

    private List<InitFragment> mFragmentList = new ArrayList<>();
    private DFragmentPagerAdapter mAdapter;


    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;
    @BindView(R.id.vp_content)
    ViewPager mViewPager;

    @BindView(R.id.tab_select)
    TabLayout tab_select;

    @BindView(R.id.fl_bottom)
    FrameLayout fl_bottom;// 底部。



    @SuppressWarnings("unchecked")
    public <F extends InitFragment> F getFragment(int i) {
        if (i < 0 || i > mFragmentList.size() - 1) return null;
        return (F) mFragmentList.get(i);
    }


    private View mTopBar;
    private TextView tv_name_top;
    private ImageView img_avatar_top;
    private LinearLayout ll_tap_bar;

    @SuppressLint("InflateParams")
    private void setTopBar() {
        mTopBar = mInflater.inflate(R.layout.layout_info_top_bar, null);
        tv_name_top = mTopBar.findViewById(R.id.tv_name_top);
        img_avatar_top = mTopBar.findViewById(R.id.img_avatar_top);
        ll_tap_bar = mTopBar.findViewById(R.id.ll_top_abr);
        ll_tap_bar.setAlpha(0f);
        ImageView img_back = mTopBar.findViewById(R.id.img_back);
        img_back.setOnClickListener(v -> mPresenter.finish());
        ImageView img_menu = mTopBar.findViewById(R.id.img_menu);
        img_menu.setOnClickListener(v -> {
            List<String> list = new ArrayList<>();
            list.add(context.getString(R.string.report));
//            list.add("拉黑");
            BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                        if (index == 0) {
                            reportDialog();
                        }
                    }, true,
                    context.getString(R.string.cancel)
            ).setTitle(context.getString(R.string.please_choose));
        });

    }
    private void reportDialog() {
//        InputDialog.show(context, context.getString(R.string.report),
//                context.getString(R.string.report_reason),
//                context.getString(R.string.submit), (dialog, inputText) -> {
//                    mPresenter.report(inputText);
//                    dialog.dismiss();
//                }, context.getString(R.string.cancel), (dialog, which) -> {
//                    mPresenter.toast(context.getString(R.string.cancel));
//                });
    }


    private void blockDialog() {
//        SelectDialog.show(context, context.getString(R.string.warm),
//                context.getString(R.string.block_this_user),
//                context.getString(R.string.ok), (dialog, which) -> mPresenter.block(),
//                context.getString(R.string.cancel), (dialog, which) -> {
//                });
    }

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
        storeInfoFragment = new StoreInfoFragment();
        mFragmentList.add(storeInfoFragment);
        mAdapter = new DFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadStoreInfo();
        mPresenter.loadMatchUnitList();
    }

    @Override
    public void showStoreInfo(@NonNull Store store) {
//        storeInfoFragment.setStore(store);
//        storeFrontPanel.setStore(store);
    }


    @Override
    public void showMatchUnitList(@NonNull List<MatchUnit> matchUnitList) {

        mFragmentList.clear();
        mFragmentList.add(storeInfoFragment);
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < matchUnitList.size(); i++) {
            MatchUnit matchUnit = matchUnitList.get(i);

            String userId = matchUnit.getUser().getId();

            if (i < userInfoFragmentList.size()) {
                UserInfoFragment userInfoFragment = userInfoFragmentList.get(i);
                userInfoFragment.changeData(userId);
            } else {
                UserInfoFragment userInfoFragment = UserInfoFragment.newInstance(userId);
                userInfoFragmentList.add(userInfoFragment);
            }


            User user = matchUnit.getUser();
            userList.add(user);
        }
//        mPresenter.toast("HHH" + matchUnitList.size());

        mFragmentList.addAll(userInfoFragmentList.subList(0, matchUnitList.size()));
        mAdapter.setFragmentList(mFragmentList);

        setUserList(userList);
    }



    public void setCurrentItem(int i) {
        mViewPager.setCurrentItem(i, false);
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }


    public void setUserList(@NonNull List<User> userList) {
        final List<User> mData = new ArrayList<>();
        mData.add(new User());
        mData.addAll(userList);
        tab_select.clearOnTabSelectedListeners();
        tab_select.removeAllTabs();
        tab_select.setupWithViewPager(((StoreActivity) activity).getViewPager());
        TabLayoutUtil.setStyle(tab_select, new TabLayoutUtil.TabLayoutStyle() {
            List<ImageView> imageAvatars = new ArrayList<>();
            List<ImageView> imageBorders = new ArrayList<>();

            @Override
            public void setCustomView(TabLayout.Tab tab) {
                if (tab == null) return;
                View customView = tab.setCustomView(R.layout.layout_store_info_front_item).getCustomView();
                if (customView == null) return;
                ImageView img_avatar = customView.findViewById(R.id.img_user_avatar);
                ImageView img_border = customView.findViewById(R.id.img_user_border);
                User user = mData.get(tab.getPosition());
                if (user.getAvatar() != null) {
                    G.img(context, user.getAvatar().getUrl(), img_avatar);
                } else {
                    G.img(context, R.mipmap.ic_invite_friend_shop, img_avatar);
                }
                imageAvatars.add(img_avatar);
                imageBorders.add(img_border);

            }

            @Override
            public void setTabSelected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                imageBorders.get(p).setVisibility(View.VISIBLE);
                selected(p);
            }

            @Override
            public void setTabUnselected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                imageBorders.get(p).setVisibility(View.GONE);
            }

            @Override
            public void setTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    private void selected(int p) {
//        if (p == 0) {
//            tv_store_fresh.setVisibility(View.VISIBLE);
//        } else {
//            tv_store_fresh.setVisibility(View.INVISIBLE);
//        }
    }


    private boolean isHide1 = false;

    @NonNull
    private View getBottomView() {
        return fl_bottom;
    }

    public void whenUp() {
        if (isHide1) return;
        setAnimator(0, DensityUtil.dp2px(context, -getBottomView().getHeight()));// 隐藏。
        isHide1 = true;
    }

    public void whenDown() {
        if (!isHide1) return;
        setAnimator(DensityUtil.dp2px(context, -getBottomView().getHeight()), 0);// 出现。
        isHide1 = false;
    }

    public void whenClick() {
        if (isHide1) {
            setAnimator(DensityUtil.dp2px(context, -getBottomView().getHeight()), 0);// 出现。
        } else {
            setAnimator(0, DensityUtil.dp2px(context, -getBottomView().getHeight()));// 隐藏。
        }
        isHide1 = !isHide1;
    }


    private ValueAnimator anim;

    private void setAnimator(int a, int z) {
        if (anim != null) {
            anim.cancel();
        }
        final FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getBottomView().getLayoutParams();
        int h = params.bottomMargin;
        long duration = (long) (300f * (z - h) / (z - a));
        anim = ValueAnimator.ofInt(h, z);
        anim.setDuration(duration);
        anim.addUpdateListener(animation -> {
            params.bottomMargin = (int) (Integer) animation.getAnimatedValue();
            getBottomView().requestLayout();
        });
        anim.start();
    }


}

