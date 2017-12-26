package com.simon.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/20 16:23
 */

public class MoveGestureDetector extends BaseGestureDetector {

    private PointF mPrePointer;
    private PointF mCurrentPointer;
    private PointF mDeltaPointer = new PointF();
    private PointF mExtenalPointer = new PointF();//记录结果，并返回
    private OnMoveGestureListener mListener;


    public MoveGestureDetector(Context mContext, OnMoveGestureListener mListener) {
        super(mContext);
        this.mListener = mListener;
    }

    @Override
    protected void handleInProgressEvent(MotionEvent event) {

        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mListener.onMoveEnd(this);
                resetState();
                break;

            case MotionEvent.ACTION_MOVE:
                updateStateByEvent(event);
                if (mListener.onMove(this)) {
                    mPreMotionEvent.recycle();
                    mPreMotionEvent = MotionEvent.obtain(event);
                }
                break;

        }

    }

    @Override
    protected void handleStartProgressEvent(MotionEvent event) {

        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {

            case MotionEvent.ACTION_DOWN:
                //防止没有接受到cancel，up
                resetState();
                mPreMotionEvent = MotionEvent.obtain(event);
                updateStateByEvent(event);
                break;

            case MotionEvent.ACTION_MOVE:
                mGestureInProgress = mListener.onMoveBegin(this);
                break;

        }

    }

    @Override
    protected void updateStateByEvent(MotionEvent event) {

        MotionEvent pre = mPreMotionEvent;

        mPrePointer = calculateFocalPointer(pre);
        mCurrentPointer = calculateFocalPointer(event);

        boolean mSkipThisMovePointer = pre.getPointerCount() != event.getPointerCount();

        mExtenalPointer.x = mSkipThisMovePointer ? 0 : mCurrentPointer.x - mPrePointer.x;
        mExtenalPointer.y = mSkipThisMovePointer ? 0 : mCurrentPointer.y - mPrePointer.y;

    }


    /**
     * 根据event计算多指中心点
     *
     * @param event
     * @return
     */
    private PointF calculateFocalPointer(MotionEvent event) {

        int count = event.getPointerCount();
        int x = 0, y = 0;

        for (int i = 0; i < count; i++) {
            x += event.getX(i);
            y += event.getY(i);
        }

        x /= count;
        y /= count;

        return new PointF(x, y);

    }


    public float getMoveX() {
        return mExtenalPointer.x;
    }

    public float getMoveY() {
        return mExtenalPointer.y;
    }

    public static class SimpleGestureDetector implements OnMoveGestureListener {

        @Override
        public boolean onMoveBegin(MoveGestureDetector detector) {
            return true;
        }

        @Override
        public boolean onMove(MoveGestureDetector detector) {
            return false;
        }

        @Override
        public void onMoveEnd(MoveGestureDetector detector) {

        }
    }


}















