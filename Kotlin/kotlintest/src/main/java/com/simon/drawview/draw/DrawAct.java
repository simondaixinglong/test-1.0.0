package com.simon.drawview.draw;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simon.R;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/4 14:41
 */

public class DrawAct extends AppCompatActivity{

    private Button actBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_draw_test);


//        BuildConfig.IS_DEBUG
        actBtn  = findViewById(R.id.startAct);

        actBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrawAct.this, TwoAct.class);
                startActivity(intent);
            }
        });
    }
}
