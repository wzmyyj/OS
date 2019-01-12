package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.utils.WidgetUtil;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.LoginContract;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LoginRegisterPanel extends BasePanel<LoginContract.IPresenter> {

    public LoginRegisterPanel(Context context, LoginContract.IPresenter iPresenter) {
        super(context,iPresenter);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.layout_login_register;
    }


    @BindView(R.id.tv_get_sms_code)
    TextView tv_get_sms_code;
    @BindView(R.id.et_sms_code)
    EditText et_sms_code;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.img_eye)
    ImageView img_eye;
    @BindView(R.id.bt_register)
    Button bt_register;

    @OnClick(R.id.bt_register)
    void next() {
        String smsCode = et_sms_code.getText().toString();
        String password = et_password.getText().toString();
        if (smsCode.length() == 4 && password.length() >= 6 && password.length() <= 12) {
            mPresenter.register(smsCode, password);
        }

    }


    @OnClick(R.id.tv_get_sms_code)
    void get_sms_code() {
        if (t < 60) {
            return;// 正在倒计时，直接返回。
        }
        mPresenter.needSMSCode();// 短信验证。
        handler.sendEmptyMessage(0);
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

    private boolean isCanSeePassword = false;

    @OnClick(R.id.img_eye)
    void eye() {
        if (isCanSeePassword = !isCanSeePassword) {
            img_eye.setImageResource(R.mipmap.login_eye_can);
        } else {
            img_eye.setImageResource(R.mipmap.login_eye_gray);
        }
        WidgetUtil.setPasswordEditState(et_password, isCanSeePassword);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
    }

    @Override
    protected void initView() {
        super.initView();
        WidgetUtil.setButtonState(bt_register, false);
        WidgetUtil.setPasswordEditState(et_password, isCanSeePassword);
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
                setButtonStateWithCheck();
                if (et_sms_code.getText().toString().length() == 4) {
                    et_sms_code.clearFocus();
                    et_password.requestFocus();
                }

            }
        });
        et_password.addTextChangedListener(new TextWatcher() {
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
        int length = et_sms_code.getText().toString().length();
        int length2 = et_password.getText().toString().length();
        WidgetUtil.setButtonState(bt_register, length == 4 && (length2 >= 6 && length2 <= 12));
    }


}