package com.simon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

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




//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(10000, TimeUnit.MILLISECONDS)
//                .sslSocketFactory()



    }
}
