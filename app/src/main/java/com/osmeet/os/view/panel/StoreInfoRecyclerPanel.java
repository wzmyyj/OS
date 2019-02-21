package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.view.adapter.GoodsAdapter;
import com.osmeet.os.view.adapter.ivd.PhotoStoryIVD;
import com.osmeet.os.view.panel.bean.PhotoStory;
import com.osmeet.os.view.widget.listener.AlphaReScrollListener;
import com.previewlibrary.enitity.ThumbViewInfo;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.activity.PanelActivity;
import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.MockUtil;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StoreInfoRecyclerPanel extends BaseRecyclerPanel<PhotoStory, StoreInfoContract.IPresenter> {
    public StoreInfoRecyclerPanel(Context context, StoreInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<PhotoStory>> ivd) {
        ivd.add(new PhotoStoryIVD(context));
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
        mRecyclerView.addOnScrollListener(new AlphaReScrollListener(context, this::barAlpha) {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                onScrolled1(dy);
            }
        });
    }

    private void barAlpha(float alpha) {
        View bar = getBindView("v");
        if (bar != null) {
            bar.setAlpha(alpha);
        }
    }

//    @Override
//    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//        super.onItemClick(view, holder, position);
//        onWholeClick();
//    }

    private Store store;

    public void setStore(@NonNull Store store) {
        // header

        this.store = store;

        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_store_avatar);
        WidgetUtil.setTextNonNull(tv_store_name, store.getName());
        WidgetUtil.setTextNumber(tv_store_os_num, store.getMatchUnitCount());
        WidgetUtil.setTextNonNull(tv_store_introduce, store.getIntroduce());
        WidgetUtil.setTextNonNull(tv_store_open_time,
                context.getString(R.string.open_time)
                        + ":" +
                        TimeUtil.long2str(store.getStartTime(), TimeUtil.HH_MM)
                        + "-" +
                        TimeUtil.long2str(store.getEndTime(), TimeUtil.HH_MM)
        );

        DPoint dPoint = new DPoint();
        dPoint.setLatitude(store.getLat());
        dPoint.setLongitude(store.getLng());
        float distance = CoordinateConverter.calculateLineDistance(App.getInstance().getMyDPoint(), dPoint) / 1000;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        WidgetUtil.setTextNonNull(tv_store_distance, decimalFormat.format(distance) + "km");

        List<FileInfo> images = store.getImages();
        if (images != null && images.size() > 0) {
            G.img(context, images.get(0).getUrl(), img_image);
            setTVIs(images);
        }


//        mPresenter.toast("ooo"+store.getMatchState());
        if (store.getMatchState() < 2) {
            img_eye.setVisibility(View.VISIBLE);
            tv_os_now.setVisibility(View.GONE);
        } else {
            img_eye.setVisibility(View.GONE);
            tv_os_now.setVisibility(View.VISIBLE);
        }

        // data
//        for (int i = 0; i < 100; i++) {
//            mData.add(new PhotoStory());
//        }
//
//        notifyDataSetChanged();
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
    private TextView tv_store_open_time;
    private TextView tv_store_introduce;
    private ImageView img_image;

    private List<Goods> mGoodsList;
    private MultiItemTypeAdapter mAdapter;
    private TextView tv_no_goods;
    private TextView tv_os_now;
    private ImageView img_eye;

    private boolean isInStore;

    public boolean isInStore() {
        return isInStore;
    }


    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_store_info_header, null);
        img_store_avatar = mHeader.findViewById(R.id.img_store_avatar);
        tv_store_name = mHeader.findViewById(R.id.tv_store_name);
        tv_store_distance = mHeader.findViewById(R.id.tv_store_distance);
        tv_store_os_num = mHeader.findViewById(R.id.tv_store_os_num);
        tv_store_open_time = mHeader.findViewById(R.id.tv_store_open_time);
        tv_store_introduce = mHeader.findViewById(R.id.tv_store_introduce);
        tv_os_now = mHeader.findViewById(R.id.tv_os_now);
        tv_os_now.setOnClickListener(v -> {

        });
        img_eye = mHeader.findViewById(R.id.img_eye);
        img_eye.setOnClickListener(v -> {
            if (isInStore) {
                mPresenter.outMatchStore();
            } else {
                mPresenter.intoMatchStore();
            }
        });
        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();
        img_image.setOnClickListener(v -> mPresenter.goImageLook(mThumbViewInfoList));

//        mHeader.setOnClickListener(v -> onWholeClick());

        mHeader.findViewById(R.id.img_m_1).setOnClickListener(v -> {
            if (store == null || store.getBoss() == null) return;
            mPresenter.goChat(store.getBoss().getId(), store.getName());
        });
        mHeader.findViewById(R.id.img_m_2).setOnClickListener(v -> {

        });
        mHeader.findViewById(R.id.img_m_3).setOnClickListener(v -> {
            if (store == null) return;
            mPresenter.goSingleMap(store.getLat(), store.getLng(), store.getName());
        });
        mHeader.findViewById(R.id.img_m_4).setOnClickListener(v -> {

        });


        // 商品。
        tv_no_goods = mHeader.findViewById(R.id.tv_no_goods);
        RecyclerView rv_goods = mHeader.findViewById(R.id.rv_goods);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv_goods.setRecycledViewPool(viewPool);
        rv_goods.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        mGoodsList = new ArrayList<>();
        rv_goods.setAdapter(mAdapter = new GoodsAdapter(context, mGoodsList));
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

    private ArrayList<ThumbViewInfo> mThumbViewInfoList = new ArrayList<>();

    private void setTVIs(List<FileInfo> resultList) {
        mThumbViewInfoList.clear();
        for (int i = 0; i < resultList.size(); i++) {
            Rect bounds = new Rect();
            //new ThumbViewInfo(图片地址);
            ThumbViewInfo item = new ThumbViewInfo(resultList.get(i).getUrl());
            item.setBounds(bounds);
            mThumbViewInfoList.add(item);
        }
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
//        mFooter.setOnClickListener(v -> onWholeClick());
    }

    // 控制外部的控件。
//    private void onWholeClick() {
//        StoreFrontPanel storeInfoFrontPanel = ((PanelActivity) activity).getPanel(0);
//        if (storeInfoFrontPanel != null)
//            storeInfoFrontPanel.whenClick();
//    }

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

    public void inMatchStore(boolean isInStore) {
        this.isInStore = isInStore;
//        mPresenter.toast("JJJ" + isInStore);
        if (isInStore) {
            img_eye.setImageResource(R.mipmap.ic_eye_open);
        } else {
            img_eye.setImageResource(R.mipmap.ic_eye_close);
        }
    }

}
