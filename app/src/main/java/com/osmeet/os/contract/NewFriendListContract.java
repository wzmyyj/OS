package com.osmeet.os.contract;

import android.support.annotation.NonNull;

import com.osmeet.os.app.bean.Friend;
import com.osmeet.os.app.tools.I;
import com.osmeet.os.base.contract.IBasePresenter;
import com.osmeet.os.base.contract.IBaseView;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 广告。
 */

public interface NewFriendListContract {

    interface IView extends IBaseView {
        void showNewFriendList(@NonNull List<Friend> friendList, int pageNum);

        void showAgreeNewFriend(@NonNull String userId);
    }

    interface IPresenter extends IBasePresenter, I.VisitCard, I.Scan,I.FriendList {

        void loadNewFriendList(int pageNum);

        void postAgreeNewFriend(@NonNull String userId);
    }

}
