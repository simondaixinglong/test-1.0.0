package com.simon.refreshListview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.simon.R;

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/12 14:38
 */

public class RefreshListViewAct extends AppCompatActivity {

    private RefreshListView refreshListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_refreshlistview);


//        String deviceId = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId();
//        Toast.makeText(this, deviceId, Toast.LENGTH_LONG).show();


        refreshListView = (RefreshListView) findViewById(R.id.lv);


        refreshListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = new TextView(RefreshListViewAct.this);
                textView.setText("aaa");
                return textView;
            }
        });
    }
}
