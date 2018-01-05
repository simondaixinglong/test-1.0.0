package com.simon.drawview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.simon.R;
import com.simon.util.AppUtils;

/**
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/4 14:33
 */

public class ColorFilterPorterDuffColorFilterView extends View {

    private Paint mPaint;
    private Context mCxt;
    private Bitmap mBitmap;
    private float cx, cy;
    private boolean isCilick;

    public ColorFilterPorterDuffColorFilterView(Context context) {
        this(context, null);
    }

    public ColorFilterPorterDuffColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterPorterDuffColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context, attrs, defStyleAttr);
    }

    private void initPaint(Context context, AttributeSet attrs, int defStyleAttr) {

//

        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dog1);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mCxt = context;

        cx = AppUtils.getScreenMetrics(mCxt).widthPixels / 2 - mBitmap.getWidth() / 2;
        cy = AppUtils.getScreenMetrics(mCxt).heightPixels / 2 - mBitmap.getHeight() / 2;


        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, cx, cy, mPaint);

    }
}















