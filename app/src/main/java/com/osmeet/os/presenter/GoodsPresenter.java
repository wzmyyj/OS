package com.osmeet.os.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.osmeet.os.app.bean.Goods;
import com.osmeet.os.base.presenter.BasePresenter;
import com.osmeet.os.contract.GoodsContract;
import com.osmeet.os.model.net.GoodsModel;
import com.osmeet.os.model.net.utils.box.Box;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class GoodsPresenter extends BasePresenter<GoodsContract.IView> implements GoodsContract.IPresenter {

    private GoodsModel goodsModel;

    public GoodsPresenter(Activity activity, GoodsContract.IView iv) {
        super(activity, iv);
        goodsModel = new GoodsModel();
    }


    @Override
    public void loadGoods() {
        String goodsId = getActivity().getIntent().getStringExtra("goodsId");
        if (TextUtils.isEmpty(goodsId)) {
            toast("Goods Id is a empty value!");
            return;
        }
        goodsModel.goods_get(new PObserver<Box<Goods>>() {
            @Override
            public void onNext(Box<Goods> box) {
                if (box.getCode() != 0) {
                    toast(box.getMessage());
                    return;
                }
                if (box.getData() != null) {
                    mView.showGoods(box.getData());
                }

            }
        }, goodsId);
    }
}
