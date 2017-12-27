package com.simon;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HashMap<String, String> map = new HashMap<>();

//        OkHttpUtils.get().url("https://101.37.99.110:443").build().execute(new StringCallback() {
//            @Override
//            public void onError(String msg, Call call, Exception e, int id) {
//
//            }
//
//            @Override
//            public void onResponse(String response, int id) {
//
//            }
//        });

        requestPermissions(permissions, 0);


//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(10000, TimeUnit.MILLISECONDS)
//                .sslSocketFactory()



    }
}
