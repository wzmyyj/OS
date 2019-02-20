package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.R;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.PasswordContract;
import com.osmeet.os.model.net.UserModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2019/02/20.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class PasswordPresenter extends BasePresenter<PasswordContract.IView> implements PasswordContract.IPresenter {

    private UserModel userModel;

    public PasswordPresenter(Activity activity, PasswordContract.IView iv) {
        super(activity, iv);
        userModel = new UserModel();
    }

    @Override
    public void changePassword(@NonNull String password) {
        userModel.user_updatePassword(new PObserver<Box<String>>() {
            @Override
            public void onNext(Box<String> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    toast(getContext().getString(R.string.update_password_success));
                }
            }
        }, password);
    }
}
