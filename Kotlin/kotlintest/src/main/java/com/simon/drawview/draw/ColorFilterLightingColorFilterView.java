package com.simon.drawview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.simon.R;
import com.simon.util.AppUtils;

/**
 * Description:     LightingColorFilter (int mul, int add)
 * mul全称是colorMultiply意为色彩倍增，而add全称是colorAdd意为色彩添加，
 * 这两个值都是16进制的色彩值0xAARRGGBB
 * 当LightingColorFilter(0xFFFFFFFF, 0x00000000)的时候原图是不会有任何改变的，如果我们想增加红色的值，
 * 那么LightingColorFilter(0xFFFFFFFF, 0x00XX0000)就好，其中XX取值为00至FF
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/4 14:33
 */

public class ColorFilterLightingColorFilterView extends View {

    private Paint mPaint;
    private Context mCxt;
    private Bitmap mBitmap;
    private float cx, cy;
    private boolean isCilick;

    public ColorFilterLightingColorFilterView(Context context) {
        this(context, null);
    }

    public ColorFilterLightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterLightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context, attrs, defStyleAttr);
    }

    private void initPaint(Context context, AttributeSet attrs, int defStyleAttr) {

//

        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dog1);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.argb(255, 255, 128, 103));
        mPaint.setStyle(Paint.Style.FILL);
        mCxt = context;

        cx = AppUtils.getScreenMetrics(mCxt).widthPixels / 2 - mBitmap.getWidth() / 2;
        cy = AppUtils.getScreenMetrics(mCxt).heightPixels / 2 - mBitmap.getHeight() / 2;

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isCilick) {
                    mPaint.setColorFilter(null);
                    isCilick = false;

                } else {
                    isCilick = true;
                    mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
                }

                invalidate();
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, cx, cy, mPaint);

    }
}















