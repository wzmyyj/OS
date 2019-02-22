package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.ChatInviteContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class ChatInvitePresenter extends BasePresenter<ChatInviteContract.IView> implements ChatInviteContract.IPresenter {

    private MatchModel matchModel;

    public ChatInvitePresenter(Activity activity, ChatInviteContract.IView iv) {
        super(activity, iv);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
    }

    @Override
    public void loadStoreList(int pageNum) {
        matchModel.matchUnit(new PObserver<Box<ListContent<MatchUnit>>>() {
            @Override
            public void onNext(Box<ListContent<MatchUnit>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {

                    List<MatchUnit> matchUnitList = box.getData().getContent();
                    List<Store> storeList = new ArrayList<>();
                    for (MatchUnit unit : matchUnitList) {
                        storeList.add(unit.getStore());
                    }
                    mView.showStoreList(storeList, pageNum);
                }
            }
        }, pageNum, 20);
    }
}
