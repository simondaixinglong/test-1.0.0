package com.simon.widget.slideView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.simon.R;


/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/20 09:42
 */

public class FlowIndicator extends View {

    private int mCount;// 圆钮数量
    private int mSpace;// 圆钮间距
    private int mRadius;// 圆钮半径
    private int mNormalColor;// 圆钮缺省颜色
    private int mFocusColor;// 圆钮焦点颜色
    private int mFocus;// 焦点的索引值

    public FlowIndicator(Context context) {
        this(context, null);
    }

    public FlowIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public FlowIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttrs(context, attrs, defStyleAttr);
    }

    /**
     * 初始化属性
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FlowIndicator);
        // 获取圆钮数量的属性值，若布局中没有设置，默认为4个
        mCount = array.getInt(R.styleable.FlowIndicator_count, 0);
        // 获取圆钮半径的属性值，若布局中没有设置，默认为8dp
        mRadius = array.getDimensionPixelOffset(R.styleable.FlowIndicator_radiu, 8);
        mNormalColor = array.getColor(R.styleable.FlowIndicator_normal_color, getResources().getColor(R.color.white));
        mFocusColor = array.getColor(R.styleable.FlowIndicator_focus_color, Color.GRAY);
        mSpace = array.getDimensionPixelOffset(R.styleable.FlowIndicator_space, 10);
        array.recycle();
    }


    /**
     * 设置焦点索引值，该方法由播放图片的类调用，设置正当前的索引值
     *
     * @param focus 传入的索引值
     */
    public void setFocus(int focus) {
        mFocus = focus;
        invalidate();// 通知绘图onDraw重新绘制一排圆钮
    }

    /**
     * 设置点的个数
     *
     * @param count
     */
    public void setCount(int count) {
        this.mCount = count;
        invalidate();
    }


    /**
     * 为播放图片的类提供图片的数量
     *
     * @return
     */
    public int getCount() {
        return mCount;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measuredWidth(widthMeasureSpec),
                measuredHeight(heightMeasureSpec));
    }

    /**
     * 测量view的宽度
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measuredWidth(int widthMeasureSpec) {
        int result = 0;// 计算宽度的最终结果
        // 获取测量规格
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        // 获取系统计算的宽度
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        // 若是精确测量规格
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {// 若是模糊测量规格，即wrap_content值
            result = getLeftPaddingOffset() + getRightPaddingOffset() + mCount
                    * 2 * mRadius + mSpace * (mCount - 1);
            // 取出最小值
            result = Math.min(result, specSize);
        }
        return result;
    }


    /**
     * 测量view的高度
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measuredHeight(int heightMeasureSpec) {
        int result = 0;// 计算高度的最终结果
        // 获取测量规格
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        // 获取系统计算的高度
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        // 若是精确测量规格
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {// 若是模糊测量规格，即wrap_content值
            result = getTopPaddingOffset() + getBottomPaddingOffset() + 2
                    * mRadius;
            // 取出最小值
            result = Math.min(result, specSize);
        }
        return result;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setAntiAlias(true);// 设置画笔抗锯齿
        // 计算左边距
        int leftSpace = (getWidth() - mCount * 2 * mRadius - (mCount - 1)
                * mSpace) / 2;
        // 依次绘制所有圆点
        for (int i = 0; i < mCount; i++) {
            int color = i == mFocus ? mFocusColor : mNormalColor;
            p.setColor(color);// 设置画笔颜色
            canvas.drawCircle(getLeftPaddingOffset() + leftSpace + mRadius + i
                    * (2 * mRadius + mSpace), getHeight() / 2, mRadius, p);
        }
    }
}
