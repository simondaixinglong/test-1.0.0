package com.simon.widget;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/12/20 16:29
 */

public interface OnMoveGestureListener {

    boolean onMoveBegin(MoveGestureDetector detector);

    boolean onMove(MoveGestureDetector detector);

    void onMoveEnd(MoveGestureDetector detector);
}
