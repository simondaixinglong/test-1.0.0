package com.simon.uiview.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import org.jetbrains.anko.imageResource

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/7 16:20
 */
class AdapterViewFlipperAdapter(private val cxt: Context) : BaseAdapter() {

    var images: MutableList<Int> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var imageView = ImageView(cxt)
        imageView.imageResource = getItem(position)
        imageView.scaleType = ImageView.ScaleType.CENTER
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return imageView
    }

    override fun getItem(position: Int): Int = images[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = images.size

}