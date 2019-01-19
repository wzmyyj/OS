package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.view.panel.bean.PhotoStory;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.activity.PanelActivity;
import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StoreInfoRecyclerPanel extends BaseRecyclerPanel<PhotoStory, StoreInfoContract.IPresenter> {
    public StoreInfoRecyclerPanel(Context context, StoreInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<PhotoStory>> ivd) {
        ivd.add(new SingleIVD<PhotoStory>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_photo_item;
            }

            @Override
            public void convert(ViewHolder holder, PhotoStory photo, int position) {

            }
        });
    }


    @Override
    public void update() {
        mPresenter.loadStoreInfo();
        mPresenter.loadGoodsList();
    }

    @Override
    protected void initView() {
        super.initView();
        // 消除mRecyclerView刷新的动画。
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //当距离在[0,maxDistance]变化时，透明度在[0,255之间变化]
            int maxDistance = DensityUtil.dp2px(context, 150);
            int mDistance = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mDistance += dy;
                float percent = mDistance * 1f / maxDistance;//百分比
                View bar = getBindView("v");
                if (bar != null)
                    bar.setAlpha(percent);
                onScrolled1(dy);
            }
        });
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        onWholeClick();
    }

    public void setStore(@NonNull Store store) {
        // header

        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_store_avatar);
        WidgetUtil.setTextNonNull(tv_store_name, store.getName());
        WidgetUtil.setTextNumber(tv_store_os_num, store.getMatchUnitCount());
        WidgetUtil.setTextNonNull(tv_store_introduce, store.getIntroduce());
        WidgetUtil.setTextNonNull(tv_store_distance, "127km");

        List<FileInfo> images = store.getImages();
        if (images != null && images.size() > 0) {
            G.img(context, images.get(0).getUrl(), img_image);
        }


        // data
        for (int i = 0; i < 100; i++) {
            mData.add(new PhotoStory());
        }

        notifyDataSetChanged();
    }


    public void setGoodsList(@NonNull List<Goods> goodsList) {
        mGoodsList.clear();
        mGoodsList.addAll(goodsList);
        mAdapter.notifyDataSetChanged();

        if (goodsList.size() > 0) {
            tv_no_goods.setVisibility(View.GONE);
        } else {
            tv_no_goods.setVisibility(View.VISIBLE);
        }
    }


    private ImageView img_store_avatar;
    private TextView tv_store_name;
    private TextView tv_store_distance;
    private TextView tv_store_os_num;
    private TextView tv_store_introduce;
    private ImageView img_image;

    private List<Goods> mGoodsList;
    private CommonAdapter mAdapter;
    private TextView tv_no_goods;

    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_store_info_header, null);
        img_store_avatar = mHeader.findViewById(R.id.img_store_avatar);
        tv_store_name = mHeader.findViewById(R.id.tv_store_name);
        tv_store_distance = mHeader.findViewById(R.id.tv_store_distance);
        tv_store_os_num = mHeader.findViewById(R.id.tv_store_os_num);
        tv_store_introduce = mHeader.findViewById(R.id.tv_store_introduce);

        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();

        mHeader.setOnClickListener(v -> onWholeClick());

        ImageView img_b_1 = mHeader.findViewById(R.id.img_b_1);
        ImageView img_b_2 = mHeader.findViewById(R.id.img_b_2);
        ImageView img_b_3 = mHeader.findViewById(R.id.img_b_3);
        ImageView img_b_4 = mHeader.findViewById(R.id.img_b_4);
        img_b_1.setOnClickListener(v -> {

        });
        img_b_2.setOnClickListener(v -> {

        });
        img_b_3.setOnClickListener(v -> {

        });
        img_b_4.setOnClickListener(v -> {

        });


        // 商品。
        tv_no_goods = mHeader.findViewById(R.id.tv_no_goods);
        RecyclerView rv_goods = mHeader.findViewById(R.id.rv_goods);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv_goods.setRecycledViewPool(viewPool);
        rv_goods.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        mGoodsList = new ArrayList<>();
        rv_goods.setAdapter(mAdapter = new CommonAdapter<Goods>(context, R.layout.layout_store_goods_item, mGoodsList) {

            @Override
            protected void convert(ViewHolder holder, Goods goods, int position) {
                TextView tv_goods_name = holder.getView(R.id.tv_goods_name);
                TextView tv_goods_price = holder.getView(R.id.tv_goods_price);
                TextView tv_goods_price_old = holder.getView(R.id.tv_goods_price_old);
                ImageView img_goods = holder.getView(R.id.img_goods);
                tv_goods_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                WidgetUtil.setTextNonNull(tv_goods_name, goods.getName());
                WidgetUtil.setTextPrice(tv_goods_price, "￥", goods.getDiscountPrice());
                WidgetUtil.setTextPrice(tv_goods_price_old, "￥", goods.getOriginalPrice());
                if (goods.getImages() != null && goods.getImages().size() > 0) {
                    G.img(context, goods.getImages().get(0).getUrl(), img_goods);
                }
            }
        });
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                String goodsId = mGoodsList.get(position).getId();
                if (!TextUtils.isEmpty(goodsId)) {
                    mPresenter.goGoods(goodsId);
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });


    }


    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
        mFooter.setOnClickListener(v -> onWholeClick());
    }

    // 控制外部的控件。
    private void onWholeClick() {
        StoreFrontPanel storeInfoFrontPanel = ((PanelActivity) activity).getPanel(0);
        if (storeInfoFrontPanel != null)
            storeInfoFrontPanel.whenClick();
    }

    // 控制外部的控件。
    private void onScrolled1(int dy) {
        StoreFrontPanel storeInfoFrontPanel = ((PanelActivity) activity).getPanel(0);
        if (storeInfoFrontPanel != null)
            if (dy > 10) {
                storeInfoFrontPanel.whenUp();
            } else if (dy < -10) {
                storeInfoFrontPanel.whenDown();
            }
    }

}
