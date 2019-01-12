package com.osmeet.os.model.net.service;

import com.osmeet.os.app.bean.Comment;
import com.osmeet.os.model.net.utils.Urls;
import com.osmeet.os.model.net.utils.box.Box;
import com.osmeet.os.model.net.utils.box.CommentCreateBody;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public interface CommentService {

    @POST(Urls.comment)
    Observable<Box<String>> comment(
            @Body CommentCreateBody body);

    @GET(Urls.comment_getUserCreditInfo)
    Observable<Box<Comment>> comment_getUserCreditInfo(
            @Query("userId")String userId);
}
