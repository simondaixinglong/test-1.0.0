package com.simon.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.simon.R
import kotlinx.android.synthetic.main.kact_one.*

class KActOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kact_one)


        tvName.setOnTouchListener(View.OnTouchListener { view, motionEvent -> false })


        tvName.setOnClickListener(View.OnClickListener {

        })

        tvName.setOnClickListener {
            tvName.text = "aaa"
        }

        tvName.setOnClickListener { view -> tvName.text = "aaa" }


        tvName.setOnTouchListener(View.OnTouchListener { view, motionEvent -> false })


        //onTouch -> onTouchEvent -> onClick

    }


//    fun strFromatTest(){
//
//        var year = 2017
//        var month = 10
//        var day = 1
//
//        var str  = String.format("%d %d %d")
//
//    }




}
