package com.osmeet.os.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Report;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.bean.Story;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.StoreInfoContract;
import com.osmeet.os.model.net.ReportModel;
import com.osmeet.os.model.net.StoreModel;
import com.osmeet.os.model.net.utils.box.Box;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class StoreInfoPresenter extends BasePresenter<StoreInfoContract.IView> implements StoreInfoContract.IPresenter {

    private StoreModel storeModel;
    private String storeId;

    public StoreInfoPresenter(Fragment fragment, StoreInfoContract.IView iv) {
        super(fragment, iv);
        storeModel = new StoreModel().bind(fragment);
        storeId = activity.getIntent().getStringExtra("storeId");
        Sure.sure(!TextUtils.isEmpty(storeId), "Store Id is a empty value!");
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
    public void report(@NonNull String content) {
        new ReportModel().report(new PObserver<Box<Report>>() {
            @Override
            public void onNext(Box<Report> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                toast(context.getString(R.string.report_success));
            }
        }, new Report(Report.REPORT_STORE, storeId, content));
    }

    @Override
    public void loadStoryList(int pageNum) {
        mView.showStoryList(Story.testList(20),pageNum);
    }
}
