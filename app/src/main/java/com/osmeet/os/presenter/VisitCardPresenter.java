package com.osmeet.os.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.Code;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.utils.FileUtil;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.VisitCardContract;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class VisitCardPresenter extends BasePresenter<VisitCardContract.IView> implements VisitCardContract.IPresenter {


    public VisitCardPresenter(Activity activity, VisitCardContract.IView iv) {
        super(activity, iv);
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
        if (user != null) {
            String userId = user.getId();
            mView.showCodeText(Code.CODE_BEGIN + "user/code?userId=" + userId);
        }
    }

    @Override
    public void saveCardBitmap(@NonNull Bitmap bitmap) {
        boolean is = FileUtil.saveBitmap(bitmap, FileUtil.DEFAULT_FILE_PATH,
                "code" + App.getInstance().getMyInfo().getId(),
                getContext());
        if (is) {
            toast("保存成功！");
        } else {
            toast("保存失败！");
        }
    }
}
