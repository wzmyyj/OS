package com.osmeet.os.view.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.utils.AnimationUtil;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.app.tools.SDT;
import top.wzmyyj.wzm_sdk.utils.InputSoftUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.PopInfoContract;
import com.osmeet.os.presenter.PopInfoPresenter;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.TimeUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 完善用户信息页面。
 */

public class PopInfoActivity extends BaseActivity<PopInfoContract.IPresenter> implements PopInfoContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new PopInfoPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pop_info;
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.img_avatar)
    ImageView img_avatar;
    @BindView(R.id.img_sex_male)
    ImageView img_sex_male;
    @BindView(R.id.img_sex_female)
    ImageView img_sex_female;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_birthday)
    EditText et_birthday;
    @BindView(R.id.bt_open_os)
    Button bt_open_os;


    private int sex = 0;

    @OnClick(R.id.ll_sex_female)
    void sex_female() {
        if (sex == 2) return;
        sex = 2;
        img_sex_female.setImageResource(R.mipmap.improve_information_icon_female);
        img_sex_male.setImageResource(R.mipmap.improve_information_icon_male_2);
        setButtonStateWithCheck();
    }

    @OnClick(R.id.ll_sex_male)
    void sex_male() {
        sex = 1;
        img_sex_female.setImageResource(R.mipmap.improve_information_icon_female_2);
        img_sex_male.setImageResource(R.mipmap.improve_information_icon_male);
        setButtonStateWithCheck();
    }


    @OnClick(R.id.et_birthday)
    void birthday() {
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
                .setDefaultDateTime(TimeUtil.str2long(time, "yyyy-MM-dd"), !TextUtils.isEmpty(time))
                .show(getSupportFragmentManager(), "dialog_time");

        InputSoftUtil.close(activity);

    }

    @OnClick(R.id.bt_open_os)
    void open_os() {
        int length = et_username.getText().toString().length();
        int length2 = et_birthday.getText().toString().length();
        if (sex == 0) {
            mPresenter.toast("请选择性别！");
        } else if (length < 1 || length > 10) {
            mPresenter.toast("昵称长度1~10个字符！");
        } else if (length2 < 8) {
            mPresenter.toast("请完善生日！");
        } else if (avatarPath == null) {
            mPresenter.toast("请选择头像！");
        } else {
            consummate();
        }
    }

    private void consummate() {
        User user = new User();
        user.setSex(sex);
        user.setBirthday(et_birthday.getText().toString().replace("-", ""));
        user.setUsername(et_username.getText().toString());
        mPresenter.consummateMyInfo(user);
        mPresenter.consummateMyAvatar(avatarPath);
    }


    private String avatarPath;

    @OnClick(R.id.img_avatar)
    void avatar() {
        GP.create(new GP.CallBack() {
            @Override
            public void onSuccess(List<String> photoList) {
                avatarPath = photoList.get(0);
                G.img(context, avatarPath, img_avatar);
            }
        }).openWithPermission(activity);
    }


    @BindView(R.id.img_bg_top)
    ImageView img_bg_top;
    @BindView(R.id.fl_center)
    FrameLayout fl_center;
    @BindView(R.id.ll_input)
    LinearLayout ll_input;

    @Override
    protected void initView() {
        super.initView();
        setSwipeBackEnable(false);
        setButtonState(bt_open_os, false);

        AnimationUtil.appear(img_bg_top);
        AnimationUtil.enlarge(fl_center);
        AnimationUtil.next_in(ll_input);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = et_username.getText().toString();
                if (str.length() > 10) {
                    mPresenter.toast("长度不能超过10");
                    et_username.setText(str.substring(0, 9));
                    WidgetUtil.setEditSelectionLast(et_username);
                }
                setButtonStateWithCheck();
            }
        });
        et_birthday.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setButtonStateWithCheck();
            }
        });
    }

    private void setButtonStateWithCheck() {
        int length = et_username.getText().toString().length();
        int length2 = et_birthday.getText().toString().length();
        setButtonState(bt_open_os, length >= 1 && length <= 10 && length2 > 4 && sex > 0 && avatarPath != null);
    }

    private void setButtonState(Button button, boolean isCanPressed) {
        if (isCanPressed) {
            button.setBackgroundResource(R.drawable.bg_button_selector);
            WidgetUtil.setTextColor(button, R.color.colorWhite);
        } else {
            button.setBackgroundResource(R.drawable.bg_button_down);
            WidgetUtil.setTextColor(button, R.color.colorAhp_d);
        }
    }
}

