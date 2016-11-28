package com.other.project.live;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.other.project.live.gruidefragments.AnchorHeadLineFragment;
import com.other.project.live.gruidefragments.ClassifyFragment;
import com.other.project.live.gruidefragments.MainFragment;
import com.other.project.live.gruidefragments.MyselfFragment;

/*
*
* My Live*/
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Fragment showFragment;
    private RadioGroup mRadioGroup;
    private FragmentManager mFragmentManager;


    private LocationClient client = null;
    private BDLocationListener locationListener = null;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x100) {
                // 停止定位，要不然定位会一直调用
                client.stop();
            }
        }
    };
    private TextView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {


        viewById = (TextView) findViewById(R.id.ceshi);
        mRadioGroup = (RadioGroup) findViewById(R.id.bottom_radiogroup);

        mRadioGroup.setOnCheckedChangeListener(this);
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        showFragment = new MainFragment();
        transaction.add(R.id.container_framelayout, showFragment, MainFragment.TAG);
        transaction.commit();


        Log.e(TAG, "initView--------: " + "asdasdasdasd");
        client = new LocationClient(getApplicationContext());

        //  配置定位SDK各配置参数
        initLocationClient();

        // 初始化位置监听器
        locationListener = new MyLocationListener();


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.main_btn:
                swapFragment(MainFragment.TAG, MainFragment.class);

                break;
            case R.id.classify_btn:

                swapFragment(ClassifyFragment.TAG, ClassifyFragment.class);

                break;
            case R.id.anchor_btn:
                swapFragment(AnchorHeadLineFragment.TAG, AnchorHeadLineFragment.class);

                break;
            case R.id.myself_btn:
                swapFragment(MyselfFragment.TAG, MyselfFragment.class);

                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 注册监听
        client.registerLocationListener(locationListener);
        client.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 停止定位;
        client.stop();
        // 解除注册监听
        client.unRegisterLocationListener(locationListener);
    }

    private void initLocationClient() {
        //配置定位SDK各配置参数，比如定位模式、定位时间间隔、坐标系类型等
        LocationClientOption option = new LocationClientOption();

        // 设置定位模式，高精度，低功耗，仅设备 .可选，默认高精度，
        // LocationClientOption.LocationMode.Hight_Accuracy 高精度
        // LocationClientOption.LocationMode.Battery_Saving  低功耗
        // LocationClientOption.LocationMode.Device_Sensors  仅设备
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        // 设置坐标类型 默认gcj02，设置返回的定位结果坐标系
        // 取值有3个： 返回国测局经纬度坐标系：gcj02 返回百度墨卡托坐标系 ：bd09 返回百度经纬度坐标系 ：bd09ll
        option.setCoorType("bd09ll");
        // 设置扫描间隔，单位是毫秒 当<1000(1s)时，定时定位无效, scanSpan - 单位毫秒 可选，默认0
        int scanSpan = 5000;
        option.setScanSpan(scanSpan);
        // 设置是否需要地址信息，默认为无地址
        option.setIsNeedAddress(true);
        //设置是否打开gps进行定位 可选，默认false
        option.setOpenGps(true);
        //设置是否当gps有效时按照1S1次频率输出GPS结果 可选，默认false
        option.setLocationNotify(true);
        //设置是否需要返回位置语义化信息，可以在BDLocation.getLocationDescribe()中得到数据，ex:"在天安门附近"， 可以用作地址信息的补充 可选，默认false
        option.setIsNeedLocationDescribe(true);
        // 设置是否需要返回位置POI信息，可以在BDLocation.getPoiList()中得到数据 可选，默认false，
        option.setIsNeedLocationPoiList(true);
        // 定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死   可选，默认true
        option.setIgnoreKillProcess(false);
        // 设置是否进行异常捕捉 true:不捕捉异常；false:捕捉异常，可选，默认false
        //option.SetIgnoreCacheException(false);
        option.SetIgnoreCacheException(false);
        // 设置是否允许模拟GPS true:允许； false:不允许，默认为false
        option.setEnableSimulateGps(false);

        // 将选项作用到定位客户端
        client.setLocOption(option);
    }


    //  定位监听接口实现类
    class MyLocationListener implements BDLocationListener {

        // onReceiveLocation 接收异步返回的定位结果，参数是BDLocation类型参数。
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {

            if (bdLocation == null) {
                client.start();
                Log.e(TAG, "onReceiveLocation=======: " + bdLocation.getLatitude() + ":" + bdLocation.getLongitude() + "" + ":" + bdLocation.getLocType());
                viewById.setText(bdLocation.getLatitude() + ":" + bdLocation.getLongitude() + "");
                handler.sendEmptyMessage(0x100);


            }
            Log.e(TAG, "onReceiveLocation=======: " + bdLocation.getLatitude() + ":" + bdLocation.getLongitude() + "" + bdLocation.getAddrStr() + ":" + bdLocation.getLocType());
            viewById.setText(bdLocation.getLatitude() + ":" + bdLocation.getLongitude() + "");

            handler.sendEmptyMessage(0x100);

        }

    }
        public void swapFragment(String Tag, Class<? extends Fragment> cls) {


            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.hide(showFragment);


            try {


                showFragment = mFragmentManager.findFragmentByTag(Tag);

                if (showFragment != null) {

                    transaction.show(showFragment);
                } else {
                    showFragment = cls.getConstructor().newInstance();
                    transaction.add(R.id.container_framelayout, showFragment, Tag);
                }
            } catch (Exception e) {

            }


//        showFragment.setArguments(new Bundle());
            transaction.commit();
        }
    }
