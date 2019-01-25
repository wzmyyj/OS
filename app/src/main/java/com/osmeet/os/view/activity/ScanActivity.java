package com.osmeet.os.view.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;

import com.kongzue.dialog.v2.BottomMenu;
import com.osmeet.os.R;
import com.osmeet.os.app.tools.GP;
import com.osmeet.os.base.activity.BaseActivity;
import com.osmeet.os.contract.ScanContract;
import com.osmeet.os.presenter.ScanPresenter;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import top.wzmyyj.wzm_sdk.utils.FragmentUtil;

public class ScanActivity extends BaseActivity<ScanContract.IPresenter> implements ScanContract.IView {
    @Override
    protected void initPresenter() {
        mPresenter = new ScanPresenter(activity, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan;
    }

    @OnClick(R.id.img_back)
    void back() {
        mPresenter.finish();
    }

    @OnClick(R.id.img_menu)
    void menu() {
        List<String> list = new ArrayList<>();
        list.add("相册中选取");
        BottomMenu.show((AppCompatActivity) context, list, (text, index) -> {
                    switch (index) {
                        case 0:
                            openGallery();
                            break;
                    }
                }, true, context.getString(R.string.cancel)
        ).setTitle("请选择！");
    }

    private void openGallery() {
        GP.create(new GP.CallBack() {
            @Override
            public void onSuccess(List<String> photoList) {
                if (photoList.size() > 0)
                    decode(photoList.get(0));
            }
        })
                .crop(false)
                .isShowCamera(false)
                .openWithPermission(activity);
    }

    private void decode(String path) {
        CodeUtils.analyzeBitmap(path, analyzeCallback);
    }

    private CaptureFragment captureFragment;
    private CodeUtils.AnalyzeCallback analyzeCallback;

    @Override
    protected void initView() {
        super.initView();
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        //CodeUtils.setFragmentArgs(captureFragment, R.layout.layout_camera);
        /*
         * 替换我们的扫描控件
         */
        FragmentUtil.replace(getSupportFragmentManager(),
                R.id.fl_my_container, captureFragment, null);
    }

    @Override
    protected void initListener() {
        super.initListener();
        analyzeCallback = new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                mPresenter.toast("识别二维码:" + result);
            }

            @Override
            public void onAnalyzeFailed() {
                mPresenter.toast("未能识别二维码！");
            }
        };
        captureFragment.setAnalyzeCallback(analyzeCallback);

    }
}

