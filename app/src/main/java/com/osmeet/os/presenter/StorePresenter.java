package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.MatchUnit;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.StoreContract;
import com.osmeet.os.model.net.MatchModel;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;

import java.util.List;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StorePresenter extends BasePresenter<StoreContract.IView> implements StoreContract.IPresenter {

    private StoreModel storeModel;
    private MatchModel matchModel;
    private String storeId;

    public StorePresenter(Activity activity, StoreContract.IView iv) {
        super(activity, iv);
        storeModel = new StoreModel().bind((AppCompatActivity) activity);
        matchModel = new MatchModel().bind((AppCompatActivity) activity);
        storeId = getActivity().getIntent().getStringExtra("storeId");
        Sure.sure(!TextUtils.isEmpty(storeId),"Store Id is a empty value!");
    }



    @Override
    public String getStoreId() {
        return this.storeId;
    }

    @Override
    public void loadStoreInfo() {
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


    @Override
    public void loadMatchUnitList() {
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

}
