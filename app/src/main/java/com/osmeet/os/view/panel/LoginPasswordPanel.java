package com.osmeet.os.view.panel;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.osmeet.os.R;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.LoginContract;
import com.osmeet.os.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LoginPasswordPanel extends BasePanel<LoginContract.IPresenter> {

    public LoginPasswordPanel(Context context, LoginContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_login_password;
    }


    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.bt_login)
    Button bt_login;

    @OnClick(R.id.bt_login)
    void login() {
        String password = et_password.getText().toString();
        if (password.length() >= 6 && password.length() <= 12) {
            mPresenter.loginPassword(password);
        }
    }

    @OnClick(R.id.tv_use_sms_login)
    void use_sms_login() {
        ((LoginActivity) activity).showWhat(LoginActivity.LOGIN_SMS);
    }

    @OnClick(R.id.tv_cannot_login)
    void cannot_login() {
        mPresenter.toast("不能登录，请联系开发商。");
    }

    @Override
    protected void initView() {
        super.initView();
        setButtonState(bt_login, false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = et_password.getText().toString().length();
                setButtonState(bt_login, length >= 6 && length <= 12);
            }
        });
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