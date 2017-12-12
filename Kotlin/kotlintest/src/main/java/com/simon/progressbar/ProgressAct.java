package com.simon.progressbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.simon.R;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/22 16:04
 */

public class ProgressAct extends AppCompatActivity{


    private TextView tvShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_progress);

        //设置状态栏
//        if (ImmersionBar.isSupportStatusBarDarkFont()) {
//
//            ImmersionBar
//                    .with(this)
//                    .statusBarDarkFont(true)
//                    .statusBarColor(R.color.white)
//                    .init();
//        } else {
//
//            ImmersionBar.with(this)
//                    .statusBarDarkFont(true, 0.2f)
//                    .init();
//        }

        tvShow = (TextView) findViewById(R.id.tv_show);
        showPopWindow();

    }

    private void showPopWindow() {
        PopupWindow popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.act_draw, null);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(tvShow, Gravity.BOTTOM, 0, 0);
    }
}
