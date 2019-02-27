package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.other.IvdVhHelper;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.UserInfoContract;
import com.osmeet.os.view.activity.StoreActivity;
import com.osmeet.os.view.adapter.ivd.StoryIVD;
import com.osmeet.os.view.adapter.ivd.UserInfoIVD;

import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.utils.MockUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class UserInfoRecyclerPanel extends BaseRecyclerPanel<Story, UserInfoContract.IPresenter> {
    public UserInfoRecyclerPanel(Context context, UserInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }


    @Override
    protected void setIVD(List<IVD<Story>> ivd) {
        ivd.add(new StoryIVD(context));
    }

    @Override
    public void update() {
        mPresenter.loadUserInfo();
        mPresenter.loadStoryList(0);
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        mPresenter.loadStoryList(nextPageNum());
    }

    @Override
    protected void initView() {
        super.initView();
        // 消除mRecyclerView刷新的动画。
        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }


    @Override
    protected void initListener() {
        super.initListener();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                onScrolled1(dy);
            }
        });
    }


//    @Override
//    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//        super.onItemClick(view, holder, position);
//
//    }


    public void setUser(@NonNull User user) {
        // header
        ivdVhHelper.convert(user);

        WidgetUtil.setTextNumber(tv_user_score, user.getCreditScore());

//        List<FileInfo> images = user.getImages();
//        if (images != null && images.size() > 0) {
//            G.img(context, images.get(0).getUrl(), img_image);
//            setTVIs(images);
//        } else {
//            if (user.getAvatar() != null)
//                G.img(context, user.getAvatar().getUrl(), img_image);
//        }
        // data
//        mData.clear();
//        for (int i = 0; i < 100; i++) {
//            mData.add(new PhotoStory());
//        }
//
//        notifyDataSetChanged();
    }


    private TextView tv_user_score;
    private ImageView img_b_1;
    private ImageView img_image;

    private IvdVhHelper<User> ivdVhHelper;

    @SuppressLint("InflateParams")
    @Override
    protected void setHeader() {
        super.setHeader();
        mHeader = mInflater.inflate(R.layout.layout_user_info_header, null);

        ivdVhHelper = new IvdVhHelper<User>(context,
                new UserInfoIVD(context),
                mHeader.findViewById(R.id.ll_user_info));

        tv_user_score = mHeader.findViewById(R.id.tv_user_score);

        img_image = mHeader.findViewById(R.id.img_image);
        img_image.getLayoutParams().height = MockUtil.getScreenWidth(context);
        img_image.requestLayout();
        img_image.setOnClickListener(v -> {

        });


//        mHeader.setOnClickListener(v -> onWholeClick());

        img_b_1 = mHeader.findViewById(R.id.img_b_1);
//        img_b_1.setOnClickListener(v -> mPresenter.matchInvite());/
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }


    // 控制外部的控件。
    private void onScrolled1(int dy) {
        StoreActivity storeActivity = getActivity();
        if (storeActivity != null)
            if (dy > 10) {
                storeActivity.whenUp();
            } else if (dy < -10) {
                storeActivity.whenDown();
            }
    }


}
