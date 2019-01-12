package com.osmeet.os.view.activity;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.activity.BaseMainActivity;
import com.osmeet.os.contract.MainContract;
import com.osmeet.os.presenter.MainPresenter;
import com.osmeet.os.view.fragment.HomeFragment;
import com.osmeet.os.view.fragment.MessageFragment;
import com.osmeet.os.view.fragment.MineFragment;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.TabLayoutUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 主页面。
 */

public class MainActivity extends BaseMainActivity<MainContract.IPresenter> implements MainContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter(activity, this);
    }

    @Override
    protected void initFTs(List<FT> fts) {
        fts.add(new FT(new MessageFragment(), "消息", R.mipmap.ic_message, R.mipmap.ic_message_selected));
        fts.add(new FT(new HomeFragment(), "主页", R.mipmap.ic_home, R.mipmap.ic_home_selected));
        fts.add(new FT(new MineFragment(), "我的", R.color.colorClarity, R.mipmap.ic_mine_selected));
    }

    @Override
    protected void initView() {
        super.initView();
        mViewPager.setSlide(false);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMyInfo();
    }

    @Override
    protected int initTabHeight() {
        return DensityUtil.dp2px(context, 50);
    }

    @Override
    protected int firstWhich() {
        return 1;// 一开始显示中间那页。
    }

    @Override
    protected void initTabStyle() {
        super.initTabStyle();
        setTabLayoutStyle(new TabLayoutUtil.TabLayoutStyle() {
            final List<ImageView> imageViewList = new ArrayList<>();

            @Override
            public void setCustomView(TabLayout.Tab tab) {
                View customView = tab.setCustomView(R.layout.layout_main_tab).getCustomView();
                if (customView == null) return;
                ImageView img_tab = customView.findViewById(R.id.img_tab);
                imageViewList.add(img_tab);
                if (tab.getPosition() == 2) {
                    img_avatar = customView.findViewById(R.id.img_avatar);
                    img_avatar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void setTabSelected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                imageViewList.get(p).setImageResource(mFTs.get(p).icon_selected);
            }

            @Override
            public void setTabUnselected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                imageViewList.get(p).setImageResource(mFTs.get(p).icon_unselected);
            }

            @Override
            public void setTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private ImageView img_avatar;


    @Override
    public void showMyInfo(@NotNull User user) {
        G.img(context, user.getAvatar().getUrl(), img_avatar);
    }
}

