package com.osmeet.os.contract;

import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IStoreList;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 聊天邀请相对。
 */

public interface ChatInviteContract {

    interface IView extends BaseContract.IView,
            IStoreList.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IStoreList.P {

    }

}
