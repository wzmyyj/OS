package com.osmeet.os.view.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.osmeet.os.R;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.panel.BaseRecyclerPanel;
import com.osmeet.os.contract.HomeStoreContract;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.adapter.ivd.IVD;
import top.wzmyyj.wzm_sdk.adapter.ivd.SingleIVD;
import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.MockUtil;

/**
 * Created by yyj on 2018/12/10. email: 2209011667@qq.com
 */

public class HomeStoreRecyclerPanel extends BaseRecyclerPanel<Store, HomeStoreContract.IPresenter> {
    public HomeStoreRecyclerPanel(Context context, HomeStoreContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected void setIVD(List<IVD<Store>> ivd) {
        ivd.add(new SingleIVD<Store>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.layout_home_store_item;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void convert(ViewHolder holder, Store store, int position) {
                int w = MockUtil.getScreenWidth(context);
                int m = DensityUtil.dp2px(context, 10);
                View convertView = holder.getConvertView();
                ViewGroup.LayoutParams params = convertView.getLayoutParams();
                params.width = w / 2;
                params.height = (w - 3 * m);
                if ((position & 1) > 0) {// 右边。
                    convertView.setPadding(m / 2, 0, m, 0);
                } else {// 左边。
                    convertView.setPadding(m, 0, m / 2, 0);
                }
                convertView.setLayoutParams(params);

                ImageView img_bg = holder.getView(R.id.img_bg);
                G.img(context, store.getImages().get(0).getUrl(), img_bg);

                ImageView img_store_avatar = holder.getView(R.id.img_store_avatar);
                if (store.getLogoImage() != null)
                    G.img(context, store.getLogoImage().getUrl(), img_store_avatar);

                TextView tv_store_name = holder.getView(R.id.tv_store_name);
                tv_store_name.setText(store.getName());

                TextView tv_store_os_num = holder.getView(R.id.tv_store_os_num);
                tv_store_os_num.setText("" + store.getMatchCount());

                List<String> avatarUrls = store.getAvatarUrls();
                if (avatarUrls == null) return;
                // 4个头像。
                List<ImageView> imageViews = new ArrayList<>();
                imageViews.add(holder.getView(R.id.img_u_1));
                imageViews.add(holder.getView(R.id.img_u_2));
                imageViews.add(holder.getView(R.id.img_u_3));
                imageViews.add(holder.getView(R.id.img_u_4));

                int size = avatarUrls.size();
                for (int i = 0; i < 4; i++) {
                    if (i < size) {
                        imageViews.get(i).setVisibility(View.VISIBLE);
                        G.img(context, avatarUrls.get(i), imageViews.get(i));
                    } else {
                        imageViews.get(i).setVisibility(View.GONE);
                    }

                }
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    @Override
    public void update() {
        num = 0;
        mPresenter.log(mPresenter.getCategoryId());
        mPresenter.loadStoreList(num);
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        super.onItemClick(view, holder, position);
        String id = mData.get(position).getId();
        if (!TextUtils.isEmpty(id)) {
            mPresenter.goStore(id);
        } else {
            mPresenter.toast("Store Id is a empty value!");
        }
    }

    private int num = 0;

    public void setStoreList(List<Store> storeList) {
        if (num == 0) {// 刷新或者第一次加载。
            mData.clear();
        }
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        mData.addAll(storeList);
        notifyDataSetChanged();
    }

    @Override
    protected void loadMore() {
        super.loadMore();
        num++;
        mPresenter.loadStoreList(num);
    }

    @SuppressLint("InflateParams")
    @Override
    protected void setFooter() {
        super.setFooter();
        mFooter = mInflater.inflate(R.layout.layout_footer, null);
    }
}
