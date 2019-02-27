package com.osmeet.os.presenter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.GoodsContract;
import com.osmeet.os.model.net.GoodsModel;
import com.osmeet.os.model.net.utils.box.Box;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class GoodsPresenter extends BasePresenter<GoodsContract.IView> implements GoodsContract.IPresenter {

    private GoodsModel goodsModel;
    private String goodsId;

    public GoodsPresenter(Activity activity, GoodsContract.IView iv) {
        super(activity, iv);
        goodsModel = new GoodsModel().bind((AppCompatActivity) activity);
        goodsId = getActivity().getIntent().getStringExtra("goodsId");
        Sure.sure(!TextUtils.isEmpty(goodsId), "Goods Id is a empty value!");
    }


    @Override
    public void loadGoodsInfo() {
        goodsModel.goods_get(new PObserver<Box<Goods>>() {
            @Override
            public void onNext(Box<Goods> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showGoodsInfo(box.getData());
                }

            }
        }, goodsId);
    }
}
