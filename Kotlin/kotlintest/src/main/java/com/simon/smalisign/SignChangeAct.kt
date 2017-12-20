package com.simon.smalisign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.simon.R
import kotlinx.android.synthetic.main.act_sign.*

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/12 09:28
 */
class SignChangeAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_sign)
//        Toast.makeText(this, BuildConfig.APP_HOST, Toast.LENGTH_SHORT).show()

        var images = arrayListOf("http://img1.imgtn.bdimg.com/it/u=3115688238,3051384815&fm=27&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=1811457400,1412920344&fm=27&gp=0.jpg",
                "http://img3.imgtn.bdimg.com/it/u=3896296464,4273750789&fm=27&gp=0.jpg")



        showView.initData(indicatorView, images)
        showView.currentItem = images.size * 50
        showView.setAutoPlay(true)

        showView.playLoop()
    }

}