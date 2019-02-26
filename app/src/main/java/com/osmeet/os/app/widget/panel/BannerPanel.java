package com.osmeet.os.app.widget.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import top.wzmyyj.wzm_sdk.panel.InitPanel;

/**
 * Created by yyj on 2018/07/03.
 *
 * Banner Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public abstract class BannerPanel extends InitPanel {

    protected Banner mBanner;

    /**
     * @param context .
     */
    public BannerPanel(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setRootView() {
        view = mInflater.inflate(R.layout.panel_banner, null);
    }

    @Override
    protected void initView() {
        mBanner = view.findViewById(R.id.banner);

        List images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        setFirstData(images, titles);
        //设置图片加载器
        mBanner.setImageLoader(getImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(5000);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);

        // 自定义样式
        setBanner(mBanner);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    /**
     * @param banner .
     */
    protected void setBanner(Banner banner) {

    }

    /**
     * @param images list.
     * @param titles list.
     */
    protected void setFirstData(List images, List<String> titles) {

    }

    /**
     * @param list .
     */
    public abstract void setBannerData(@NonNull List<?> list);

    /**
     * @return ImageLoader.
     */
    @NonNull
    protected abstract ImageLoader getImageLoader();


    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


}
