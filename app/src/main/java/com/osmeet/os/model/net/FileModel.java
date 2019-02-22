package com.osmeet.os.model.net;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.other.FileFactory;
import com.osmeet.os.base.model.BaseModel;
import com.osmeet.os.model.net.service.FileService;
import com.osmeet.os.model.net.utils.ReOk;
import com.osmeet.os.model.net.utils.box.Box;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class FileModel extends BaseModel{

    private FileService getService() {
        return ReOk.bind().create(FileService.class);
    }

    public void file_download(Observer<File> observer, String path, final String filepath) {
        Observable<File> observable = getService().file_download(path)
                .map(responseBody -> FileFactory.decodeStream(filepath, responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void file_ref(Observer<File> observer, String path, final String filepath) {
        Observable<File> observable = getService().file_ref(path)
                .map(responseBody -> FileFactory.decodeStream(filepath, responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void file_refById(Observer<File> observer, String id, final String filepath) {
        Observable<File> observable = getService().file_refById(id)
                .map(responseBody -> FileFactory.decodeStream(filepath, responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void file_refBySize(Observer<File> observer, String id, int size, final String filepath) {
        Observable<File> observable = getService().file_refBySize(id, size)
                .map(responseBody -> FileFactory.decodeStream(filepath, responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void bitmap_ref(Observer<Bitmap> observer, String path) {
        Observable<Bitmap> observable = getService().file_ref(path)
                .map(responseBody -> BitmapFactory.decodeStream(responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void bitmap_refById(Observer<Bitmap> observer, String id) {
        Observable<Bitmap> observable = getService().file_refById(id)
                .map(responseBody -> BitmapFactory.decodeStream(responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void bitmap_refBySize(Observer<Bitmap> observer, String id, int size) {
        Observable<Bitmap> observable = getService().file_refBySize(id, size)
                .map(responseBody -> BitmapFactory.decodeStream(responseBody.byteStream()));
        io2main(observable, observer);
    }

    public void file_fileSetExamine(Observer<Box<String>> observer, String fileId, int examineStatus) {
        Observable<Box<String>> observable = getService().file_fileSetExamine(fileId, examineStatus);
        io2main(observable, observer);
    }

    public void file_getFileById(Observer<Box<String>> observer, String fileId) {
        Observable<Box<String>> observable = getService().file_getFileById(fileId);
        io2main(observable, observer);
    }

    public void file_upload(Observer<Box<FileInfo>> observer, String path) {
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "image.jpg", requestFile);
        Observable<Box<FileInfo>> observable = getService().file_upload(filePart);
        io2main(observable, observer);
    }

    public void file_uploadList(Observer<Box<List<FileInfo>>> observer, List<String> paths) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        for (String path : paths) {
            File file = new File(path);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            builder.addFormDataPart("file", "image.jpg", requestFile);
        }
        List<MultipartBody.Part> parts = builder.build().parts();
        Observable<Box<List<FileInfo>>> observable = getService().file_uploadList(parts);
        io2main(observable, observer);
    }


}
