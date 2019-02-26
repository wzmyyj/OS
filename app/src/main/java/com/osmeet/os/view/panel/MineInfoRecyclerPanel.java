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

import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.other.IvdVhHelper;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.MineContract;
import com.osmeet.os.view.adapter.ivd.StoryIVD;
import com.osmeet.os.view.adapter.ivd.UserInfoIVD;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.widget.listener.AlphaReScrollListener;
import com.previewlibrary.enitity.ThumbViewInfo;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.MockUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class MineInfoRecyclerPanel extends BaseRecyclerPanel<Story, MineContract.IPresenter> {
    public MineInfoRecyclerPanel(Context context, MineContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }


    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
    }

    @Override
    public void update() {
        mPresenter.freshMyInfo();
        mPresenter.loadMyStoreList();
    }


    @Override
    protected void initView() {
        super.initView();
        // 消除mRecyclerView刷新的动画。
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
//        setTopBar();
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

    public void setUser(@NonNull User user) {
        // header
        ivdVhHelper.convert(user);

        WidgetUtil.setTextNumber(tv_user_score, user.getCreditScore());

        List<FileInfo> images = user.getImages();
        if (images != null && images.size() > 0) {
            G.img(context, images.get(0).getUrl(), img_image);
            setTVIs(images);
        } else {
            if (user.getAvatar() != null)
                G.img(context, user.getAvatar().getUrl(), img_image);
        }


//        mData.clear();
//        for (int i = 0; i < 100; i++) {
//            mData.add(new PhotoStory());
//        }
//
//        notifyDataSetChanged();
    }

    private TextView tv_user_score;
    private ImageView img_image;

    private IvdVhHelper<User> ivdVhHelper;

    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_mine_info_header, null);

        ivdVhHelper = new IvdVhHelper<User>(context,
                new UserInfoIVD(context),
                mHeader.findViewById(R.id.ll_user_info));

        tv_user_score = mHeader.findViewById(R.id.tv_user_score);

        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();
        img_image.setOnClickListener(v -> {
            mPresenter.goImageLook(mThumbViewInfoList);
        });

        TextView tv_update = mHeader.findViewById(R.id.tv_update);
        tv_update.setOnClickListener(v -> mPresenter.goUpdateInfo());

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
