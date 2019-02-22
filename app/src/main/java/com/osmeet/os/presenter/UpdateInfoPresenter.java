package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.event.MyInfoUpdateEvent;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.UpdateInfoContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yyj on 2018/12/26. email: 2209011667@qq.com
 */

public class UpdateInfoPresenter extends BasePresenter<UpdateInfoContract.IView> implements UpdateInfoContract.IPresenter {

    private UserModel userModel;

    public UpdateInfoPresenter(Activity activity, UpdateInfoContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel().bind((AppCompatActivity) activity);
    }


    @Override
    public void loadMyInfo() {
        if (App.getInstance().getMyInfo() != null) {
            mView.showMyInfo(App.getInstance().getMyInfo());
            return;
        }
        userModel.user(new PObserver<Box<User>>() {
            @Override
            public void onNext(Box<User> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    User user = box.getData();
                    App.getInstance().setMyInfo(user);
                    mView.showMyInfo(user);
                }
            }
        });
    }

    @Override
    public void updateMyInfo(@NonNull User user) {
        if (isFinishUpdateInfo) {
            isFinishUpdateInfo = false;
            updateInfo(user);
        }
    }

    @Override
    public void updateMyAvatar(@NonNull String filePath) {
        if (isFinishUpdateAvatar) {
            isFinishUpdateAvatar = false;
            updateAvatar(filePath);
        }
    }

    @Override
    public void updateMyImages(@NonNull String[] imageIds, @NonNull String[] filePaths) {
        if (isFinishUpdateImages) {
            isFinishUpdateImages = false;
            updateImages(imageIds, filePaths);
        }

    }


    private boolean isFinishUpdateAvatar = true;
    private boolean isFinishUpdateInfo = true;
    private boolean isFinishUpdateImages = true;


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

    private void updateInfo(@NonNull User user) {
        userModel.user_update(new PObserver<Box<String>>() {
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
                isFinishUpdateInfo = true;
                checkFinishAll();
            }
        }, user);
    }

    private void updateImages(@NonNull String[] imageIds, @NonNull String[] filePaths) {
        userModel.user_updateDisplayImages(new PObserver<Box<String>>() {
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
                isFinishUpdateImages = true;
                checkFinishAll();
            }
        }, imageIds, filePaths);
    }

    private void checkFinishAll() {
        if (isFinishUpdateInfo && isFinishUpdateAvatar && isFinishUpdateImages) {
            toast(getContext().getString(R.string.update_info_success));
            App.getInstance().setMyInfo(null);
            EventBus.getDefault().post(new MyInfoUpdateEvent(true));
            finish();
        }
    }


}
