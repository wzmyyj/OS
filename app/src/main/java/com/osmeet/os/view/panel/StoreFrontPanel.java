package com.osmeet.os.view.panel;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.StoreContract;
import com.osmeet.os.view.activity.StoreActivity;
import com.osmeet.os.view.fragment.UserInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.TabLayoutUtil;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StoreFrontPanel extends BasePanel<StoreContract.IPresenter> {
    public StoreFrontPanel(Context context, StoreContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_store_info_front;
    }


    @BindView(R.id.img_store_avatar)
    ImageView img_store_avatar;

    @BindView(R.id.tab_bottom)
    TabLayout tab_bottom;

    @BindView(R.id.ll_bottom)
    LinearLayout ll_bottom;// 底部。


    @OnClick(R.id.img_store_avatar)
    void store() {
        StoreActivity storeActivity = getActivity();
        storeActivity.setCurrentItem(0);
        mPresenter.loadMatchUnitList();

    }

    @BindView(R.id.tv_store_fresh)
    TextView tv_store_fresh;


    @SuppressLint("SetTextI18n")
    public void setStore(@NonNull Store store) {
        G.img(context, store.getLogoImage().getUrl(), img_store_avatar);
    }

    public void setUserList(@NonNull List<User> userList) {
        final List<User> mData = new ArrayList<>();
        mData.add(new User());
        mData.addAll(userList);
        tab_bottom.clearOnTabSelectedListeners();
        tab_bottom.setupWithViewPager(((StoreActivity) activity).getViewPager());
        TabLayoutUtil.setStyle(tab_bottom, new TabLayoutUtil.TabLayoutStyle() {
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
                int p = tab.getPosition();
                StoreActivity storeActivity = getActivity();
                if (p == 0) {
                    mPresenter.inviteFriends();
                } else {
                    UserInfoFragment userInfoFragment = storeActivity.getFragment(p);
                    userInfoFragment.getPresenter().matchInvite();
                }
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

    public void whenUp() {
        if (isHide1) return;
        setAnimator(0, DensityUtil.dp2px(context, -85));// 隐藏。
        isHide1 = true;
    }

    public void whenDown() {
        if (!isHide1) return;
        setAnimator(DensityUtil.dp2px(context, -85), 0);// 出现。
        isHide1 = false;
    }

    public void whenClick() {
        if (isHide1) {
            setAnimator(DensityUtil.dp2px(context, -85), 0);// 出现。
        } else {
            setAnimator(0, DensityUtil.dp2px(context, -85));// 隐藏。
        }
        isHide1 = !isHide1;
    }


    private ValueAnimator anim;

    private void setAnimator(int a, int z) {
        if (anim != null) {
            anim.cancel();
        }
        final FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ll_bottom.getLayoutParams();
        int h = params.bottomMargin;
        long duration = (long) (300f * (z - h) / (z - a));
        anim = ValueAnimator.ofInt(h, z);
        anim.setDuration(duration);
        anim.addUpdateListener(animation -> {
            params.bottomMargin = (int) (Integer) animation.getAnimatedValue();
            ll_bottom.requestLayout();
        });
        anim.start();
    }


}
