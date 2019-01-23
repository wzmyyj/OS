package com.osmeet.os.view.adapter.ivd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.adapter.BaseIVD;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import top.wzmyyj.wzm_sdk.utils.WidgetUtil;


/**
 * Created by yyj on 2019/01/22.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class UserIVD extends BaseIVD<User> {
    public UserIVD(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_user_info;
    }

    @Override
    public void convert(ViewHolder holder, User user, int position) {
        ImageView img_user_avatar = holder.getView(R.id.img_user_avatar);
        TextView tv_user_name = holder.getView(R.id.tv_user_name);
        TextView tv_user_age = holder.getView(R.id.tv_user_age);
        TextView tv_user_company = holder.getView(R.id.tv_user_company);
        TextView tv_user_job = holder.getView(R.id.tv_user_job);
        TextView tv_user_school = holder.getView(R.id.tv_user_school);
        TextView tv_user_signature = holder.getView(R.id.tv_user_signature);

        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_user_avatar);
        WidgetUtil.setTextNonNull(tv_user_name, user.getUsername());
        WidgetUtil.setTextNumber(tv_user_age, user.getAge());
        WidgetUtil.setTextOrGone(tv_user_company, user.getCompany());
        WidgetUtil.setTextOrGone(tv_user_job, user.getJob());
        WidgetUtil.setTextOrGone(tv_user_school, user.getSchool());
        WidgetUtil.setTextNonNull(tv_user_signature, user.getSignature());

    }
}
