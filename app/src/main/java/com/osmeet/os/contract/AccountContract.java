package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public interface AccountContract {

    interface IView extends BaseContract.IView {


    }

    interface IPresenter extends BaseContract.IPresenter, I.Password{

        String getAccount();
    }

}
