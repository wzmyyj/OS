package com.osmeet.os.contract;

import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.BaseContract;
import com.osmeet.os.contract.ic.IStoryList;
import com.osmeet.os.contract.ic.IUserInfo;
import com.osmeet.os.contract.ip.IBlock;
import com.osmeet.os.contract.ip.IReport;
import com.osmeet.os.contract.ip.IUserId;

/**
 * Created by yyj on 2018/12/17. email: 2209011667@qq.com
 * 用户资料。
 */

public interface UserInfoContract {
    interface IView extends BaseContract.IView,
            IUserInfo.V,
            IStoryList.V {

    }

    interface IPresenter extends BaseContract.IPresenter,
            IUserInfo.P,
            IStoryList.P,
            IReport,
            IBlock,
            IUserId,
            I.ImageLook {

    }
}
