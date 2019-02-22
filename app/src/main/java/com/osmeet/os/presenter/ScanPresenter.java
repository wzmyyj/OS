package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.Code;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ScanContract;
import com.osmeet.os.model.net.VersionModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ScanPresenter extends BasePresenter<ScanContract.IView> implements ScanContract.IPresenter {

    private VersionModel versionModel;

    public ScanPresenter(Activity activity, ScanContract.IView iv) {
        super(activity, iv);
        versionModel = new VersionModel().bind((AppCompatActivity) activity);

    }

    @Override
    public void loadCode(@NonNull String qrCode) {
        if (!qrCode.contains(Code.CODE_BEGIN)) {
            toast("not our code: " + qrCode);
            return;
        }
        versionModel.version_code_resolve(new PObserver<Box<Code>>() {
            @Override
            public void onNext(Box<Code> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    Code code = box.getData();
                    switch (code.getCode()) {
                        case Code.CODE_USER_ID:
                            goUserInfo2(code.getInfo());
                            break;
                        case Code.CODE_TRADE_ID:
                            goTrade(code.getInfo());
                            break;
                    }
                }
            }
        }, qrCode);
    }
}
