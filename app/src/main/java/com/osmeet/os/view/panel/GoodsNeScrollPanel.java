package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.other.GlideBannerImageLoader;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.view.widget.listener.AlphaNeScrollListener;
import com.osmeet.os.view.panel.simple.BannerPanel;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.GoodsContract;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2019/01/15. email: 2209011667@qq.com
 */

public class GoodsNeScrollPanel extends BaseNeScrollPanel<GoodsContract.IPresenter> {
    public GoodsNeScrollPanel(Context context, GoodsContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_goods_content;
    }

    @Override
    protected void update() {
        mPresenter.loadGoodsInfo();
    }


    private BannerPanel imageBannerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(imageBannerPanel = new BannerPanel(context) {

            @Override
            protected void setBanner(Banner banner) {
                super.setBanner(banner);
                //设置banner样式
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置指示器位置（当banner模式中有指示器时）
                banner.setIndicatorGravity(BannerConfig.CENTER);
            }

            @SuppressWarnings("unchecked")
            @Override
            public void setBannerData(@NonNull final List<?> list) {
                List<String> urlList = new ArrayList<>((Collection<? extends String>) list);
                mBanner.update(urlList);
            }

            @NonNull
            @Override
            protected ImageLoader getImageLoader() {
                return new GlideBannerImageLoader();
            }
        });
    }

    @BindView(R.id.fl_panel)
    FrameLayout fl_panel;

    @Override
    protected void initView() {
        super.initView();
        fl_panel.addView(getPanelView(0));
    }

    @Override
    protected void initListener() {
        super.initListener();
        mNestedScrollView.setOnScrollChangeListener(
                new AlphaNeScrollListener(context, this::barAlpha));
    }

    private void barAlpha(float alpha) {
        View bar = getBindView("v");
        if (bar != null) {
            bar.setAlpha(alpha);
        }
    }

    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.tv_store_name)
    TextView tv_store_name;
    @BindView(R.id.img_store_logo)
    ImageView img_store_logo;

    public void setGoods(@NonNull Goods goods) {
        if (goods.getImages() != null) {
            List<String> urlList = new ArrayList<>();
            for (FileInfo info : goods.getImages()) {
                urlList.add(info.getUrl());
            }
            imageBannerPanel.setBannerData(urlList);
        }

        WidgetUtil.setTextNonNull(tv_goods_name, goods.getName());
        Store store = goods.getStore();
        if (store != null) {
            WidgetUtil.setTextNonNull(tv_store_name, store.getName());
            if (store.getLogoImage() != null)
                G.img(context, store.getLogoImage().getUrl(), img_store_logo);
        }
    }


}
