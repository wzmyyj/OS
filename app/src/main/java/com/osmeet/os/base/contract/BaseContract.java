package com.osmeet.os.base.contract;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.osmeet.os.base.contract.ic.IFinish;
import com.osmeet.os.base.contract.ip.IContext;
import com.osmeet.os.base.contract.ip.ITools;
import com.osmeet.os.base.contract.iv.IToast;

/**
 * Created by yyj on 2019/02/26.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface BaseContract {


    interface IView extends IToast, IFinish.V {

    }

    interface IPresenter extends IContext, ITools, IFinish.P {

        void attach(@NonNull Activity activity);

        void attach(@NonNull Fragment fragment);

        void detach();
    }
}
