package com.osmeet.os.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Code;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.utils.FileUtil;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.VisitCardContract;
import com.osmeet.os.model.net.VersionModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class VisitCardPresenter extends BasePresenter<VisitCardContract.IView> implements VisitCardContract.IPresenter {


    private VersionModel versionModel;

    public VisitCardPresenter(Activity activity, VisitCardContract.IView iv) {
        super(activity, iv);
        versionModel = new VersionModel().bind((AppCompatActivity) activity);
    }


    @Override
    public void loadMyInfo() {
        User user = App.getInstance().getMyInfo();
        if (user != null) {
            mView.showMyInfo(user);
        }
    }


    @Override
    public void loadCodeText() {
        User user = App.getInstance().getMyInfo();
        if (user == null) return;
        versionModel.version_code_concat(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showCodeText(box.getData());
                }
            }
        }, new Code(Code.CODE_USER_ID, user.getId()));


    }

    @Override
    public void saveCardBitmap(@NonNull Bitmap bitmap) {
        boolean is = FileUtil.saveBitmap(bitmap, FileUtil.DEFAULT_FILE_PATH,
                "code" + App.getInstance().getMyInfo().getId(),
                getContext());
        if (is) {
            toast(getContext().getString(R.string.save_success));
        } else {
            toast(getContext().getString(R.string.save_fail));
        }
    }
}
