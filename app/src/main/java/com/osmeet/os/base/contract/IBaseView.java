package com.osmeet.os.base.contract;

import top.wzmyyj.wzm_sdk.inter.IShowProcess;

/**
 * Created by yyj on 2018/06/28. email: 2209011667@qq.com
 */

public interface IBaseView extends IShowProcess {
    void showToast(String msg);

    void showFinishActivity();
}
