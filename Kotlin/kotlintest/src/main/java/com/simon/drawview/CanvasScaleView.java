package com.simon.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/26 14:28
 */

public class CanvasScaleView extends View{

    private Paint paint;
    private Rect rect;
    private Region region;

    public CanvasScaleView(Context context) {
        this(context, null);
    }

    public CanvasScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CanvasScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParams(context);
    }


    /**
     *
     * @param context
     */
    private void initParams(Context context) {

//        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.RED);

        rect = new Rect(0, 0, 200, 200);
        region = new Region(200, 200, 400, 400);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.scale(0.75f, 0.75f);

        //通过rect裁剪出来的矩形
        int src1 = canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.clipRect(rect);
        canvas.drawColor(Color.RED);
        canvas.restoreToCount(src1);

        //通过region裁剪出来的矩形
        canvas.save(Canvas.ALL_SAVE_FLAG);
//        canvas.clipRegion(region);
        canvas.drawColor(Color.RED);
        canvas.restore();

        canvas.saveLayer(0, 0, 600, 600, null, Canvas.ALL_SAVE_FLAG);

    }
}















