package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StoreInfoPresenter extends BasePresenter<StoreInfoContract.IView> implements StoreInfoContract.IPresenter {

    private StoreModel storeModel;

    public StoreInfoPresenter(Activity activity, StoreInfoContract.IView iv) {
        super(activity, iv);
        storeModel = new StoreModel();
    }

    @Override
    public String getStoreId() {
        return mActivity.getIntent().getStringExtra("storeId");
    }

    @Override
    public void loadStoreInfo() {
        String storeId = mActivity.getIntent().getStringExtra("storeId");
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
                mView.showStoreInfo(box.getData());

            }
        }, storeId);
    }
}
