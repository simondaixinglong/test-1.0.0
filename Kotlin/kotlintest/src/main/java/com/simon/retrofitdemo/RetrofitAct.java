package com.simon.retrofitdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.simon.rxjava.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/13 11:17
 */

public class RetrofitAct extends AppCompatActivity {

    private Retrofit retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();
    }


    /**
     * GET方法
     */
    private void getUsers() {

        Call<List<String>> user = retrofit.create(IUserBiz.class).getUser();
        user.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

    }


    /**
     * 动态的url访问@PATH
     */
    private void getUserInfo() {
        Call<String> simon = retrofit.create(IUserBiz.class).getUserInfo("simon");
        simon.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


    /**
     * 条件查询用户
     */
    private void getQuertUser() {

        retrofit.create(IUserBiz.class).getUserByQuery("simon");
        retrofit.create(IUserBiz.class).getUserByQuery1("simon");

    }


    /**
     * POST请求体的方式向服务器传入json字符串@Body
     */
    private void postJson() {
        retrofit.create(IUserBiz.class).postUser(new Student("simon", new ArrayList<String>()));
    }


    /**
     * 表单的方式传递键值对@FormUrlEncoded
     */
    private void keyValue(){
        retrofit.create(IUserBiz.class).keyValue("simon", "123456");
    }

}











































