package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.PopInfoContract;
import com.osmeet.os.model.net.FileModel;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.view.activity.LoginActivity;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class PopInfoPresenter extends BasePresenter<PopInfoContract.IView> implements PopInfoContract.IPresenter {

    private UserModel userModel;
    private FileModel fileModel;

    public PopInfoPresenter(Activity activity, PopInfoContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel();
        fileModel = new FileModel();
    }


    @Override
    public void consummateMyInfo(@NonNull User user) {
        isFinishConsummateInfo = false;
        consummateInfo(user);
    }

    @Override
    public void consummateMyAvatar(@NonNull String filePath) {
        isFinishUpdateAvatar = false;
        uploadFile(filePath);
    }

    private boolean isFinishUpdateAvatar = true;
    private boolean isFinishConsummateInfo = true;

    private void uploadFile(@NonNull String filePath) {
        log(filePath);
        fileModel.file_upload(new PObserver<Box<FileInfo>>() {
            @Override
            public void onNext(Box<FileInfo> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                FileInfo info = box.getData();
                if (info.getId() != null) {
                    log("fileId=" + info.getId());
                    log("文件上传成功！");
                    updateAvatar(info.getId());
                }

            }
        }, filePath);
    }

    private void updateAvatar(String id) {
        userModel.user_updateAvatar(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                isFinishUpdateAvatar = true;
                checkFinishAll();
            }
        }, id);
    }

    private void consummateInfo(@NonNull User user) {
        userModel.user_consummateInfoNoPass(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                isFinishConsummateInfo = true;
                checkFinishAll();
            }
        }, user);
    }

    private void checkFinishAll() {
        if (isFinishConsummateInfo && isFinishUpdateAvatar) {
            toast("完善信息成功!");
            App.getInstance().finish(LoginActivity.class);
            App.getInstance().setMyInfo(null);
            App.getInstance().setComplete(true);
            goMain();
            finish();
        }
    }

}