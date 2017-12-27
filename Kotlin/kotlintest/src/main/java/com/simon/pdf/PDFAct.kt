package com.simon.pdf

import android.Manifest
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.barteksc.pdfviewer.listener.OnDrawListener
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.maizi.http.HttpType
import com.maizi.http.OkHttpUtils
import com.maizi.http.callback.FileCallback
import com.simon.Constant
import com.simon.R
import kotlinx.android.synthetic.main.act_pdf.*
import okhttp3.Call
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.io.File
import java.lang.Exception


/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/26 15:18
 */
class PDFAct : AppCompatActivity(), OnPageChangeListener, OnLoadCompleteListener, OnDrawListener {

    private val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_pdf)

//        displayFromAssets("HTTP.pdf")

        var file = File(Constant.BASE_FILE)
        if (!file.exists()) {
            file.mkdirs()
        }

        requestPermissions(permissions, 0)

        start.onClick {
            //            getPDFFromServer("http://hgliangtest.oss-cn-shanghai.aliyuncs.com/fts_file/03120171225165759000000037421367_692601.html.pdf")
            var file = File(Constant.BASE_FILE, "simon.pdf")
            if (file.exists()) {
                var uri = Uri.fromFile(file)
                displayFromUri(uri)
            }
        }
    }


    /**
     * 从网络下载pdf
     */
    private fun getPDFFromServer(path: String) {

        OkHttpUtils.get().url(path).invokeType(HttpType.SERVER_ONLY).build().execute(object : FileCallback(Constant.BASE_FILE, "simon.pdf") {
            override fun onError(msg: String?, call: Call?, e: Exception?, id: Int) {

            }

            override fun onResponse(response: File?, id: Int) {
            }

            override fun inProgress(progress: Float, total: Long, id: Int) {
//                super.inProgress(progress, total, id)

//                if ((100 * progress).toInt() == 100) {
//                    var file = File(Constant.BASE_FILE + "/simon.pdf")
//                    if (file.exists()) {
//                        displayFromUri(file)
//                    }
//                }
            }


        })
    }

    private fun displayFromAssets(assetFileName: String) {
        pdfView.fromAsset(assetFileName)   //设置pdf文件地址
                .defaultPage(1)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
//                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
//                .swipeVertical(false)  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻页
                //                 .pages()  //把 5 过滤掉
                .load()
    }


    private fun displayFromFile(file: File) {
        pdfView.fromFile(file)   //设置pdf文件地址
                .defaultPage(1)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
//                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
//                .swipeVertical(false)  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻
                // .pages( 2 ，5  )  //把2  5 过滤掉
                .load()
    }

    private fun displayFromUri(uri: Uri) {
        pdfView.fromUri(uri)   //设置pdf文件地址
                .defaultPage(1)         //设置默认显示第1页
                .onPageChange(this)     //设置翻页监听
                .onLoad(this)           //设置加载监听
                .onDraw(this)            //绘图监听
//                .showMinimap(false)     //pdf放大的时候，是否在屏幕的右上角生成小地图
//                .swipeVertical(false)  //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .enableSwipe(true)   //是否允许翻页，默认是允许翻
                // .pages( 2 ，5  )  //把2  5 过滤掉
                .load()
    }


    /**
     * 翻页回调
     * @param page
     * @param pageCount
     */
    override fun onPageChanged(page: Int, pageCount: Int) {
        Toast.makeText(this@PDFAct, "page= $page pageCount= $pageCount", Toast.LENGTH_SHORT).show()
    }


    override fun loadComplete(nbPages: Int) {

    }

    override fun onLayerDrawn(canvas: Canvas?, pageWidth: Float, pageHeight: Float, displayedPage: Int) {
    }

}