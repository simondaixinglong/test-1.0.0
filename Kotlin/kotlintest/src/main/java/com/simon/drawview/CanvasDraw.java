package com.simon.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/26 10:47
 */

public class CanvasDraw extends View {

    private Region regionA, regionB;
    private Paint paint;

    public CanvasDraw(Context context) {
        this(context, null);
    }

    public CanvasDraw(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CanvasDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParams(context);
    }

    private void initParams(Context context) {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        regionA = new Region(100, 100, 300, 300);
        regionB = new Region(200, 200, 400, 400);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLUE);

        canvas.save();

        //裁剪A区域
//        canvas.clipRegion(regionA);
        //通过组合的方式裁剪出B区域
//        canvas.clipRegion(regionB, Region.Op.DIFFERENCE);
//        canvas.clipRegion(regionB, Region.Op.INTERSECT);
//        canvas.clipRegion(regionB, Region.Op.REVERSE_DIFFERENCE);

        //在裁剪出的区域里面填充颜色
        canvas.drawColor(Color.RED);

        canvas.restore();

        //画出辅助边，用于观察
        canvas.drawRect(100, 100, 300, 300, paint);
        canvas.drawRect(200, 200, 400, 400, paint);

    }
}
