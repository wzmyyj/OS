package com.osmeet.os.contract;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 名片。
 */

public interface VisitCardContract {

    interface IView extends BaseContract.IView {
        void showMyInfo(@NonNull User user);

        void showCodeText(@NonNull String text);

    }

    interface IPresenter extends BaseContract.IPresenter, I.Scan {
        void loadMyInfo();

        void loadCodeText();

        void saveCardBitmap(@NonNull Bitmap bitmap);
    }

}
