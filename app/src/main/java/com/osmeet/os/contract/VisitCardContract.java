package com.osmeet.os.contract;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 名片。
 */

public interface VisitCardContract {

    interface IView extends IBaseView {
        void showMyInfo(@NonNull User user);

        void showCodeText(@NonNull String text);

    }

    interface IPresenter extends IBasePresenter, I.Scan {
        void loadMyInfo();

        void loadCodeText();

        void saveCardBitmap(@NonNull Bitmap bitmap);
    }

}
