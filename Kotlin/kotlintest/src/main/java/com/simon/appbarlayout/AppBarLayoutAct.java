package com.simon.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.simon.R;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/12 14:24
 */

public class AppBarLayoutAct extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_appbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }
}
