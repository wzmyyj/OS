package com.osmeet.os.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.tools.G;
import com.osmeet.os.base.activity.BaseMainActivity;
import com.osmeet.os.contract.MainContract;
import com.osmeet.os.presenter.MainPresenter;
import com.osmeet.os.view.fragment.HomeFragment;
import com.osmeet.os.view.fragment.MessageFragment;
import com.osmeet.os.view.fragment.MineFragment;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.utils.DensityUtil;
import top.wzmyyj.wzm_sdk.utils.TabLayoutUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 主页面。
 */

public class MainActivity extends BaseMainActivity<MainContract.IPresenter> implements MainContract.IView, AMapLocationListener {
    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter(activity, this);
    }

    @Override
    protected void initFTs(List<FT> fts) {
        fts.add(new FT(new MessageFragment(), context.getString(R.string.message), R.mipmap.ic_message, R.mipmap.ic_message_selected));
        fts.add(new FT(new HomeFragment(), context.getString(R.string.home), R.mipmap.ic_home, R.mipmap.ic_home_selected));
        fts.add(new FT(new MineFragment(), context.getString(R.string.mine), R.color.colorClarity, R.mipmap.ic_mine_selected));
    }

    @Override
    protected void initView() {
        super.initView();
        mViewPager.setSlide(false);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.loadMyInfo();
    }

    @Override
    protected int initTabHeight() {
        return DensityUtil.dp2px(context, 50);
    }

    @Override
    protected int firstWhich() {
        return 1;// 一开始显示中间那页。
    }

    @Override
    protected void initTabStyle() {
        super.initTabStyle();
        setTabLayoutStyle(new TabLayoutUtil.TabLayoutStyle() {
            final List<ImageView> imageViewList = new ArrayList<>();

            @Override
            public void setCustomView(TabLayout.Tab tab) {
                View customView = tab.setCustomView(R.layout.layout_main_tab).getCustomView();
                if (customView == null) return;
                ImageView img_tab = customView.findViewById(R.id.img_tab);
                imageViewList.add(img_tab);
                if (tab.getPosition() == 2) {
                    img_avatar = customView.findViewById(R.id.img_avatar);
                    img_avatar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void setTabSelected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                imageViewList.get(p).setImageResource(mFTs.get(p).icon_selected);
            }

            @Override
            public void setTabUnselected(TabLayout.Tab tab) {
                int p = tab.getPosition();
                imageViewList.get(p).setImageResource(mFTs.get(p).icon_unselected);
            }

            @Override
            public void setTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private ImageView img_avatar;


    @Override
    public void showMyInfo(@NonNull User user) {
        G.img(context, user.getAvatar().getUrl(), img_avatar);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        doMap();
    }

    //定位自身
    private void doMap() {
        AndPermission.with(context)
                .permission(Permission.ACCESS_COARSE_LOCATION,
                        Permission.WRITE_EXTERNAL_STORAGE,
                        Permission.ACCESS_FINE_LOCATION,
                        Permission.READ_PHONE_STATE
                )
                .onGranted(permissions -> location())
                .onDenied(permissions -> mPresenter.toast(context.getString(R.string.no_permission)))
                .start();
    }

    private AMapLocationClient mLocationClient = null;

    //定位
    private void location() {
        mLocationClient = new AMapLocationClient(context.getApplicationContext());
        mLocationClient.setLocationListener(this);
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setOnceLocation(true);
//        mLocationOption.setMockEnable(false);
//        mLocationOption.setInterval(5000);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude = aMapLocation.getLatitude();//获取纬度
                double longitude = aMapLocation.getLongitude();//获取经度
                DPoint mPoint = new DPoint(latitude, longitude);
                App.getInstance().setMyDPoint(mPoint);
                mPresenter.sendLocation(longitude,latitude);
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AMapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mLocationClient != null && !mLocationClient.isStarted()) {
            mLocationClient.startLocation();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mLocationClient != null && mLocationClient.isStarted()) {
            mLocationClient.stopLocation();
        }

    }
}

