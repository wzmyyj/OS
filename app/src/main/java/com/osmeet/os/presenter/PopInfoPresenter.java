package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.PopInfoContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.view.activity.LoginActivity;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class PopInfoPresenter extends BasePresenter<PopInfoContract.IView> implements PopInfoContract.IPresenter {

    private UserModel userModel;

    public PopInfoPresenter(Activity activity, PopInfoContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel().bind((AppCompatActivity) activity);
    }


    @Override
    public void consummateMyInfo(@NonNull User user) {
        isFinishConsummateInfo = false;
        consummateInfo(user);
    }

    @Override
    public void consummateMyAvatar(@NonNull String filePath) {
        isFinishUpdateAvatar = false;
        updateAvatar(filePath);
    }

    private boolean isFinishUpdateAvatar = true;
    private boolean isFinishConsummateInfo = true;

//    private void uploadFile(@NonNull String filePath) {
//        log(filePath);
//        fileModel.file_upload(new PObserver<Box<FileInfo>>() {
//            @Override
//            public void onNext(Box<FileInfo> box) {
//                if (box.getCode() != 0) {
//                    toast(box.getMessage());
//                    return;
//                }
//                FileInfo info = box.getData();
//                if (info.getId() != null) {
//                    log("fileId=" + info.getId());
//                    updateAvatar(info.getId());
//                }
//
//            }
//        }, filePath);
//    }
//
//    private void updateAvatar(String id) {
//        userModel.user_updateAvatar(new PObserver<Box<String>>() {
//            @Override
//            public void onNext(Box<String> box) {
//                if (box.getCode() != 0) {
//                    toast(box.getMessage());
//                    return;
//                }
//                isFinishUpdateAvatar = true;
//                checkFinishAll();
//            }
//        }, id);
//    }

    private void updateAvatar(@NonNull String filePath) {
        log(filePath);
        userModel.user_updateAvatar(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                log(box.getData());
            }
            @Override
            protected void onFinish() {
                super.onFinish();
                isFinishUpdateAvatar = true;
                checkFinishAll();
            }
        }, filePath);
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
            toast(getContext().getString(R.string.pop_info_success));
            loadMyInfo();
        }
    }


    private void loadMyInfo() {
        new UserModel().user(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    User user = box.getData();
                    App.getInstance().setMyInfo(user);
                    finishAndGoMain();
                }
            }
        });
    }

    private void finishAndGoMain(){
        App.getInstance().finish(LoginActivity.class);
        goMain();
        finish();
    }


}