package com.simon.util;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.simon.R;


/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/20 10:57
 */

public class WaitDialog extends Dialog {

    private Context mCxt;
    private LayoutInflater inflater;
    private TextView tvInfo;

    public WaitDialog(@NonNull Context context) {
        super(context, R.style.WaitDialog);
        this.mCxt = context;
        this.inflater = LayoutInflater.from(mCxt);
    }

    public WaitDialog Builder(long millisInFuture, long countDownInterval) {
        View contentView = inflater.inflate(R.layout.view_wait_dialog, null);
        setContentView(contentView);
        tvInfo = (TextView) contentView.findViewById(R.id.tv_info);
        setCancelable(false);
        MyCounter myCounter = new MyCounter(millisInFuture, countDownInterval);
        myCounter.start();
        return this;
    }


    private class MyCounter extends CountDownTimer {


        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tvInfo.setText(String.format("即将跳转徽商银行验证存管密码\n%ss", millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {

        }
    }


}
