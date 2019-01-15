package com.osmeet.os.base.contract;

import top.wzmyyj.wzm_sdk.inter.IShowProcess;

/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public interface IBaseView extends IShowProcess {
    int FINISH_FADE_IN_OUT = -0x12345;
    int FINISH_DEAULT = 0;

    void showToast(String msg);

    void showFinishActivity(int how);
}
