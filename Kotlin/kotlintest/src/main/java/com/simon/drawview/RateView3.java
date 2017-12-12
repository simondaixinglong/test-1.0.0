package com.simon.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/11/20 18:26
 */

public class RateView3 extends View implements Runnable {


    private int bgArcColor = Color.parseColor("#F9CB27");
    private int rateArcColor = Color.parseColor("#EF5146");

    private Paint bgArcPaint;
    private Paint rateArcPPaint;

    private Paint rate1Paint;
    private Paint rate1TipPaint;
    private Paint ratePaint1;

    private Paint rate2Paint;
    private Paint rate2TipPaint;
    private Paint ratePaint2;

    private Paint linePaint;
    private float arcWidth = 10F;
    private float circleRadius = 40F;
    private int width = 0;
    private int height = 0;
    private int rateTextSize;
    private int tiTextSize;

    private int rate1, rate2;//占比
    private float arc1, arc2;//圆弧
    private float totalRate;//一圈总共多大
    private int r1, r2;
    private float a1, a2;
    private float angleRate;

    public RateView3(Context context) {
        this(context, null);
    }

    public RateView3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public RateView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParams(context, attrs, defStyleAttr);
    }

    private void initParams(Context context, AttributeSet attrs, int defStyleAttr) {
        bgArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bgArcPaint.setStyle(Paint.Style.STROKE);
        bgArcPaint.setColor(bgArcColor);
//        bgArcPaint.setStrokeCap(Paint.Cap.ROUND);


//        rateTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 32, getResources().getDisplayMetrics());
//        tiTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics());

        rateArcPPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rateArcPPaint.setStyle(Paint.Style.STROKE);
        rateArcPPaint.setColor(rateArcColor);
        rateArcPPaint.setStrokeCap(Paint.Cap.ROUND);

        rate1Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rate1Paint.setColor(bgArcColor);
//        rate1Paint.setTextSize(rateTextSize);
        rate1Paint.setTypeface(Typeface.DEFAULT_BOLD);

        ratePaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        ratePaint1.setColor(bgArcColor);
//        ratePaint1.setTextSize(tiTextSize);

        rate1TipPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rate1TipPaint.setColor(Color.parseColor("#616161"));
//        rate1TipPaint.setTextSize(tiTextSize);


        rate2Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rate2Paint.setColor(rateArcColor);
//        rate2Paint.setTextSize(rateTextSize);
        rate2Paint.setTypeface(Typeface.DEFAULT_BOLD);

        ratePaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        ratePaint2.setColor(rateArcColor);
//        ratePaint2.setTextSize(tiTextSize);

        rate2TipPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rate2TipPaint.setColor(Color.parseColor("#616161"));
//        rate2TipPaint.setTextSize(tiTextSize);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeWidth(1);
        linePaint.setColor(Color.parseColor("#DDDDDD"));

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int) (circleRadius * 2 + 100);
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(width, widthSize);
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int) (circleRadius * 2 + 60);
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, heightSize);
            }
        }


        circleRadius = (Math.min(width, height) - 100) / 2;
//        circleRadius = (height - 100) / 2;
        arcWidth = circleRadius / 3;

        rateTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, circleRadius / 10, getResources().getDisplayMetrics());
        tiTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, circleRadius / 20, getResources().getDisplayMetrics());


        rate1Paint.setTextSize(rateTextSize);
        rate2Paint.setTextSize(rateTextSize);
        ratePaint1.setTextSize(tiTextSize);
        rate1TipPaint.setTextSize(tiTextSize);
        ratePaint2.setTextSize(tiTextSize);
        rate2TipPaint.setTextSize(tiTextSize);

        bgArcPaint.setStrokeWidth(arcWidth);
        rateArcPPaint.setStrokeWidth(arcWidth);

        setMeasuredDimension(width, height);

    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        //画大圆弧
//        drawCircle(canvas);

        //画竖线
        drawLine(canvas);

        drawText(canvas, r1, r2);

//        canvas.rotate(-90);
        //画比例弧
        drawArc1(canvas, a2);

        drawArc2(canvas, a1);


    }


    /**
     * 画大圆弧
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(width / 2, height / 2, circleRadius, bgArcPaint);
    }


    /**
     * 画圆弧
     *
     * @param canvas
     */
    private void drawArc2(Canvas canvas, float ar2) {
        RectF rectF = new RectF(width / 2 - circleRadius, height / 2 - circleRadius, width / 2 + circleRadius, height / 2 + circleRadius);
        canvas.drawArc(rectF, arc2 - 90, ar2, false, bgArcPaint);
    }

    /**
     * 画圆弧
     *
     * @param canvas
     */
    private void drawArc1(Canvas canvas, float ar1) {
        RectF rectF = new RectF(width / 2 - circleRadius, height / 2 - circleRadius, width / 2 + circleRadius, height / 2 + circleRadius);
        canvas.drawArc(rectF, -90, ar1, false, rateArcPPaint);
    }


    /**
     * 画竖线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        float lineHeight = (circleRadius * 2 / 3);
        canvas.drawLine(width / 2, height / 2 - lineHeight / 2 + 20, width / 2, height / 2, linePaint);
    }

    /**
     * 画文字比例
     *
     * @param canvas
     */
    private void drawText(Canvas canvas, int rate1, int rate2) {


        float bigWidth = rate1Paint.measureText(rate1 + "");
        float littleWidth = rate1TipPaint.measureText("%");
        float tipWidth = rate1TipPaint.measureText("浮动收益");

        Rect rect = new Rect();
        rate1TipPaint.getTextBounds("浮动收益", 0, "浮动收益".length(), rect);

        canvas.drawText(rate1 + "", width / 2 - bigWidth - circleRadius / 5, height / 2, rate1Paint);
        canvas.drawText("%", width / 2 - littleWidth - circleRadius / 16, height / 2, ratePaint1);
        canvas.drawText("浮动收益", width / 2 - tipWidth - circleRadius / 16, height / 2 + circleRadius / 16 + rect.height(), rate1TipPaint);

        canvas.drawText(rate2 + "", width / 2 + circleRadius / 8, height / 2, rate2Paint);
        canvas.drawText("%", width / 2 + bigWidth + circleRadius / 7, height / 2, ratePaint2);
        canvas.drawText("固定收益", width / 2 + circleRadius / 16, height / 2 + circleRadius / 16 + rect.height(), rate2TipPaint);
    }


    public void setRate(int rate1, int rate2, int totalRate) {

        if (totalRate != rate1 + rate2)
            throw new IllegalArgumentException("总比例不能小于子比例~");

        this.totalRate = totalRate;
        this.rate1 = rate1;
        this.rate2 = rate2;
        this.arc1 = 360 * rate1 / this.totalRate;
        this.arc2 = 360 - arc1;
        this.angleRate = 360 / this.totalRate;

        if (rate1 <= rate2) {
            this.r2 = rate2 - rate1;
            this.a2 = arc2 - arc1;
        } else {
            this.r1 = rate1 - rate2;
            this.a1 = arc1 - arc2;
        }

        invalidate();
    }


    @Override
    public void run() {

        while (true) {
            try {
                if (rate1 <= rate2) {
                    if (r1 < rate1) {
                        r1 += 1;
                        r2 += 1;

                        a1 += angleRate;
                        a2 += angleRate;
                    }
                } else {
                    if (r2 < rate2) {
                        r1 += 1;
                        r2 += 1;

                        a1 += angleRate;
                        a2 += angleRate;
                    }
                }

                postInvalidate();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
