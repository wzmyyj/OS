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
    private GalleryConfig.Builder builder;

    // "包名.FileProvider"
    public static void init(String p, String fp) {
        provider = p;
        filePath = fp;
    }

    private GP() {
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
        GP gp = new GP();
        gp.builder = new GalleryConfig.Builder()
                .imageLoader(new GlideGalleryImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider(provider)   // provider(必填)
                .pathList(path)                         // 记录已选的图片
                .multiSelect(false)                      // 是否多选   默认：false
                .multiSelect(false, 3)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(9)                             // 配置多选时 的多选数量。    默认：9
                .crop(true)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(true, 1, 1, 5000, 5000)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(true)                     // 是否现实相机按钮  默认：false
                .isOpenCamera(false)                    // 是否直接打开相机
                .filePath(filePath);         // 图片存放路径

        return gp;
    }

    public GP multiSelect(boolean multiSelect, int maxSize) {
        this.builder.multiSelect(multiSelect, maxSize);
        return this;
    }

    public GP crop(boolean isCrop) {
        this.builder.crop(isCrop);
        return this;
    }

    public GP isShowCamera(boolean isShowCamera) {
        this.builder.isShowCamera(isShowCamera);
        return this;
    }

    public GP isOpenCamera(boolean isOpenCamera) {
        this.builder.isOpenCamera(isOpenCamera);
        return this;
    }

    public GP filePath(String filePath) {
        this.builder.filePath(filePath);
        return this;
    }


    public GalleryConfig.Builder getConfigBuilder() {
        return this.builder;
    }


    public void open(Activity activity) {
        GalleryPick.getInstance().setGalleryConfig(this.builder.build()).open(activity);
    }

    public void openWithPermission(final Activity activity) {
        AndPermission.with(activity)
                .permission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
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
