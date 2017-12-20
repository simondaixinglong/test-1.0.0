package com.maizi;


import com.maizi.http.OkHttpUtils;
import com.maizi.http.cookie.CookieJarImpl;
import com.maizi.http.cookie.store.MemoryCookieStore;
import com.maizi.http.https.HttpsUtils;
import com.maizi.http.interceptor.LoggerInterceptor;
import com.maizi.util.JNIUtil;

import org.litepal.LitePalApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okio.Buffer;

/**
 * Created by daixinglong on 2017/5/11.
 */

public class MyApplication extends LitePalApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpClient();
    }

    private void initOkHttpClient() {
//        ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
        HttpsUtils.SSLParams sslParams = null;
        try {
//            sslParams = HttpsUtils.getSslSocketFactory(getAssets().open("client.bks"), "123456", this.getAssets().open("ca.crt"));
            sslParams = HttpsUtils.getSslSocketFactory(getAssets().open("client.bks"), JNIUtil.getEncryptPassword(), new Buffer().writeUtf8(JNIUtil.getCrt()).inputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        CookieJarImpl cookieJar1 = new CookieJarImpl(new MemoryCookieStore());
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))
                .cookieJar(cookieJar1)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }
}
