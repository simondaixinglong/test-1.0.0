package com.simon.JSHtml;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.simon.R;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/18 14:34
 */
public class JSHtmlAct extends AppCompatActivity {


    private WebView showWeb;
    private String a;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_js);

        showWeb = (WebView) findViewById(R.id.showWeb);

//        showWeb.loadUrl("http://192.168.44.226:3001/view/settixianmima.html");
//        showWeb.getSettings().setJavaScriptEnabled(true);
//        showWeb.addJavascriptInterface(new MzlcJS(), "MzlcJS");

        WebSettings webSettings = showWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        showWeb.setWebChromeClient(new WebChromeClient());

//        showWeb.loadUrl("file:///android_asset/test.html");


        a = "bafd";
        Toast.makeText(this, a, Toast.LENGTH_SHORT).show();


        WebViewClient webViewClient = new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                showWeb.loadUrl("javascript:sendMsg('" + a + "')");

            }
        };

        showWeb.setWebViewClient(webViewClient);
//        showWeb.loadUrl("http://192.168.44.226:3001/view/settixianmima.html");
//        showWeb.loadUrl("https://pdfobject.com/examples/pdfjs-forced.html");
//        showWeb.loadUrl("http://192.168.47.210:3000/view/019/web/viewer.html");
        showWeb.loadUrl("http://hgliangtest.oss-cn-shanghai.aliyuncs.com/product_file/690901.html");

    }


    public void sendMsg(View view) {
//        String a = "bafd";
//        showWeb.loadUrl("javascript:showAndroid('" + a + "')");
        showWeb.loadUrl("javascript:sendMsg('" + a + "')");
    }

    public class MzlcJS {

        @JavascriptInterface
        public void sendMsg(String url, String msg) {
        }

        @JavascriptInterface
        public void getMsg(String msg) {
            Toast.makeText(JSHtmlAct.this, msg, Toast.LENGTH_LONG).show();
        }
    }


}
