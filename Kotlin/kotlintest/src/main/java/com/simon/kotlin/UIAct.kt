package com.simon.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.simon.util.WaitDialog
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/19 11:04
 */
class UIAct:AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
        showDialog()
    }

    /**
     * 初始化UI
     */
    private fun initUI() {

        verticalLayout {
            lparams {

                width = matchParent
                height = matchParent
                backgroundColor = Color.WHITE
                topPadding = dip(50)
                leftPadding = dip(45)
            }

            button("hello world"){
                onClick {
                    text = "你好"
                    toast(text)
                }
            }

            editText {

                hint = "请输入您的姓名"
                hintTextColor = Color.BLACK
                textSize = 24f
                inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD

            }.lparams {
                width = matchParent
                leftMargin = dip(30)
                topMargin = dip(30)
            }

        }



    }




    private fun showDialog(){
        var waitDialog:WaitDialog = WaitDialog(this@UIAct).Builder(10000, 1000)
        waitDialog.show()
    }

}

























































