package com.osmeet.os.view.panel.simple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.dl7.tag.TagLayout;
import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.utils.DistanceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wzmyyj.wzm_sdk.panel.InitPanel;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/02/27.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class UserInfoPanel extends InitPanel {
    /**
     * @param context .
     */
    public UserInfoPanel(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setRootView() {
        view = mInflater.inflate(R.layout.layout_user_info_simple, null);
        ButterKnife.bind(this, view);
    }

    @BindView(R.id.tv_user_name)
    TextView tv_user_name;
    @BindView(R.id.tl_tag)
    TagLayout tl_tag;
    @BindView(R.id.tv_user_distance)
    TextView tv_user_distance;
    @BindView(R.id.tv_user_signature)
    TextView tv_user_signature;
    @BindView(R.id.tv_user_score)
    TextView tv_user_score;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    public void setUser(@NonNull User user) {
        WidgetUtil.setTextNonNull(tv_user_name, user.getUsername());
        WidgetUtil.setTextNumber(tv_user_score, user.getCreditScore());
        WidgetUtil.setTextNonNull(tv_user_distance, DistanceUtil.distance(user.getLat(), user.getLng()));

        if (!TextUtils.isEmpty(user.getSignature())) {
            WidgetUtil.setTextNonNull(tv_user_signature, user.getSignature());
        } else {
            WidgetUtil.setTextRes(tv_user_signature, R.string.no_signature);
        }

        String sex;
        if (user.getSex() == User.SEX_MALE) {
            sex = context.getString(R.string.male);
        } else if (user.getSex() == User.SEX_FEMALE) {
            sex = context.getString(R.string.female);
        } else {
            sex = context.getString(R.string.female);
        }

        tl_tag.cleanTags();
        tl_tag.addTag("" + user.getAge());
        tl_tag.addTag("" + sex);
        if (!TextUtils.isEmpty(user.getJob())) {
            tl_tag.addTag(user.getJob());
        }
        if (!TextUtils.isEmpty(user.getCompany())) {
            tl_tag.addTag(user.getCompany());
        }
        if (!TextUtils.isEmpty(user.getSchool())) {
            tl_tag.addTag(user.getSchool());
        }
    }
}
