package com.simon.drawview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.simon.R;
import com.simon.util.AppUtils;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/4 14:33
 */

public class ColorFilterColorMatrixView extends View {

    private Paint mPaint;
    private Context mCxt;
    private Bitmap mBitmap;
    private float cx, cy;

    public ColorFilterColorMatrixView(Context context) {
        this(context, null);
    }

    public ColorFilterColorMatrixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterColorMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context, attrs, defStyleAttr);
    }

    private void initPaint(Context context, AttributeSet attrs, int defStyleAttr) {

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1, 0, 0, 0, 0,
//                0, 1, 0, 0, 0,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,
//        });

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.5F, 0, 0, 0, 0,
//                0, 0.5F, 0, 0, 0,
//                0, 0, 0.5F, 0, 0,
//                0, 0, 0, 1, 0,
//        });

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.33F, 0.59F, 0.11F, 0, 0,
//                0.33F, 0.59F, 0.11F, 0, 0,
//                0.33F, 0.59F, 0.11F, 0, 0,
//                0, 0, 0, 1, 0,
//        });


//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                -1, 0, 0, 1, 1,
//                0, -1, 0, 1, 1,
//                0, 0, -1, 1, 1,
//                0, 0, 0, 1, 0,
//        });

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0, 0, 1, 0, 0,
//                0, 1, 0, 0, 0,
//                1, 0, 0, 0, 0,
//                0, 0, 0, 1, 0,
//        });

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0.393F, 0.769F, 0.189F, 0, 0,
//                0.349F, 0.686F, 0.168F, 0, 0,
//                0.272F, 0.534F, 0.131F, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.5F, 1.5F, 1.5F, 0, -1,
                1.5F, 1.5F, 1.5F, 0, -1,
                1.5F, 1.5F, 1.5F, 0, -1,
                0, 0, 0, 1, 0,
        });

        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dog1);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.argb(255, 255, 128, 103));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        mCxt = context;

        cx = AppUtils.getScreenMetrics(mCxt).widthPixels / 2 - mBitmap.getWidth() / 2;
        cy = AppUtils.getScreenMetrics(mCxt).heightPixels / 2 - mBitmap.getHeight() / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//
//        canvas.drawCircle(AppUtils.getScreenMetrics(mCxt).widthPixels / 2,
//                AppUtils.getScreenMetrics(mCxt).heightPixels / 2, 200, mPaint);

        canvas.drawBitmap(mBitmap, cx, cy, mPaint);

    }
}















