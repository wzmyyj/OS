package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.view.panel.bean.Photo;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class MineStoreRecyclerPanel extends BaseRecyclerPanel<Photo, MineContract.IPresenter> {
    public MineStoreRecyclerPanel(Context context, MineContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }


    @Override
    protected void setIVD(List<IVD<Photo>> ivd) {
        ivd.add(new SingleIVD<Photo>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_photo_item;
            }

            @Override
            public void convert(ViewHolder holder, Photo story, int position) {

            }
        });
    }

    @Override
    public void update() {

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
            int maxDistance = DensityUtil.dp2px(context, 200);
            int mDistance = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mDistance += dy;
                float percent = mDistance * 1f / maxDistance;//百分比
                View bar = mViewMap.get("v");
                if (bar != null)
                    bar.setAlpha(percent);
            }
        });
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);

    }

    @SuppressLint("SetTextI18n")
    public void setStore(@NonNull Store store) {
        // header

        if (store.getLogoImage() != null)
            G.img(context, store.getLogoImage().getUrl(), img_store_avatar);
        tv_store_name.setText("" + store.getName());
        tv_store_os_num.setText("" + store.getMatchCount());
        tv_store_introduce.setText("" + store.getIntroduce());
        tv_store_distance.setText("127km");

        if (store.getGoods() != null && store.getGoods().size() > 0) {
            Goods goods = store.getGoods().get(0);
            tv_goods_name.setText("" + goods.getName());
            tv_goods_price.setText("￥" + goods.getDiscountPrice());
            tv_goods_price_old.setText("￥" + goods.getDiscountPrice());
        }

        List<FileInfo> images = store.getImages();
        if (images != null && images.size() > 0) {
            G.img(context, images.get(0).getUrl(), img_image);
        }

        // data
        mData.clear();
        for (int i = 0; i < 100; i++) {
            mData.add(new Photo());
        }

        notifyDataSetChanged();
    }


    private ImageView img_store_avatar;
    private TextView tv_store_name;
    private TextView tv_store_distance;
    private TextView tv_store_os_num;
    private TextView tv_store_introduce;
    private TextView tv_goods_name;
    private TextView tv_goods_price;
    private TextView tv_goods_price_old;
    private ImageView img_image;


    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_mine_store_header, null);
        img_store_avatar = mHeader.findViewById(R.id.img_store_avatar);
        tv_store_name = mHeader.findViewById(R.id.tv_store_name);
        tv_store_distance = mHeader.findViewById(R.id.tv_store_distance);
        tv_store_os_num = mHeader.findViewById(R.id.tv_store_os_num);
        tv_store_introduce = mHeader.findViewById(R.id.tv_store_introduce);
        tv_goods_name = mHeader.findViewById(R.id.tv_goods_name);
        tv_goods_price = mHeader.findViewById(R.id.tv_goods_price);
        tv_goods_price_old = mHeader.findViewById(R.id.tv_goods_price_old);
        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();
        tv_goods_price_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);


        TextView tv_update = mHeader.findViewById(R.id.tv_update);
        TextView tv_wallet = mHeader.findViewById(R.id.tv_wallet);
        tv_update.setVisibility(View.GONE);
        tv_update.setOnClickListener(v -> {

        });
        tv_wallet.setOnClickListener(v -> {

        });
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }


}
