package com.simon.JSHtml

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.simon.R
import kotlinx.android.synthetic.main.act_js.*

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/18 13:46
 */
class JSAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_js)
        setContent()


    }


    /**
     * 设置布局
     */
    private fun setContent() {


//        showWeb.loadUrl("http://192.168.44.226:3001/view/settixianmima.html")
//        showWeb.settings.javaScriptEnabled = true
//        showWeb.addJavascriptInterface(MzlcJS::class.java, "MzlcJS")
//
//        showWeb.loadUrl("javascript:sendMsg('bfdab')")

//        webview.loadData(customHtml, "text/html", "UTF-8");

        var htmlStr = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <script>\n" +
                "        function showSelf() {\n" +
                "            alert(\"我来自网页\")\n" +
                "        }\n" +
                "\n" +
                "        function showAndroid(str) {\n" +
                "            alert(str)\n" +
                "        }\n" +
                "\n" +
                "        //调用android程序\n" +
                "         function callAndroid() {\n" +
                "            Android.show('来自网页的我');\n" +
                "        }\n" +
                "\n" +
                "    </script>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<input type=\"button\" value=\"我是网页上按钮\" onclick=\"showSelf()\">\n" +
                "\n" +
                "<input type=\"button\" value=\"调用原生程序\" onclick=\"callAndroid()\">\n" +
                "</body>\n" +
                "</html>"

        showWeb.loadData(htmlStr, "text/html", "UTF-8")
    }


    inner class MzlcJS {

        fun sendMsg(url: String, formatData: String) {}

        fun getMsg(data: String) {
            Toast.makeText(this@JSAct, data, Toast.LENGTH_SHORT).show()
        }

    }


}