package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.view.panel.bean.PhotoStory;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import top.wzmyyj.wzm_sdk.activity.PanelActivity;
import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class UserInfoRecyclerPanel extends BaseRecyclerPanel<PhotoStory, UserInfoContract.IPresenter> {
    public UserInfoRecyclerPanel(Context context, UserInfoContract.IPresenter iPresenter) {
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
        mPresenter.loadUserInfo();
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
                View bar =getBindView("v");
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


    public void setUser(@NonNull User user) {
        // header
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_user_avatar);
        WidgetUtil.setTextNonNull(tv_user_name, user.getUsername());
        WidgetUtil.setTextNumber(tv_user_age, user.getAge());
        WidgetUtil.setTextOrGone(tv_user_company, user.getCompany());
        WidgetUtil.setTextOrGone(tv_user_job, user.getJob());
        WidgetUtil.setTextOrGone(tv_user_school, user.getSchool());
        WidgetUtil.setTextNonNull(tv_user_signature, user.getSignature());
        WidgetUtil.setTextNumber(tv_user_score, user.getCreditScore());

        List<FileInfo> images = user.getImages();
        if (images != null && images.size() > 0) {
            G.img(context, images.get(0).getUrl(), img_image);
        } else {
            if (user.getAvatar() != null)
                G.img(context, user.getAvatar().getUrl(), img_user_avatar);
        }
        // data
        mData.clear();
        for (int i = 0; i < 100; i++) {
            mData.add(new PhotoStory());
        }

        notifyDataSetChanged();
    }

    private ImageView img_user_avatar;
    private TextView tv_user_name;
    private TextView tv_user_age;
    private TextView tv_user_company;
    private TextView tv_user_school;
    private TextView tv_user_job;
    private TextView tv_user_signature;
    private TextView tv_user_score;
    private ImageView img_b_1;
    private ImageView img_image;


    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_user_info_header, null);
        img_user_avatar = mHeader.findViewById(R.id.img_user_avatar);
        tv_user_name = mHeader.findViewById(R.id.tv_user_name);
        tv_user_age = mHeader.findViewById(R.id.tv_user_age);
        tv_user_company = mHeader.findViewById(R.id.tv_user_company);
        tv_user_job = mHeader.findViewById(R.id.tv_user_job);
        tv_user_school = mHeader.findViewById(R.id.tv_user_school);
        tv_user_signature = mHeader.findViewById(R.id.tv_user_signature);
        tv_user_score = mHeader.findViewById(R.id.tv_user_score);
        img_b_1 = mHeader.findViewById(R.id.img_b_1);
        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();

        mHeader.setOnClickListener(v -> onWholeClick());

        img_b_1 = mHeader.findViewById(R.id.img_b_1);
        img_b_1.setOnClickListener(v -> mPresenter.matchInvite());
    }


    public void showMatchSuccess(boolean is) {
        if (is) {
            G.img(context, R.mipmap.ic_star_red, img_b_1);
        } else {
            G.img(context, R.mipmap.ic_star, img_b_1);
        }
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
