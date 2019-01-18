package com.osmeet.os.base.contract;

import com.osmeet.os.base.contract.ip.IContext;

/**
 * Created by yyj on 2018/07/09.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IBasePresenter extends IContext{

    void log(String msg);

    void toast(String msg);

    void finish();

    void finish(int how);

    void destroy();
}
