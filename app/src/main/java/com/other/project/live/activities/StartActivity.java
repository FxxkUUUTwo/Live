package com.other.project.live.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.other.project.live.MainActivity;
import com.other.project.live.R;

public class StartActivity extends AppCompatActivity implements Handler.Callback {

    private static final int START = 100;
    private Handler handler = new Handler(this);
    private TextView Timers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_start);

        Timers = (TextView) findViewById(R.id.timer_1);


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (flag) {

                    SystemClock.sleep(1000);
                    handler.sendEmptyMessage(START);
                }
            }
        }).start();

    }

    int i = 5;
    boolean flag = true;

    @Override
    public boolean handleMessage(Message message) {

        switch (message.what) {
            case START:

                if (i > 0) {

                    Timers.setText("倒计时: " + i + "");
                    i--;
                    if (i == 0) {
                        flag = false;

                    }
                } else if (i == 0) {


                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);

                    this.finish();
                }

                break;
        }

        return false;
    }
}
