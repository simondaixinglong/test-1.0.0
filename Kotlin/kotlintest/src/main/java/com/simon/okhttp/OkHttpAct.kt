package com.simon.okhttp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.maizi.http.OkHttpUtils
import com.maizi.http.callback.StringCallback
import com.simon.R
import kotlinx.android.synthetic.main.act_okhttp.*
import okhttp3.Call
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.lang.Exception

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/24 16:19
 */
class OkHttpAct : AppCompatActivity() {

    var map = HashMap<String, Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_okhttp)


        map.put("mobile", "18202169937")



        btnOkHttp.onClick {

            //            OkHttpUtils.post().url("https://101.37.99.110/v1/user/checkUserRegister").build().execute(object : StringCallback() {
//                override fun onError(msg: String, call: Call, e: Exception, id: Int) {
//                    e.printStackTrace()
//                }
//
//                override fun onResponse(response: String, id: Int) {
//
//                }
//            })

            OkHttpUtils.post().content(JSON.toJSONString(map)).url("https://101.37.99.110/v1/user/checkUserRegister")
                    .build().execute(object : StringCallback() {
                override fun onError(msg: String?, call: Call?, e: Exception?, id: Int) {

                }

                override fun onResponse(response: String?, id: Int) {

                }

            })


        }


//        val map = HashMap<String, String>()
//        map.put("key", "value")
//
//        var map1 = mapOf("key" to "value", "key1" to "value")

    }
}