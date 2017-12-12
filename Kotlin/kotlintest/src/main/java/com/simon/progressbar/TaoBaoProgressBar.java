package com.simon.progressbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.simon.R;
import com.simon.util.AppUtils;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/22 15:47
 */

public class TaoBaoProgressBar extends View {


    private int width, height;//view的宽、高
    private int rectRadius;//view边缘圆的半径
    private int sideWidth;//边缘的宽度
    private RectF bgRectF;

    private Bitmap bgBitmap, proBitmap;//背景图片
    private PorterDuffXfermode srcIn;//图形过渡模式
    private Paint rectPaint;//边框画笔
    private Paint bitmapPaint;//图形画笔
    private Paint textPaint;//文字画笔


    public TaoBaoProgressBar(Context context) {
        this(context, null);
    }

    public TaoBaoProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TaoBaoProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParams(context);
    }


    /**
     * 初始化参数
     *
     * @param context
     */
    private void initParams(Context context) {

        sideWidth = AppUtils.dp2px(1, context);

        rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setColor(0xffff3c32);

        bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        srcIn = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        bgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        proBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fg);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = getMeasuredWidth();
        height = getMeasuredHeight();

        rectRadius = height / 2;
        if (bgRectF == null) {
            bgRectF = new RectF(sideWidth, sideWidth, width - sideWidth, height - sideWidth);
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawSideBg(canvas);
        drawBg(canvas);

    }


    /**
     * 画出背景
     *
     * @param canvas
     */
    private void drawBg(Canvas canvas) {

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas bgCanvas = new Canvas(bitmap);
        bgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        bgCanvas.drawRoundRect(bgRectF, rectRadius, rectRadius, bitmapPaint);
        bitmapPaint.setXfermode(srcIn);
        bgCanvas.drawBitmap(bgBitmap, null, bgRectF, bitmapPaint);
        canvas.drawBitmap(bitmap, 0, 0, null);
        bitmapPaint.setXfermode(null);

    }


    /**
     * @param canvas
     */
    private void drawSideBg(Canvas canvas) {
        rectPaint.setStrokeWidth(sideWidth);

        canvas.drawRoundRect(bgRectF, rectRadius, rectRadius, rectPaint);
    }
}

















