package com.osmeet.os.model.net;

import android.text.TextUtils;

import com.osmeet.os.app.bean.RyToken;
import com.osmeet.os.app.bean.Token;
import com.osmeet.os.app.bean.User;
import com.osmeet.os.app.bean.WechatInfo;
import com.osmeet.os.app.utils.SubscribeUtil;
import com.osmeet.os.model.net.service.FileService;
import com.osmeet.os.model.net.service.UserService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.ConditionBody;
import com.osmeet.os.model.net.utils.box.ListContent;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * 用户相关。
 * 建议用模板生成代码。
 */

public class UserModel {

    private UserService getService() {
        return ReOk.bind().create(UserService.class);
    }

    public void user(Observer<Box<User>> observer) {
        Observable<Box<User>> observable = getService().user();
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_bindWechat(Observer<Box<User>> observer, WechatInfo info) {
        Observable<Box<User>> observable = getService().user_bindWechat(info);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_consummateInfo(Observer<Box<User>> observer, User user) {
        Observable<Box<User>> observable = getService().user_consummateInfo(user);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_consummateInfoNoPass(Observer<Box<User>> observer, User user) {
        Observable<Box<User>> observable = getService().user_consummateInfoNoPass(user);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_existsByPhone(Observer<Box<Boolean>> observer, String zoneCode, String phone) {
        Observable<Box<Boolean>> observable = getService().user_existsByPhone(zoneCode, phone);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_findByCondition(Observer<Box<User>> observer, User user) {
        Observable<Box<User>> observable = getService().user_findByCondition(user);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_getRyToken(Observer<Box<RyToken>> observer) {
        Observable<Box<RyToken>> observable = getService().user_getRyToken();
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_getUserList(Observer<Box<List<User>>> observer, ConditionBody body) {
        Observable<Box<List<User>>> observable = getService().user_getUserList(body);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_info(Observer<Box<User>> observer, String userId) {
        Observable<Box<User>> observable = getService().user_info(userId);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_login(Observer<Box<Token>> observer, String zoneCode, String account, String password) {
        Observable<Box<Token>> observable = getService().user_login(zoneCode, account, password);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_loginByPhone(Observer<Box<Token>> observer, String zoneCode, String phone, String code) {
        Observable<Box<Token>> observable = getService().user_loginByPhone(zoneCode, phone, code);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_loginByThirdParty(Observer<Box<Token>> observer, String id, int platform) {
        Observable<Box<Token>> observable = getService().user_loginByThirdParty(id, platform);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_refreshToken(Observer<Box<Token>> observer, String refreshToken) {
        Observable<Box<Token>> observable = getService().user_refreshToken(refreshToken);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_registerByPhone(Observer<Box<Token>> observer, String zoneCode, String phone, String code) {
        Observable<Box<Token>> observable = getService().user_registerByPhone(zoneCode, phone, code);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_registerByPhoneAndPass(Observer<Box<Token>> observer, String zoneCode, String phone, String code, String password) {
        Observable<Box<Token>> observable = getService().user_registerByPhoneAndPass(zoneCode, phone, code, password);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_registerByWechat(Observer<Box<Token>> observer, String zoneCode, String phone, String code, WechatInfo info) {
        Observable<Box<Token>> observable = getService().user_registerByWechat(zoneCode, phone, code, info);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_searchUser(Observer<Box<ListContent<User>>> observer, String searchInfo, int pageNum, int pageSize) {
        Observable<Box<ListContent<User>>> observable = getService().user_searchUser(searchInfo, pageNum, pageSize);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_sendCode(Observer<Box<String>> observer, String zoneCode, String phone) {
        Observable<Box<String>> observable = getService().user_sendCode(zoneCode, phone);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_sendCode0000(Observer<Box<String>> observer, String zoneCode, String phone) {
        Observable<Box<String>> observable = getService().user_sendCode0000(zoneCode, phone);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_unbindWechat(Observer<Box<User>> observer) {
        Observable<Box<User>> observable = getService().user_unbindWechat();
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_update(Observer<Box<String>> observer, User user) {
        Observable<Box<String>> observable = getService().user_update(user);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_updateAddress(Observer<Box<String>> observer, String lng, String lat) {
        Observable<Box<String>> observable = getService().user_updateAddress(lng, lat);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_updateAvatar(Observer<Box<String>> observer, String path) {
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "image.jpg", requestFile);
        Observable<Box<String>> observable = ReOk.bind().create(FileService.class).file_upload(filePart)
                .map(box -> getService().user_updateAvatar(box.getData().getId()).blockingLast());
        SubscribeUtil.io2main(observable, observer);
    }

//    public void user_updateAvatar(Observer<Box<String>> observer, String fileId) {
//        Observable<Box<String>> observable = getService().user_updateAvatar(fileId);
//        SubscribeUtil.io2main(observable, observer);
//    }

    public void user_updateDisplayImages(Observer<Box<String>> observer, final String[] fileIds, String[] paths) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        final boolean[] isUpload = new boolean[6];
        boolean isPathsAllEmpty = true;
        for (int i = 0; i < 6; i++) {
            if (TextUtils.isEmpty(paths[i])) {
                isUpload[i] = false;
                continue;
            } else {
                isUpload[i] = true;
            }
            isPathsAllEmpty = false;
            File file = new File(paths[i]);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            builder.addFormDataPart("files", "image.jpg", requestFile);
        }
        if (isPathsAllEmpty) {
            Observable<Box<String>> observable = getService().user_updateDisplayImages(fIds(fileIds));
            SubscribeUtil.io2main(observable, observer);
            return;
        }
        List<MultipartBody.Part> parts = builder.build().parts();
        Observable<Box<String>> observable = ReOk.bind().create(FileService.class)
                .file_uploadList(parts).map(box -> {
                    for (int i = 0, j = 0; i < 6; i++) {
                        if (isUpload[i] && j < box.getData().size()) {
                            fileIds[i] = box.getData().get(j).getId();
                            j++;
                        }
                    }
                    return getService().user_updateDisplayImages(fIds(fileIds)).blockingLast();
                });
        SubscribeUtil.io2main(observable, observer);
    }


    private String fIds(String[] fileIds) {
        StringBuilder builder = new StringBuilder();
        for (String s : fileIds) {
            if (TextUtils.isEmpty(s)) continue;
            builder.append(s);
            builder.append(",");
        }
        int i = builder.lastIndexOf(",");
        if (i > 0)
            builder.deleteCharAt(i);
        String s = builder.toString();
        return TextUtils.isEmpty(s) ? "" : s;
    }
//    public void user_updateDisplayImages(Observer<Box<String>> observer, String fileIds) {
//        Observable<Box<String>> observable = getService().user_updateDisplayImages(fileIds);
//        SubscribeUtil.io2main(observable, observer);
//    }

    public void user_updatePassword(Observer<Box<String>> observer, String password) {
        Observable<Box<String>> observable = getService().user_updatePassword(password);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_updatePhone(Observer<Box<String>> observer, String zoneCode, String phone) {
        Observable<Box<String>> observable = getService().user_updatePhone(zoneCode, phone);
        SubscribeUtil.io2main(observable, observer);
    }

    public void user_validatePhoneAndCode(Observer<Box<String>> observer, String zoneCode, String phone, String code) {
        Observable<Box<String>> observable = getService().user_validatePhoneAndCode(zoneCode, phone, code);
        SubscribeUtil.io2main(observable, observer);
    }


}
