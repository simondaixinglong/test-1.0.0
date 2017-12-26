package com.simon.widget;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/20 16:18
 */

public abstract class BaseGestureDetector {

    protected boolean mGestureInProgress;
    protected MotionEvent mPreMotionEvent;
    protected MotionEvent mCurrMotionEvent;
    protected Context mContext;

    public BaseGestureDetector(Context mContext) {
        this.mContext = mContext;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!mGestureInProgress) {
            handleStartProgressEvent(event);
        } else {
            handleInProgressEvent(event);
        }

        return true;
    }

    protected abstract void handleInProgressEvent(MotionEvent event);

    protected abstract void handleStartProgressEvent(MotionEvent event);

    protected abstract void updateStateByEvent(MotionEvent event);

    protected void resetState() {
        if (mPreMotionEvent != null) {
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }

        if (mCurrMotionEvent != null) {
            mCurrMotionEvent.recycle();
            mCurrMotionEvent = null;
        }

        mGestureInProgress = false;
    }

}
