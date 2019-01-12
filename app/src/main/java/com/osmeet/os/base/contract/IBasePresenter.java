package com.osmeet.os.base.contract;

import top.wzmyyj.wzm_sdk.inter.IContext;

/**
 * Created by yyj on 2018/07/09. email: 2209011667@qq.com
 */

public interface IBasePresenter extends IContext {

    void log(String s);

    void toast(String s);

    void finish();

    void destroy();
}
