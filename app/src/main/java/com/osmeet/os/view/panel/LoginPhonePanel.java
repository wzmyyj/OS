package com.osmeet.os.view.panel;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.LoginContract;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class LoginPhonePanel extends BasePanel<LoginContract.IPresenter> {

    public LoginPhonePanel(Context context, LoginContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_login_phone;
    }

    @BindView(R.id.tv_zoneCode)
    TextView tv_zoneCode;
    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.bt_next)
    Button bt_next;

    @OnClick(R.id.tv_zoneCode)
    void zoneCode() {
        mPresenter.toast(context.getString(R.string.zone_code));
    }

    @OnClick(R.id.bt_next)
    void next() {
        String zoneCode = tv_zoneCode.getText().toString().replace("+", "");
        String phone = et_phone.getText().toString();
        if (phone.length() == 11) {
            mPresenter.checkExists(zoneCode, phone);
        }
    }


    @OnClick(R.id.tv_user_protocol)
    void user_protocol() {
        mPresenter.toast(context.getString(R.string.user_protocol));
    }

    @Override
    protected void initView() {
        super.initView();
        setButtonState(bt_next, false);
    }

    @Override
    protected void initListener() {
        super.initListener();
        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = et_phone.getText().toString().length();
                setButtonState(bt_next, length == 11);
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