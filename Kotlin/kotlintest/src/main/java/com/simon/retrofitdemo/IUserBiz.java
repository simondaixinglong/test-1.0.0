package com.simon.retrofitdemo;

import com.simon.rxjava.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/13 11:22
 */

public interface IUserBiz {

    /**
     * http://192.168.31.242:8080/springmvc_users/user/users
     *
     * @return
     * @GET中所填写的value和baseUrl组成完整的路径
     */
    @GET("users")
    Call<List<String>> getUser();


    /**
     * //用于访问zhy的信息
     * http://192.168.1.102:8080/springmvc_users/user/zhy
     * //用于访问lmj的信息
     * http://192.168.1.102:8080/springmvc_users/user/lmj
     *
     * @param username
     * @return
     */
    @GET("{username}")
    Call<String> getUserInfo(@Path("username") String username);


    /**
     * http://baseurl/users?sortby=username
     * http://baseurl/users?sortby=id
     *
     * @param sort
     * @return
     */
    @GET("users")
    Call<String> getUserByQuery(@Query("sortBy") String sort);

    /**
     * http://baseurl/users?sortby=username
     * http://baseurl/users?sortby=id
     * 另一种写法
     *
     * @param sort
     * @return
     */
    @GET("users?sortBy={sort}")
    Call<String> getUserByQuery1(@Path("sort") String sort);


    /**
     * POST请求体的方式向服务器传入json字符串@Body
     *
     * @param student
     * @return
     */
    @POST("add")
    Call<String> postUser(@Body Student student);


    /**
     * 表单的方式传递键值对@FormUrlEncoded
     * 通过@POST指明url，添加FormUrlEncoded，然后通过@Field添加参数即可。
     *
     * @param username
     * @param pd
     * @return
     */
    @POST("login")
    @FormUrlEncoded
    Call<String> keyValue(@Field("username") String username, @Field("password") String pd);

}






















