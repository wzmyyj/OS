package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.LoginContract;
import com.osmeet.os.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.InputSoftUtil;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LoginSMSPanel extends BasePanel<LoginContract.IPresenter> {

    public LoginSMSPanel(Context context, LoginContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_login_sms;
    }

    @BindView(R.id.tv_get_sms_code)
    TextView tv_get_sms_code;
    @BindView(R.id.et_sms_code)
    EditText et_sms_code;
    @BindView(R.id.bt_login)
    Button bt_login;

    @OnClick(R.id.bt_login)
    void login() {
        String smsCode = et_sms_code.getText().toString();
        if (smsCode.length() == 4) {
            mPresenter.loginSMS(smsCode);
        }

    }

    @OnClick(R.id.tv_use_password_login)
    void use_password_login() {
        ((LoginActivity) activity).showWhat(LoginActivity.LOGIN_PASSWORD);
    }

    @OnClick(R.id.tv_cannot_login)
    void cannot_login() {
        mPresenter.toast(context.getString(R.string.can_not_login_please_call_dev));
    }

    @OnClick(R.id.tv_get_sms_code)
    void get_sms_code() {
        if (t < 60) {
            return;// 正在倒计时，直接返回。
        }
        mPresenter.needSMSCode();// 短信验证。
        handler.sendEmptyMessage(0);
    }


    public void  get_code(){

    }
    private int t = 60;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (t-- > 0) {
                tv_get_sms_code.setText(t + "s");
                handler.sendEmptyMessageDelayed(0, 1000);
            } else {
                t = 60;
                tv_get_sms_code.setText(context.getText(R.string.get_sms_code));
            }
        }
    };


    @Override
    public void onStop() {
        super.onStop();
        handler.removeMessages(0);
    }

    @Override
    protected void initView() {
        super.initView();
        setButtonState(bt_login, false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_sms_code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = et_sms_code.getText().toString();
                if (str.length() > 4) {
                    et_sms_code.setText(str.substring(0, 4));
                }
                if (str.length() == 4) {
                    et_sms_code.clearFocus();
                    InputSoftUtil.close(activity);
                }
                setButtonState(bt_login, str.length() == 4);
            }
        });
    }

    private void setButtonState(Button button, boolean isCanPressed) {
        if (isCanPressed) {
            button.setBackgroundResource(R.drawable.bg_button_selector);
            WidgetUtil.setTextColor(button, R.color.colorWhite);
        } else {
            button.setBackgroundResource(R.drawable.bg_button_non);
            WidgetUtil.setTextColor(button, R.color.colorAhp_d);
        }
    }
}