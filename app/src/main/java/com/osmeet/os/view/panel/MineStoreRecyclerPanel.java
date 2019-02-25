package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.view.adapter.ivd.StoryIVD;
import com.osmeet.os.view.panel.bean.Story;
import com.osmeet.os.view.widget.listener.AlphaReScrollListener;
import com.previewlibrary.enitity.ThumbViewInfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.MockUtil;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class MineStoreRecyclerPanel extends BaseRecyclerPanel<Story, MineContract.IPresenter> {
    public MineStoreRecyclerPanel(Context context, MineContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }


    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
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
        mRecyclerView.addOnScrollListener(
                new AlphaReScrollListener(context, this::barAlpha));
    }

    private void barAlpha(float alpha) {
        View bar = getBindView("v");
        if (bar != null) {
            bar.setAlpha(alpha);
        }
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);

    }

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

        // data
//        mData.clear();
//        for (int i = 0; i < 100; i++) {
//            mData.add(new PhotoStory());
//        }
//
//        notifyDataSetChanged();
    }


    private ImageView img_store_avatar;
    private TextView tv_store_name;
    private TextView tv_store_distance;
    private TextView tv_store_os_num;
    private TextView tv_store_open_time;
    private TextView tv_store_introduce;
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
        tv_store_open_time = mHeader.findViewById(R.id.tv_store_open_time);
        tv_store_introduce = mHeader.findViewById(R.id.tv_store_introduce);
        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();
        img_image.setOnClickListener(v -> {
            mPresenter.goImageLook(mThumbViewInfoList);
        });

        TextView tv_update = mHeader.findViewById(R.id.tv_update);
        TextView tv_wallet = mHeader.findViewById(R.id.tv_wallet);
        tv_update.setVisibility(View.GONE);
        tv_update.setOnClickListener(v -> {

        });
        tv_wallet.setOnClickListener(v -> {
            if (store != null)
                mPresenter.goWallet(store.getId());
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
    }


}
