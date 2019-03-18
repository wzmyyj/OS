package com.osmeet.os.view.panel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.app.tools.SDT;
import com.osmeet.os.base.panel.BaseNeScrollPanel;
import com.osmeet.os.contract.UpdateInfoContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.activity.InitActivity;
import top.wzmyyj.wzm_sdk.utils.InputSoftUtil;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/26. email: 2209011667@qq.com
 */

public class UpdateInfoNeScrollPanel extends BaseNeScrollPanel<UpdateInfoContract.IPresenter> {
    public UpdateInfoNeScrollPanel(Context context, UpdateInfoContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_update_info;
    }

    @Override
    protected void update() {

    }


    @BindView(R.id.img_avatar)
    ImageView img_avatar;

    @BindView(R.id.tv_user_score)
    TextView tv_user_score;
    @BindView(R.id.et_signature)
    EditText et_signature;
    @BindView(R.id.tv_signature_num)
    TextView tv_signature_num;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_birthday)
    EditText et_birthday;
    @BindView(R.id.et_school)
    EditText et_school;
    @BindView(R.id.et_company)
    EditText et_company;
    @BindView(R.id.et_job)
    EditText et_job;

    @OnClick(R.id.et_birthday)
    void birthday() {
        img_avatar.requestFocus();
        String time = et_birthday.getText().toString();
        SDT.create().Listener(new SDT.Listener() {
            @Override
            public void onPositiveButtonClick(Date date) {
                et_birthday.setText(TimeUtil.long2str(date.getTime(), "yyyy-MM-dd"));

            }

            @Override
            public void onNegativeButtonClick(Date date) {

            }
        })
                .setDefaultYear(TimeUtil.getYear() - 17)
                .setDefaultDateTime(TimeUtil.str2long(time, TimeUtil.YYYY_MM_DD), !TextUtils.isEmpty(time))
                .show(((InitActivity) activity).getSupportFragmentManager(), "dialog_time");

        InputSoftUtil.close(activity);

    }

    private String avatarPath;

    @OnClick(R.id.img_avatar)
    void avatar() {
        GP.create(new GP.CallBack() {
            @Override
            public void onSuccess(List<String> photoList) {
                avatarPath = photoList.get(0);
                G.img(context, photoList.get(0), img_avatar);
            }
        }).openWithPermission(activity);
    }

    @OnClick(R.id.bt_validate)
    void validate() {
        mPresenter.toast(context.getString(R.string.validate_your_account));
    }

    private List<ImageView> imageViewList = new ArrayList<>();

    @Override
    protected boolean isEnablePureScrollMode() {
        return true;
    }

    @Override
    protected void initView() {
        super.initView();
        et_signature.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        et_signature.setHorizontallyScrolling(false);
        et_signature.setSingleLine(false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_signature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = et_signature.getText().toString().length();
                if (length > 50) {
                    et_signature.setText(et_signature.getText().toString().substring(0, 49));
                    WidgetUtil.setEditSelectionLast(et_signature);
                } else {
                    WidgetUtil.setTextNumber(tv_signature_num, 50 - length);
                }
            }
        });


    }

    public void save() {
        int length = et_username.getText().toString().length();
        int length2 = et_birthday.getText().toString().length();
        if (length < 1 || length > 10) {
            mPresenter.toast(context.getString(R.string.name_length_1_10_char));
        } else if (length2 < 8) {
            mPresenter.toast(context.getString(R.string.pop_birthday));
        } else {
            updateInfo();
        }
    }

    private void updateInfo() {
        User user = new User();
        user.setSex(myUser.getSex());
        user.setUsername(myUser.getUsername());
        user.setBirthday(myUser.getBirthday());
        user.setSchool(myUser.getSchool());
        user.setCompany(myUser.getCompany());
        user.setJob(myUser.getJob());
        user.setSignature(myUser.getSignature());

        if (!TextUtils.isEmpty(et_signature.getText().toString())) {
            user.setSignature(et_signature.getText().toString());
        }
        if (!TextUtils.isEmpty(et_username.getText().toString())) {
            user.setUsername(et_username.getText().toString());
        }
        if (!TextUtils.isEmpty(et_birthday.getText().toString())) {
            user.setBirthday(et_birthday.getText().toString().replace("-", ""));
        }
        if (!TextUtils.isEmpty(et_school.getText().toString())) {
            user.setSchool(et_school.getText().toString());
        }
        if (!TextUtils.isEmpty(et_company.getText().toString())) {
            user.setCompany(et_company.getText().toString());
        }
        if (!TextUtils.isEmpty(et_job.getText().toString())) {
            user.setJob(et_job.getText().toString());
        }
        mPresenter.updateMyInfo(user);

        if (!TextUtils.isEmpty(avatarPath)) {
            mPresenter.updateMyAvatar(avatarPath);
        }
    }


    private User myUser;

    public void setUser(@NonNull User user) {
        this.myUser = user;
        if (user.getAvatar() != null) {
            G.img(context, user.getAvatar().getUrl(), img_avatar);
        }
        WidgetUtil.setTextNumber(tv_user_score, user.getCreditScore());
        WidgetUtil.setTextNonNull(et_signature, user.getSignature());
        WidgetUtil.setTextNonNull(et_username, user.getUsername());
        WidgetUtil.setTextNonNull(et_birthday, user.getBirthdayFormat(TimeUtil.YYYY_MM_DD));
        WidgetUtil.setTextNonNull(et_school, user.getSchool());
        WidgetUtil.setTextNonNull(et_company, user.getCompany());
        WidgetUtil.setTextNonNull(et_job, user.getJob());

    }

}
