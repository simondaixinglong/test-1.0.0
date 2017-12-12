package com.simon.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/17 10:24
 */

public class QuadToView extends View {

    private int viewHeight, viewWidth;//view的宽 高
    private Paint paint;//画笔
    private Path path;//路径
    private float ctrX, ctrY;//控制点的坐标
    private float waveY;//整个wave两端点Y坐标，该坐标与控制点增幅一致

    private boolean isInc;//标记控制点是否该往右移动

    public QuadToView(Context context) {
        this(context, null);
    }

    public QuadToView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public QuadToView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams(context, attrs, defStyleAttr);
    }

    /**
     * 初始化参数
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initParams(Context context, AttributeSet attrs, int defStyleAttr) {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setColor(0xFFA2D6AE);

        path = new Path();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        viewHeight = h;
        viewWidth = w;
        Log.e("simon", viewHeight + "**" + viewWidth);

        //计算端点的Y坐标
        waveY = 1 / 8F * viewHeight;
        //计算控制点的Y坐标
        ctrY = -1 / 16F * viewHeight;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置path的起点，在屏幕的外面
        path.moveTo(-1 / 4F * viewWidth, waveY);
        path.quadTo(ctrX, ctrY, 5 / 4F * viewWidth, waveY);

        path.lineTo(5 / 4F * viewWidth, viewHeight);
        path.lineTo(-1 / 4F* viewWidth, viewHeight);
        path.close();
        canvas.drawPath(path, paint);

        if (ctrX >= 5 / 4F * viewWidth)
            isInc = false;

        if (ctrX <= -1 / 4F * viewWidth)
            isInc = true;

        ctrX = isInc ? ctrX + 20 : ctrX - 20;

        if (ctrY <= viewHeight) {
            ctrY += 2;
            waveY += 2;
        }

        path.reset();
        invalidate();
    }
}



















