package com.simon.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/20 16:12
 */

public class LargeImageView extends View {

    private BitmapRegionDecoder bitmapRegionDecoder;//用于显示图片的某一块区域
    private int imageWidth, imageHeight;//图片的宽度，高度
    private Rect mRect = new Rect();//绘制的区域
    private MoveGestureDetector moveGestureDetector;

    private static final BitmapFactory.Options OPTIONS = new BitmapFactory.Options();

    static {
        OPTIONS.inPreferredConfig = Bitmap.Config.RGB_565;//每个像素占用2个字节
    }


    public LargeImageView(Context context) {
        this(context, null);
    }

    public LargeImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public LargeImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        moveGestureDetector = new MoveGestureDetector(context, new MoveGestureDetector.SimpleGestureDetector() {
            @Override
            public boolean onMove(MoveGestureDetector detector) {

                int moveX = (int) detector.getMoveX();
                int moveY = (int) detector.getMoveY();

                if (imageWidth > getWidth()) {
                    mRect.offset(-moveX, 0);
                    checkWidth();
                    invalidate();
                }

                if (imageHeight > getHeight()) {
                    mRect.offset(0, -moveY);
                    checkHeight();
                    invalidate();
                }

                return true;
            }
        });

    }

    private void checkWidth() {

        Rect rect = mRect;
        int width = imageWidth;

        if (rect.right > width) {
            rect.right = imageWidth;
            rect.left = imageWidth - getWidth();
        }

        if (rect.left < 0) {
            rect.right = 0;
            rect.left = getWidth();
        }

    }


    private void checkHeight() {
        Rect rect = mRect;
        int height = imageHeight;

        if (rect.bottom > height) {
            rect.bottom = imageHeight;
            rect.top = imageHeight - getHeight();
        }

        if (rect.top < 0) {
            rect.top = 0;
            rect.bottom = getHeight();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int imgWidth = imageWidth;
        int imgHeight = imageHeight;

        //默认显示中心位置
        mRect.left = imgWidth / 2 - width / 2;
        mRect.right = imgWidth / 2 + width / 2;
        mRect.top = imgHeight / 2 - height / 2;
        mRect.bottom = imgHeight / 2 + height / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bm = bitmapRegionDecoder.decodeRegion(mRect, OPTIONS);
        canvas.drawBitmap(bm, 0, 0, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        moveGestureDetector.onTouchEvent(event);
        return true;
    }

    public void setInputStream(InputStream is) {

        try {
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(is, false);
            BitmapFactory.Options tmpOptions = new BitmapFactory.Options();
            tmpOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, tmpOptions);
            imageWidth = bitmapRegionDecoder.getWidth();
            imageHeight = bitmapRegionDecoder.getHeight();
            requestLayout();
            invalidate();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}















