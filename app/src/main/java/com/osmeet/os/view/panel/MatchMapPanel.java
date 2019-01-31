package com.osmeet.os.view.panel;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.osmeet.os.R;
import com.osmeet.os.app.application.App;
import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.app.bean.Store;
import com.osmeet.os.base.panel.BasePanel;
import com.osmeet.os.contract.MatchContract;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import butterknife.BindView;
import top.wzmyyj.wzm_sdk.utils.ApkUtil;

/**
 * Created by yyj on 2019/01/03. email: 2209011667@qq.com
 */

public class MatchMapPanel extends BasePanel<MatchContract.IPresenter> implements LocationSource, AMapLocationListener {

    public MatchMapPanel(Context context, MatchContract.IPresenter iPresenter) {
        super(context, iPresenter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_match_map;
    }

    @BindView(R.id.map)
    MapView mMapView;

    private AMapLocationClient mLocationClient = null;
    //声明mListener对象，定位监听器
    private LocationSource.OnLocationChangedListener mListener = null;
    //标识，用于判断是否只显示一次定位信息和用户重新定位
    private boolean isFirstLoc = true;
    private AMap aMap = null;
    //经度
    private String longitude;
    //纬度
    private String latitude;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mMapView.getMap();
            // 设置定位监听
            aMap.setLocationSource(this);
            // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
            aMap.setMyLocationEnabled(true);

            UiSettings settings = aMap.getUiSettings();
            // 是否显示定位按钮
            settings.setMyLocationButtonEnabled(true);
            aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase.

            MyLocationStyle myLocationStyle = new MyLocationStyle();
            //初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);
            // 连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（
            // 1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
            myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
            // 连续定位、且将视角移动到地图中心点，定位蓝点跟随设备移动。
            myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
            myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色
            myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW_NO_CENTER);
            aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        }

    }


    //定位
    private void location() {
        mLocationClient = new AMapLocationClient(context.getApplicationContext());
        mLocationClient.setLocationListener(this);
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        mLocationOption.setNeedAddress(true);
        mLocationOption.setOnceLocation(true);
//        mLocationOption.setMockEnable(false);
//        mLocationOption.setInterval(2000);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
        if (null != mLocationClient) {
            mLocationClient.onDestroy();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    public void onSaveInstanceState(Bundle outState) {
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            int code = aMapLocation.getErrorCode();
            String msg = aMapLocation.getErrorInfo();
            if (code == 0) {
                //定位成功回调信息，设置相关消息
//                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见官方定位类型表
//                aMapLocation.getLatitude();//获取纬度
//                aMapLocation.getLongitude();//获取经度
//                aMapLocation.getAccuracy();//获取精度信息
//                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
//                aMapLocation.getCountry();//国家信息
//                aMapLocation.getProvince();//省信息
//                aMapLocation.getCity();//城市信息
//                aMapLocation.getDistrict();//城区信息
//                aMapLocation.getStreet();//街道信息
//                aMapLocation.getStreetNum();//街道门牌号信息
//                aMapLocation.getCityCode();//城市编码
//                aMapLocation.getAdCode();//地区编码
                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置

                //点击定位按钮 能够将地图的中心移动到定位点
                mListener.onLocationChanged(aMapLocation);

                double latitude = aMapLocation.getLatitude();//获取纬度
                double longitude = aMapLocation.getLongitude();//获取经度
                DPoint mPoint = new DPoint(latitude, longitude);
                App.getInstance().setMyDPoint(mPoint);


                if (isFirstLoc) {
                    //设置缩放级别
                    aMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                    //将地图移动到定位点
                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
                    //获取定位信息
                    StringBuilder builder;
                    builder = new StringBuilder()
                            .append(aMapLocation.getCountry())
                            .append(aMapLocation.getProvince())
                            .append(aMapLocation.getCity())
                            .append(aMapLocation.getDistrict())
                            .append(aMapLocation.getStreet())
                            .append(aMapLocation.getStreetNum());
                    isFirstLoc = false;
                    mPresenter.log(builder.toString());
                }


            } else {
                mPresenter.log(context.getString(R.string.location_fail) + " code=" + code + " info=" + msg);
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        doMap();
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
        mLocationClient = null;
    }


//    //通过经纬度定位并标注
//    private void doMarker(double latitude, double longitude, String title) {
//        LatLng latLng = new LatLng(latitude, longitude);
//        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 19));
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(latLng);
//        markerOptions.title(title);
//        markerOptions.visible(true);
//        aMap.addMarker(markerOptions);
//    }

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

    //跳转高德地图
    private void goToAMap(String lat, String lon, String address) {
        if (ApkUtil.checkApkExist(context, "com.autonavi.minimap")) {
            StringBuilder builder;
            builder = new StringBuilder("androidamap://route?sourceApplication=").append("amap")
                    .append("&dlat=").append(lat)
                    .append("&dlon=").append(lon)
                    .append("&dname=").append(address)
                    .append("&dev=").append(0)
                    .append("&t=").append(0);
            mPresenter.goAMap(builder.toString());
        } else {
            mPresenter.toast(context.getString(R.string.not_installed_amap));
        }
    }

    @Override
    protected void initData() {
        super.initData();
        isOnce = false;
    }

    private boolean isOnce;

    public void setMatchTeam(@NonNull MatchTeam matchTeam) {
        if (!isOnce) return;
        isOnce = true;
        Store store = matchTeam.getStore();
        if (store != null) {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(new LatLng(store.getLat(), store.getLng()));
            markerOption.draggable(false);//设置Marker可拖动
            markerOption.title(store.getName());
//            View v = activity.getLayoutInflater().inflate(R.layout.layout_map_marker, null);
//            ImageView img = v.findViewById(R.id.img_store_logo);
//            G.img(context, store.getLogoImage().getUrl(), img);
//            markerOption.icon(BitmapDescriptorFactory.fromView(img));
            aMap.addMarker(markerOption);
        }
    }


}
