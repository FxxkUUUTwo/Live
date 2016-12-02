package com.other.project.live;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.other.project.live.base.BaseActivity;
import com.other.project.live.custom.MyEventBus;
import com.other.project.live.gruidefragments.AnchorHeadLineFragment;
import com.other.project.live.gruidefragments.ClassifyFragment;
import com.other.project.live.gruidefragments.MainFragment;
import com.other.project.live.gruidefragments.MyselfFragment;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;

/*
*
* My Live*/
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, SlidingMenu.OnOpenedListener, SlidingMenu.OnClosedListener, View.OnClickListener, MainFragment.backToggle {

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
    private SlidingMenu mSlidingMenu;
    private TextView beijing;
    private TextView shanghai;
    private TextView shenzhen;
    private TextView guangzhou;
    private ImageView beijingImage;
    private ImageView shanghaiImage;
    private ImageView shenZhenImage;
    private ImageView guangZhouImage;
    private TextView currentCity;

    private List<String> citys = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        initSlidingMenu();

        sendNotification();


    }

    private void sendNotification() {
      /*  JPushLocalNotification ln = new JPushLocalNotification(); ln.setBuilderId(0); 
        ln.setContent("hhh"); 
        ln.setTitle("ln"); ln.setNotificationId(11111111); 
        ln.setBroadcastTime(0);//设置出来的时间  
        Map<String, Object> map = new HashMap<String, Object>();
         map.put("name", "jpush"); 
        map.put("test", "111"); 
        JSONObject json = new JSONObject(map); ln.setExtras(json.toString()); 
        JPushInterface.addLocalNotification(getApplicationContext(), ln);
*/

        JPushLocalNotification ln = new JPushLocalNotification();

        ln.setBuilderId(0);
        ln.setContent("爱大厨欢迎你");
        ln.setTitle("爱大厨");
        ln.setNotificationId(111);
        ln.setBroadcastTime(3000);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "爱大厨");
        map.put("test", "爱大厨");
        JSONObject jsonObject = new JSONObject(map);
        ln.setExtras(jsonObject.toString());
        JPushInterface.addLocalNotification(getApplicationContext(), ln);

    }


    private void initSlidingMenu() {
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setMode(SlidingMenu.LEFT);//设置模式
        mSlidingMenu.setBehindOffsetRes(R.dimen.menu_offset);//配置菜单滑出后的剩余宽度
        //mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//配置触摸模式
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);//将slidingMenu贴在Activity上
        mSlidingMenu.setMenu(R.layout.left_menu);//设置侧滑布局菜单

        mSlidingMenu.setOnOpenedListener(this);
        mSlidingMenu.setOnClosedListener(this);

        View menu = mSlidingMenu.getMenu();

        this.beijing = (TextView) menu.findViewById(R.id.bejing);
        this.shanghai = (TextView) menu.findViewById(R.id.shanghai);
        this.shenzhen = (TextView) menu.findViewById(R.id.shenzhen);
        this.guangzhou = (TextView) menu.findViewById(R.id.guangzhou);

        currentCity = ((TextView) menu.findViewById(R.id.curr_city));

        currentCity.setOnClickListener(this);
        beijingImage = ((ImageView) menu.findViewById(R.id.beijing_img));
        shanghaiImage = ((ImageView) menu.findViewById(R.id.shanghai_img));
        shenZhenImage = ((ImageView) menu.findViewById(R.id.shenzhen_img));
        guangZhouImage = ((ImageView) menu.findViewById(R.id.guangzhou_img));

        beijing.setOnClickListener(this);
        shanghai.setOnClickListener(this);
        shenzhen.setOnClickListener(this);
        guangzhou.setOnClickListener(this);

    }

    private void initView() {
        citys.add("北京");
        citys.add("上海");
        citys.add("深圳");
        citys.add("广州");
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
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
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


    @Override
    public void onOpened() {

        Log.e(TAG, "onOpened: 打开");

    }

    @Override
    public void onClosed() {
        Log.e(TAG, "onOpened: 关闭");

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bejing:

                beijingImage.setVisibility(View.VISIBLE);
                shanghaiImage.setVisibility(View.GONE);
                shenZhenImage.setVisibility(View.GONE);

                guangZhouImage.setVisibility(View.GONE);
                EventBus.getDefault().postSticky(new MyEventBus(citys.get(0)));


                Location.city = "北京";
                Log.e(TAG, "onClick: 北京");

                break;
            case R.id.shanghai:
                shanghaiImage.setVisibility(View.VISIBLE);
                beijingImage.setVisibility(View.GONE);
                shenZhenImage.setVisibility(View.GONE);

                guangZhouImage.setVisibility(View.GONE);
                EventBus.getDefault().postSticky(new MyEventBus(citys.get(1)));
                Log.e(TAG, "onClick: 上海");
                Location.city = "上海";

                break;
            case R.id.shenzhen:
                shenZhenImage.setVisibility(View.VISIBLE);
                beijingImage.setVisibility(View.GONE);
                shanghaiImage.setVisibility(View.GONE);
                guangZhouImage.setVisibility(View.GONE);

                EventBus.getDefault().postSticky(new MyEventBus(citys.get(2)));
                Log.e(TAG, "onClick: 深圳");
                Location.city = "深圳";

                break;
            case R.id.guangzhou:
                guangZhouImage.setVisibility(View.VISIBLE);
                beijingImage.setVisibility(View.GONE);
                shanghaiImage.setVisibility(View.GONE);
                shenZhenImage.setVisibility(View.GONE);
                EventBus.getDefault().postSticky(new MyEventBus(citys.get(3)));
                Log.e(TAG, "onClick: 广州");

                Location.city = "广州";

                break;

            case R.id.curr_city:
                if (citys.contains(currentCity.getText().toString())) {
                    EventBus.getDefault().postSticky(new MyEventBus(currentCity.getText().toString()));

                } else {
                    EventBus.getDefault().postSticky(new MyEventBus("北京"));
                    Toast.makeText(MainActivity.this, "当前城市不可用", Toast.LENGTH_SHORT).show();

                }

                break;
        }

        mSlidingMenu.toggle();

    }

    @Override
    public void toggle() {
        mSlidingMenu.toggle();
    }


    //  定位监听接口实现类
    class MyLocationListener implements BDLocationListener {

        // onReceiveLocation 接收异步返回的定位结果，参数是BDLocation类型参数。
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {

            if (bdLocation == null) {
                client.start();
                currentCity.setText(bdLocation.getCity());
                handler.sendEmptyMessage(0x100);


            }

            currentCity.setText(bdLocation.getCity());

            Location.latitude = bdLocation.getLatitude();
            Location.longitude = bdLocation.getLongitude();
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
