package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseBannerPanel;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.GoodsContract;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;

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
        mPresenter.loadGoods();
    }


    private BaseBannerPanel imageBannerPanel;

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(imageBannerPanel = new BaseBannerPanel<GoodsContract.IPresenter>(context, mPresenter) {

            @Override
            protected void setBanner(Banner banner) {
                super.setBanner(banner);
                //设置banner样式
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置指示器位置（当banner模式中有指示器时）
                banner.setIndicatorGravity(BannerConfig.CENTER);
            }

            @Override
            public void setBannerData(@NonNull final List<?> list) {
                @SuppressWarnings("unchecked")
                List<String> urlList = new ArrayList<>((Collection<? extends String>) list);
                mBanner.update(urlList);
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
        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            //当距离在[0,maxDistance]变化时，透明度在[0,255之间变化]
            int maxDistance = DensityUtil.dp2px(context, 150);
            int mDistance = 0;

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                mDistance = scrollY;
                float percent = mDistance * 1f / maxDistance;//百分比
                View bar = getBindView("v");
                if (bar != null)
                    bar.setAlpha(percent);
            }
        });
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
