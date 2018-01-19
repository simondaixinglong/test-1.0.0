package com.simon.drawview.draw

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.simon.R
import kotlinx.android.synthetic.main.act_draw_test.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/5 16:21
 */
class TwoAct :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_draw_test)


        startAct.onClick {
            startActivity(Intent(this@TwoAct, ThreeAct::class.java))
        }

    }

}