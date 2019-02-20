package com.osmeet.os.view.activity;

import android.text.TextUtils;
import android.widget.EditText;

import com.osmeet.os.R;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.PasswordContract;
import com.osmeet.os.presenter.PasswordPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class PasswordActivity extends BaseActivity<PasswordContract.IPresenter> implements PasswordContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new PasswordPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_password;
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @BindView(R.id.et_new_password)
    EditText et_new_password;

    @BindView(R.id.et_new_password_2)
    EditText et_new_password_2;

    @OnClick(R.id.bt_update)
    void update() {
        String s1 = et_new_password.getText().toString();
        String s2 = et_new_password_2.getText().toString();
        if (TextUtils.isEmpty(s1)) return;
        if (TextUtils.isEmpty(s2)) return;
        if (s1.length() > 12 || s1.length() < 6) {
            mPresenter.toast(context.getString(R.string.password_length_wrong));
            et_new_password.setText("");
            et_new_password_2.setText("");
            return;
        }
        if (!s1.equals(s2)) {
            mPresenter.toast(context.getString(R.string.confirm_wrong));
            et_new_password_2.setText("");
            return;
        }
        mPresenter.changePassword(s1);


    }
}

