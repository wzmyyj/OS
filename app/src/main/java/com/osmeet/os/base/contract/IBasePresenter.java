package com.osmeet.os.base.contract;

import com.osmeet.os.base.contract.ip.IContext;
import com.osmeet.os.base.contract.ip.ITools;

/**
 * Created by yyj on 2018/07/09.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IBasePresenter extends IContext,ITools{

    void finish();

    void finish(int how);

    void destroy();
}
