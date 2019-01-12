package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.StoreContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;

import java.util.List;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StorePresenter extends BasePresenter<StoreContract.IView> implements StoreContract.IPresenter {

    private StoreModel storeModel;
    private MatchModel matchModel;

    public StorePresenter(Activity activity, StoreContract.IView iv) {
        super(activity, iv);
        storeModel = new StoreModel();
        matchModel = new MatchModel();
    }


    private String getStoreId() {
        return mActivity.getIntent().getStringExtra("storeId");
    }

    @Override
    public void loadStoreInfo() {
        String storeId = getStoreId();
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

        // 进入商店。
        matchModel.matchUnit_goToMatchInStore(new PObserver<Box<MatchUnit>>() {
            @Override
            public void onNext(Box<MatchUnit> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    log("进入商店成功！");
                }
            }
        }, storeId);
    }

    @Override
    public void loadMatchUnitList() {
        String storeId = getStoreId();
        if (TextUtils.isEmpty(storeId)) {
            toast("Store Id is a empty value!");
            return;
        }
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
        }, storeId, ConditionBody.defaultCondition());
    }


}
