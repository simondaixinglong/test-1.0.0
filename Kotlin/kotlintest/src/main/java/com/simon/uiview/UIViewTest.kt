package com.simon.uiview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Toast
import com.simon.R
import com.simon.uiview.adapter.AdapterViewFlipperAdapter
import kotlinx.android.synthetic.main.act_ui_view_test2.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.sdk25.coroutines.onValueChanged

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/6 09:28
 */
class UIViewTest : AppCompatActivity() {


    val imagesDog = mutableListOf(R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.act_ui_view_test)
        setContentView(R.layout.act_ui_view_test2)

        /******** quickContactBadge *******/
//        quickContactBadge.setMode(ContactsContract.QuickContact.MODE_SMALL)
//        quickContactBadge.assignContactFromPhone("1000", true)


        /******** chronometer2 *******/
//        chronometer2.format = "计时:%s"
//        chronometer2.base = SystemClock.elapsedRealtime()
//        chronometer2.start()

        /******* imageSwitcher ********/
        imageSwitcher.setFactory {
            val imageView = ImageView(this@UIViewTest)
            imageView.backgroundColor = Color.RED
            imageView.scaleType = ImageView.ScaleType.CENTER
//            imageView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            imageView
        }

        imageSwitcher.setImageResource(R.drawable.fg)
        imageSwitcher.setInAnimation(this, R.anim.simon_fade_in)
        imageSwitcher.setOutAnimation(this, R.anim.fade_out)


        /******* adapterViewFlipper ********/
        var adapter = AdapterViewFlipperAdapter(this)
        adapterViewFlipper.adapter = adapter
        adapter.images = imagesDog

        /******* stackView ********/
        stackView.adapter = adapter
        adapter.images = imagesDog

        /******* numberPicker ********/
        numberPicker.maxValue = 100
        numberPicker.minValue = 0
        numberPicker.value = 0
        numberPicker.setFormatter { value -> String.format("this is %d", value) }
        numberPicker.onValueChanged { _, oldVal, newVal ->
            run {
                Toast.makeText(this@UIViewTest, "oldVal is $oldVal, newVal is $newVal", Toast.LENGTH_SHORT).show()
            }
        }

        /******* textInputLayout ********/
//        textInputLayout.error = "bfdab"
        textInputLayout.hint = "bfdab"

    }
}