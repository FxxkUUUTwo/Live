package com.other.project.live.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.other.project.live.R;

public class InfoAcitivity extends AppCompatActivity {

    private TextView mUserName;
    private TextView mUserTime;
    private TextView mCaiNumber;
    private TextView mRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_acitivity);

        initVIew();
    }

    private void initVIew() {

        Intent intent = getIntent();

        String info = intent.getStringExtra("info");
        String time = intent.getStringExtra("time");
        String number = intent.getStringExtra("number");
        String remarks = intent.getStringExtra("remarks");


        mUserName = (TextView) findViewById(R.id.user_name);
        mUserTime = (TextView) findViewById(R.id.user_time);
        mCaiNumber = (TextView) findViewById(R.id.cai_number);
        mRemarks = (TextView) findViewById(R.id.remarks);


        mUserName.setText(info);
        mUserTime.setText(time);
        mCaiNumber.setText(number);
        mRemarks.setText(remarks);


    }
}
