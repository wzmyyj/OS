package com.osmeet.os.app.tools;

import android.Manifest;
import android.app.Activity;
import android.support.annotation.NonNull;

import com.osmeet.os.app.other.GlideGalleryImageLoader;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.yanzhenjie.permission.AndPermission;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.tools.T;

/**
 * Created by wzm on 2018/4/26 0026.
 * 图片选择工具类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class GP {

    private static String provider;
    private static String filePath;
    private GalleryConfig galleryConfig;

    // "包名.FileProvider"
    public static void init(String p, String fp) {
        provider = p;
        filePath = fp;
    }

    private GP(GalleryConfig galleryConfig) {
        this.galleryConfig = galleryConfig;
    }


    @NonNull
    public static GP create(IHandlerCallBack iHandlerCallBack) {
        if (provider == null) {
            throw new IllegalStateException("please init provider");
        }
        if (iHandlerCallBack == null) {
            throw new IllegalStateException("iHandlerCallBack is null");
        }

        if (filePath == null) {
            filePath = "/GalleryPick/Image";
        }

        List<String> path = new ArrayList<>();
        //init galleryConfig
        GalleryConfig galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new GlideGalleryImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider(provider)   // provider(必填)
                .pathList(path)                         // 记录已选的图片
                .multiSelect(false)                      // 是否多选   默认：false
                .multiSelect(false, 3)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(9)                             // 配置多选时 的多选数量。    默认：9
                .crop(true)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(true, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(true)                     // 是否现实相机按钮  默认：false
                .isOpenCamera(false)                    // 是否直接打开相机
                .filePath(filePath)          // 图片存放路径
                .build();
        return new GP(galleryConfig);
    }

    public GP multiSelect(boolean multiSelect, int maxSize) {
        getConfigBuilder().multiSelect(multiSelect, maxSize);
        return this;
    }

    public GP crop(boolean isCrop) {
        getConfigBuilder().crop(isCrop);
        return this;
    }

    public GP isShowCamera(boolean isShowCamera) {
        getConfigBuilder().isShowCamera(isShowCamera);
        return this;
    }

    public GP isOpenCamera(boolean isOpenCamera) {
        getConfigBuilder().isOpenCamera(isOpenCamera);
        return this;
    }

    public GP filePath(String filePath) {
        getConfigBuilder().filePath(filePath);
        return this;
    }


    public GalleryConfig.Builder getConfigBuilder() {
        return galleryConfig.getBuilder();
    }


    public void open(Activity activity) {
        GalleryPick.getInstance().setGalleryConfig(this.galleryConfig).open(activity);
    }

    public void openWithPermission(final Activity activity) {
        AndPermission.with(activity)
                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(permissions -> this.open(activity))
                .onDenied(permissions -> T.s("No Permission"))
                .start();
    }

    public abstract static class CallBack implements IHandlerCallBack {

        @Override
        public void onStart() {

        }

//        @Override
//        public void onSuccess(List<String> photoList) {
//
//        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onFinish() {

        }

        @Override
        public void onError() {

        }
    }
}
