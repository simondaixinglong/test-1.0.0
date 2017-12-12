package com.simon.zhimaview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/14 14:10
 */

public class ZhimaView extends View {

    private static final String[] DEGREE = {"较差", "中等", "良好", "优秀", "极好"};

    private Paint roundPaint;//圆的画笔
    private Paint textPaint;
    private int outRoundWidth;//外圆的宽度
    private int innerRoundWidth;//内园的宽度
    private int radius;//圆的半径

    private int viewWidth;//view的宽度
    private int viewHeight;//view的高度
    private Context mCxt;
    private int startAngle, sweepAngle;


    public ZhimaView(Context context) {
        this(context, null);
    }

    public ZhimaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZhimaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParas(context);
    }


    /**
     * 初始化参数
     *
     * @param context
     */
    private void initParas(Context context) {
        this.mCxt = context;
        roundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        roundPaint.setStyle(Paint.Style.STROKE);
        roundPaint.setColor(0x00FFFF);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            viewWidth = width;
        } else {
            viewWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getResources().getDisplayMetrics());
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            viewHeight = height;
        } else {
            viewHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getResources().getDisplayMetrics());
        }

        radius = viewWidth / 4;
        innerRoundWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
        outRoundWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        startAngle = 160;
        sweepAngle = 220;

        setMeasuredDimension(viewWidth, viewHeight);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        canvas.drawColor(0xFFFF00FF);
        canvas.save();
        canvas.translate(viewWidth / 2, viewWidth / 2);

        //画出内外圆
        drawRound(canvas);

        drawLineAndText(canvas);

        canvas.restore();

    }


    /**
     * 画出内外圆
     *
     * @param canvas
     */
    private void drawRound(Canvas canvas) {

        roundPaint.setStrokeWidth(innerRoundWidth);
        roundPaint.setAlpha(0x40);
        RectF innerRect = new RectF(-radius, -radius, radius, radius);
        canvas.drawArc(innerRect, startAngle, sweepAngle, false, roundPaint);

        roundPaint.setStrokeWidth(outRoundWidth);
        int differ = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 11, getResources().getDisplayMetrics());
        RectF outRect = new RectF(-radius - differ, -radius - differ,
                radius + differ, radius + differ);
        canvas.drawArc(outRect, startAngle, sweepAngle, false, roundPaint);

    }


    /**
     * 画线和文字
     *
     * @param canvas
     */
    private void drawLineAndText(Canvas canvas) {

        float eachAngle = sweepAngle / 30;
        canvas.rotate(-270 + startAngle);

        for (int i = 0; i < 30; i++) {

            //刻度粗
            if (i % 6 == 0) {
                roundPaint.setStrokeWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                roundPaint.setAlpha(0x70);
//                canvas.drawLine(0, );
            }

        }

    }


}






















