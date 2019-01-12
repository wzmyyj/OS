package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface FileService {

    @GET(Urls.file_download)
    Observable<ResponseBody> file_download(
            @Query("path") String path);

    @GET(Urls.file_fileSetExamine)
    Observable<Box<String>> file_fileSetExamine(
            @Query("fileId") String fileId,
            @Query("examineStatus") int examineStatus);


    @GET(Urls.file_getFileById)
    Observable<Box<String>> file_getFileById(
            @Query("fileId") String fileId);


    @GET(Urls.file_ref)
    Observable<ResponseBody> file_ref(
            @Query("path") String path);

    @GET(Urls.file_refById)
    Observable<ResponseBody> file_refById(
            @Query("id") String id);

    @GET(Urls.file_refBySize)
    Observable<ResponseBody> file_refBySize(
            @Query("id") String id,
            @Query("size") int size);

    @Multipart
    @POST(Urls.file_upload)
    Observable<Box<FileInfo>> file_upload(
            @Part MultipartBody.Part part);

    @Multipart
    @POST(Urls.file_uploadList)
    Observable<Box<List<FileInfo>>> file_uploadList(
            @Part List<MultipartBody.Part> partList);

}
