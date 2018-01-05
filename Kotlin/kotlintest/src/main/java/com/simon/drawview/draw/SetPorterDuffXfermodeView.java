package com.simon.drawview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.simon.R;
import com.simon.util.AppUtils;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/4 15:30
 */

public class SetPorterDuffXfermodeView extends View {

    private Paint mPaint;
    private float cx, cy, screenW, screenH;
    private Bitmap srcBitmap, desBitmap;
    private PorterDuffXfermode porterDuffXfermode;


    public SetPorterDuffXfermodeView(Context context) {
        this(context, null);
    }

    public SetPorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetPorterDuffXfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParams(context, attrs, defStyleAttr);
    }

    private void initParams(Context context, AttributeSet attrs, int defStyleAttr) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog1);
        desBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog2);

        screenW = AppUtils.getScreenMetrics(context).widthPixels;
        screenH = AppUtils.getScreenMetrics(context).heightPixels;
        cx = screenW / 2 - srcBitmap.getWidth() / 2;
        cy = screenH / 2 - srcBitmap.getHeight() / 2;

//        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
//        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);


//        //将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）
//        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
//
//        //先绘制目标图
//        canvas.drawBitmap(desBitmap, cx, cy, mPaint);
//
//        //设置混合模式
//        mPaint.setXfermode(porterDuffXfermode);
//
//        //再绘制源图
//        canvas.drawBitmap(srcBitmap, cx, cy, mPaint);
//
//        //还原混合模式
//        mPaint.setXfermode(null);
//
//        //还原画布
//        canvas.restoreToCount(sc);


//        //将操作保存到新的图层
//        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);
//
//        //先绘制目标图
//        canvas.drawColor(0xFF8f66DA);
//
//        //设置混合模式
//        mPaint.setXfermode(porterDuffXfermode);
//
//        canvas.drawBitmap(srcBitmap, cx, cy, mPaint);
//
//        //还原混合模式
//        mPaint.setXfermode(null);
//
//        //还原画布
//        canvas.restoreToCount(sc);


        //将操作保存到新的图层
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        //先绘制目标图
        //绘制一个带透明度的颜色
        canvas.drawColor(0xcc1c093e);
        //设置混合模式
        mPaint.setXfermode(porterDuffXfermode);

        //绘制源图
        canvas.drawBitmap(srcBitmap, cx, cy, mPaint);

        //还原混合模式
        mPaint.setXfermode(null);

        //还原画布
        canvas.restoreToCount(sc);

    }
}





























