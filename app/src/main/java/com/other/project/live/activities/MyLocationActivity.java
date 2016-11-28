package com.other.project.live.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.other.project.live.R;

import java.util.List;

public class MyLocationActivity extends AppCompatActivity {
    private LocationClient client = null;
    private BDLocationListener locationListener = null;

    private TextView tv_latitude; //纬度
    private TextView tv_longitude;//经度
    private TextView tv_address; //地址

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x100) {
                // 停止定位，要不然定位会一直调用
                client.stop();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        client = new LocationClient(getApplicationContext());

        //  配置定位SDK各配置参数
        initLocationClient();

        // 初始化位置监听器
        locationListener = new MyLocationListener();


    }

    @Override
    protected void onResume() {
        super.onResume();
        // 注册监听
        client.registerLocationListener(locationListener);
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
        option.SetIgnoreCacheException(false);
        // 设置是否允许模拟GPS true:允许； false:不允许，默认为false
        option.setEnableSimulateGps(false);

        // 将选项作用到定位客户端
        client.setLocOption(option);
    }


    public void btnClick(View v) {
        // 开始定位
        client.start();

    }


    //  定位监听接口实现类
    class MyLocationListener implements BDLocationListener {

        // onReceiveLocation 接收异步返回的定位结果，参数是BDLocation类型参数。
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            // server返回的当前定位时间
            Log.i("LocationActivity", "定位时间：" + bdLocation.getTime());
            // 获取定位类型: 参考 定位结果描述 相关的字段
            Log.i("LocationActivity", "定位类型:" + bdLocation.getLocType());
            // 获取定位精度,默认值0.0f
            Log.i("LocationActivity", "定位精度:" + bdLocation.getRadius());


            //纬度
            tv_latitude.setText(bdLocation.getLatitude() + "");
            //经度
            tv_longitude.setText(bdLocation.getLongitude() + "");
            // 获取详细地址信息
            tv_address.setText(bdLocation.getAddrStr());

            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                // GPS定位结果
                // 获取速度，仅gps定位结果时有速度信息，单位公里/小时，默认值0.0f
                Log.i("LocationActivity", "速度:" + bdLocation.getSpeed());
                // gps定位结果时，获取gps锁定用的卫星数
                Log.i("LocationActivity", "gps锁定用的卫星数:" + bdLocation.getSatelliteNumber());
                // 获取高度信息，目前只有是GPS定位结果时或者设置LocationClientOption.setIsNeedAltitude(true)时才有效，单位米
                Log.i("LocationActivity", "高度:" + bdLocation.getAltitude());
                // gps定位结果时，行进的方向，单位度  方位角
                Log.i("LocationActivity", "方位角:" + bdLocation.getDirection());
                Log.i("LocationActivity", "GPS定位完成");
            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                // 网络定位结果
                // 获取运营商信息
                // OPERATORS_TYPE_UNKONW : 未知运营商; OPERATORS_TYPE_MOBILE : 中国移动； OPERATORS_TYPE_UNICOM : 中国联通； OPERATORS_TYPE_TELECOMU : 中国电信
                int netType = bdLocation.getOperators();
                switch (netType) {
                    case BDLocation.OPERATORS_TYPE_UNKONW:
                        Log.i("LocationActivity", "网络类型:wifi" + "-----" + netType);
                        break;
                    case BDLocation.OPERATORS_TYPE_MOBILE:
                        Log.i("LocationActivity", "网络类型:中国移动" + "-----" + netType);
                        break;
                    case BDLocation.OPERATORS_TYPE_UNICOM:
                        Log.i("LocationActivity", "网络类型:中国联通" + "-----" + netType);
                        break;
                    case BDLocation.OPERATORS_TYPE_TELECOMU:
                        Log.i("LocationActivity", "网络类型:中国电信" + "-----" + netType);
                        break;

                }
                Log.i("LocationActivity", "网络定位完成");
            } else if (bdLocation.getLocType() == BDLocation.TypeOffLineLocation) {
                // 离线定位结果
                // 获取详细地址信息
                Log.i("LocationActivity", "地址:" + bdLocation.getAddrStr());
                Log.i("LocationActivity", "离线定位成功，离线定位结果也是有效的");
            } else if (bdLocation.getLocType() == BDLocation.TypeServerError) {
                Log.i("LocationActivity", "服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkException) {
                Log.i("LocationActivity", "网络不通导致定位失败，请检查网络是否通畅");
            } else if (bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
                Log.i("LocationActivity", "无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }

            //位置语义化信息
            Log.i("LocationActivity", "位置语义化信息:" + bdLocation.getLocationDescribe());
            Log.i("LocationActivity", "国家名称:" + bdLocation.getCountry() + ",国家代码:" + bdLocation.getCountryCode());
            Log.i("LocationActivity", "省份名称:" + bdLocation.getProvince());
            Log.i("LocationActivity", "城市名称:" + bdLocation.getCity() + ",城市代码:" + bdLocation.getCityCode());


            // POI数据
            List<Poi> list = bdLocation.getPoiList();
            if (list != null) {
                for (Poi poi : list) {
                    Log.i("LocationActivity", "Poi_ID=" + poi.getId() + ",Poi_Name=" + poi.getName() + ",Poi_Rank=" + poi.getRank());
                }
            }

            // 通知停止定位
            handler.sendEmptyMessage(0x100);

        }
    }
}

