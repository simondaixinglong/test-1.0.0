package com.simon.smalisign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.simon.BuildConfig
import com.simon.R

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/12 09:28
 */
class SignChangeAct:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_sign)
        Toast.makeText(this, BuildConfig.APP_HOST, Toast.LENGTH_SHORT).show()
    }

}