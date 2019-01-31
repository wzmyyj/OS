package com.osmeet.os.base.contract;

import com.osmeet.os.base.contract.iv.IToast;

/**
 * Created by yyj on 2018/06/28.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IBaseView extends IToast {

    int FINISH_FADE_IN_OUT = -0x12345;
    int FINISH_DEFAULT = 0;

    void showFinishActivity(int how);

}
