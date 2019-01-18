package com.osmeet.os.base.contract;

import com.osmeet.os.base.contract.iv.IFinishActivity;
import com.osmeet.os.base.contract.iv.IShowProcess;

/**
 * Created by yyj on 2018/06/28.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public interface IBaseView extends IShowProcess, IFinishActivity {

    void showToast(String msg);

}
