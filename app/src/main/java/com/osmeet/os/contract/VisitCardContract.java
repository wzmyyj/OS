package com.osmeet.os.contract;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.ICodeText;
import com.osmeet.os.contract.ic.IMyInfo;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 名片。
 */

public interface VisitCardContract {

    interface IView extends BaseContract.IView,
            IMyInfo.V,
            ICodeText.V {
    }

    interface IPresenter extends BaseContract.IPresenter,
            IMyInfo.P,
            ICodeText.P,
            I.Scan {

        void saveCardBitmap(@NonNull Bitmap bitmap);
    }

}
