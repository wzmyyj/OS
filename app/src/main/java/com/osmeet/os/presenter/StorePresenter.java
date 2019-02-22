package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.MatchInvite;
import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.StoreContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.util.List;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StorePresenter extends BasePresenter<StoreContract.IView> implements StoreContract.IPresenter {

    private StoreModel storeModel;
    private MatchModel matchModel;

    public StorePresenter(Activity activity, StoreContract.IView iv) {
        super(activity, iv);
        storeModel = new StoreModel().bind((AppCompatActivity) activity);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
    }


    @Override
    public int getMode() {
        return getActivity().getIntent().getIntExtra("mode", 0);
    }

    @Override
    public void inviteFriends() {
        final String storeId = getActivity().getIntent().getStringExtra("storeId");
        if (TextUtils.isEmpty(storeId)) {
            toast("Store Id is a empty value!");
            return;
        }
        goInviteFriends(storeId);
    }

    @Override
    public void loadStoreInfo() {
        final String storeId = getActivity().getIntent().getStringExtra("storeId");
        if (TextUtils.isEmpty(storeId)) {
            toast("Store Id is a empty value!");
            return;
        }
        storeModel.store(new PObserver<Box<Store>>() {
            @Override
            public void onNext(Box<Store> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showStoreInfo(box.getData());
                }

            }
        }, storeId);


    }

//    private void intoMatchStore(String storeId) {
//        // 进入商店。
//        matchModel.matchUnit_goToMatchInStore(new PObserver<Box<MatchUnit>>() {
//            @Override
//            public void onNext(Box<MatchUnit> box) {
//                if (box.getCode() != 0) {
//                    toast(box.getMessage());
//                    return;
//                }
//                if (box.getData() != null) {
//                    log("into store success！");
//                }
//            }
//        }, storeId);
//    }

    @Override
    public void loadMatchUnitList() {
        String storeId = getActivity().getIntent().getStringExtra("storeId");
        if (TextUtils.isEmpty(storeId)) {
            toast("Store Id is a empty value!");
            return;
        }
        if (getMode() != 0) return;
        matchModel.matchUnit_getMatchsInStore(new PObserver<Box<List<MatchUnit>>>() {
            @Override
            public void onNext(Box<List<MatchUnit>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchUnitList(box.getData());
                }
            }
        }, storeId, new ConditionBody(
                App.getInstance().getSetting().getOsDistance(),
                App.getInstance().getSetting().getOsMaxAge(),
                App.getInstance().getSetting().getOsMinAge(),
                App.getInstance().getSetting().getOsSex()
        ));
    }

    @Override
    public void loadMatchInviteList(int pageNum) {
        String storeId = getActivity().getIntent().getStringExtra("storeId");
        if (TextUtils.isEmpty(storeId)) {
            toast("Store Id is a empty value!");
            return;
        }
        if (getMode() != 1) return;
        matchModel.matchInvite_geBeInvitedByStore(new PObserver<Box<ListContent<MatchInvite>>>() {
            @Override
            public void onNext(Box<ListContent<MatchInvite>> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showMatchInviteList(box.getData().getContent());
                }
            }
        }, storeId, pageNum, 100);
    }


}
