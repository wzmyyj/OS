package com.osmeet.os.view.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.osmeet.os.R;
import com.osmeet.os.app.utils.AnimationUtil;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.LoginContract;
import com.osmeet.os.presenter.LoginPresenter;
import com.osmeet.os.view.panel.LoginPasswordPanel;
import com.osmeet.os.view.panel.LoginPhonePanel;
import com.osmeet.os.view.panel.LoginRegisterPanel;
import com.osmeet.os.view.panel.LoginSMSPanel;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 登录页面。
 */

public class LoginActivity extends BaseActivity<LoginContract.IPresenter> implements LoginContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new LoginPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @BindView(R.id.fl_l)
    FrameLayout mFrameLayout;

    private View v0, v1, v2, v3;
    private int what = 0;


    @BindView(R.id.img_ball_1)
    ImageView img_ball_1;
    @BindView(R.id.img_ball_2)
    ImageView img_ball_2;
    @BindView(R.id.img_bg_end)
    ImageView img_bg_end;

    @Override
    protected void initView() {
        super.initView();
        setSwipeBackEnable(false);
        mFrameLayout.addView(v0 = getPanelView(0));
        mFrameLayout.addView(v1 = getPanelView(1));
        mFrameLayout.addView(v2 = getPanelView(2));
        mFrameLayout.addView(v3 = getPanelView(3));
        v1.setVisibility(View.INVISIBLE);
        v2.setVisibility(View.INVISIBLE);
        v3.setVisibility(View.INVISIBLE);


        AnimationUtil.enlarge2narrow(img_ball_1);
        AnimationUtil.narrow2enlarge(img_ball_2);
        AnimationUtil.enlargeFromEnd(img_bg_end);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.check();
    }

    LoginPhonePanel phoneNumberPanel;// 输入电话号码。
    LoginPasswordPanel passwordLoginPanel;// 密码登录。
    LoginSMSPanel smsLoginPanel;// 短信验证登录。
    LoginRegisterPanel registerPanel;// 注册用户账号。

    @Override
    protected void initPanels() {
        super.initPanels();
        addPanels(
                phoneNumberPanel = new LoginPhonePanel(context, mPresenter),
                passwordLoginPanel = new LoginPasswordPanel(context, mPresenter),
                smsLoginPanel = new LoginSMSPanel(context, mPresenter),
                registerPanel = new LoginRegisterPanel(context, mPresenter)
        );
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (what >= 0) {
                showBack();
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }


    @Override
    public void showWhat(int w) {
        if (w != what) {
            goAnim(what, w);
            what = w;
        }
    }

    @Override
    public void showBack() {
        if (what > 0) {
            backAnim(what);
            what = 0;
        } else {
            showToast("再按一下Back键退出。");
            what = -1;
        }
    }

    @Override
    public void showLoadUserInfo(boolean isSuccess) {
        if (isSuccess) {
            fl_2.setVisibility(View.GONE);
        } else {
            fl_2.setVisibility(View.VISIBLE);
        }
    }

    private View getViewByWhat(int what) {
        switch (what) {
            case LOGIN_PASSWORD:
                return v1;
            case LOGIN_SMS:
                return v2;
            case LOGIN_REGISTER:
                return v3;
            default:
                return v0;
        }
    }


    private void goAnim(int a, int b) {
        final View aView = getViewByWhat(a);
        final View bView = getViewByWhat(b);
        aView.setVisibility(View.VISIBLE);
        bView.setVisibility(View.VISIBLE);
        AnimationUtil.next(aView, bView);
    }

    private void backAnim(int w) {
        final View aView = getViewByWhat(0);
        final View bView = getViewByWhat(w);
        aView.setVisibility(View.VISIBLE);
        bView.setVisibility(View.VISIBLE);
        AnimationUtil.back(aView, bView);
    }


    @BindView(R.id.fl_2)
    FrameLayout fl_2;

    @OnClick(R.id.bt_redo)
    void redo() {
        mPresenter.afterLogin();
    }

}

