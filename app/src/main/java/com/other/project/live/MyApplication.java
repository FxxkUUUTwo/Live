package com.other.project.live;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by wanghaixin on 16/11/28.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SDKInitializer.initialize(getApplicationContext());

    }
}
