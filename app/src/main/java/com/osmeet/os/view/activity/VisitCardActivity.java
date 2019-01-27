package com.osmeet.os.view.activity;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.VisitCardContract;
import com.osmeet.os.presenter.VisitCardPresenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.WidgetUtil;

public class VisitCardActivity extends BaseActivity<VisitCardContract.IPresenter> implements VisitCardContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new VisitCardPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_visit_card;
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

//    @OnClick(R.id.img_menu)
//    void menu() {
//
//    }

    @BindView(R.id.ll_card)
    LinearLayout ll_card;

    @OnClick(R.id.ll_save_album)
    void save() {
        Bitmap bitmap = WidgetUtil.getViewBitmap(ll_card);
        if (bitmap != null) {
            mPresenter.saveCardBitmap(bitmap);
        }
    }

    @OnClick(R.id.ll_scan)
    void scan() {
        mPresenter.goScan();
    }

    @BindView(R.id.img_avatar)
    ImageView img_avatar;
    @BindView(R.id.img_2d_code)
    ImageView img_2d_code;

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMyInfo();
        mPresenter.loadCodeText();
    }

    @Override
    public void showMyInfo(@NonNull User user) {
        if (user.getAvatar() != null)
            G.img(context, user.getAvatar().getUrl(), img_avatar);
    }

    @Override
    public void showCodeText(@NonNull String text) {
        if (TextUtils.isEmpty(text)) {
            mPresenter.toast("code is empty text");
            return;
        }
        Bitmap bitmap = CodeUtils.createImage(text, 400, 400, null);
        img_2d_code.setImageBitmap(bitmap);
    }


}

