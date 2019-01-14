package com.osmeet.os.base.contract;

import top.wzmyyj.wzm_sdk.inter.IContext;

/**
 * Created by yyj on 2018/07/09. email: 2209011667@qq.com
 */

public interface IBasePresenter extends IContext{

    void log(String msg);

    void toast(String msg);

    void finish();

    void destroy();
}
