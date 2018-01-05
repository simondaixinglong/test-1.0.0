package com.simon.drawview

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.simon.R

class DrawAct : AppCompatActivity() {


    var doubles = doubleArrayOf(23.54, 245.54, 545.33, 245.66)
    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_draw)
//        addContentView()

//        getSum()
//
//        rateView2.setRate(10, 90, 100)
////        Thread(rateView2).start()
//
//
//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                rateView2.setRate(progress, 100 - progress, 100)
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//            }

//        })


//        val aX = tvA.translationX
//        val aWidth = tvA.width
//
//
//        val bX = tvB.translationX
//        val bWidth = tvB.width
//
//
//        var aAnimator = ObjectAnimator.ofFloat(tvA, "translationX", 0f, -500f)
//        var bAnimator = ObjectAnimator.ofFloat(tvB, "translationX", 100f, -200f)
//
//        var set = AnimatorSet()
//        set.play(bAnimator).after(aAnimator)
//        set.duration = 1000
//        set.start()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            requestShowKeyboardShortcuts()
        }

    }


    private fun getSum() {

        var count = 0.00
        (0 until doubles.size).asSequence().filter { doubles[it] > 30 }.forEach { count += doubles[it] }


        var mapA = mapOf("a" to "1", "b" to "2")

        mapA["a"]
        mapA.get("a")
        val keys = mapA.keys
        val size = mapA.size

    }
}
