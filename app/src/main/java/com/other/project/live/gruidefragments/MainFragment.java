package com.other.project.live.gruidefragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.other.project.live.Location;
import com.other.project.live.MainActivity;
import com.other.project.live.R;
import com.other.project.live.activities.DanPinHotActivity;
import com.other.project.live.activities.PrivateActivity;
import com.other.project.live.activities.YongCanActivity;
import com.other.project.live.adapters.MainRecyclerViewAdapter;
import com.other.project.live.adapters.MainViewPagerAdapter2;
import com.other.project.live.base.BaseApplication;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.constants.HttpParams;
import com.other.project.live.custom.MyEventBus;
import com.other.project.live.model.HotModel;
import com.other.project.live.model.MainModel;
import com.other.project.live.model.PhoneChange;
import com.other.project.live.model.TopModel;
import com.other.project.live.url.BaseUrl;
import com.other.project.live.widget.AutoScollTextView;
import com.other.project.live.widget.CustomLinearManager;
import com.other.project.live.widget.TopGroup;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener, MainRecyclerViewAdapter.backWebView, Handler.Callback {

    public static final String TAG = MainFragment.class.getSimpleName();
    private static final int START_SCOLL = 100;
    private TopGroup mTopGroup;
    private TextView mPosition;

    private MainActivity a;
    private TextView mProvision;
    private ViewPager mViewPager;
    private String city;
    private LinearLayout mPointLinearLayout;
    private AutoScollTextView mScollTextView;
    private ImageView mErrorImage;
    private RelativeLayout mRelativeLayout;
    private ImageView mYongCan;
    private ImageView mDingZhi;
    private RecyclerView mRecyclerView;
    private MainRecyclerViewAdapter mRecyclerViewAdapter;
    private CustomLinearManager linearLayoutManager;
    private ScrollView mScollView;

    private Handler handler = new Handler(this);
    private String danPin;
    private ArrayList<TopModel> topData;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        a = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);


        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);


        }

        handler.removeCallbacksAndMessages(null);


    }

    /*
    * */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_layout, container, false);

        mPosition = (TextView) view.findViewById(R.id.top_position);
        mProvision = ((TextView) view.findViewById(R.id.top_provision));

        mViewPager = (ViewPager) view.findViewById(R.id.top_vp);

        mPointLinearLayout = (LinearLayout) view.findViewById(R.id.point_linearlayout);


        mScollTextView = (AutoScollTextView) view.findViewById(R.id.scoll_textview);

        mErrorImage = ((ImageView) view.findViewById(R.id.error_img));

        mRelativeLayout = ((RelativeLayout) view.findViewById(R.id.relativelayout));

        mYongCan = ((ImageView) view.findViewById(R.id.jiachangyongcan));
        mDingZhi = (ImageView) view.findViewById(R.id.sirendingzhi);

        mRecyclerView = ((RecyclerView) view.findViewById(R.id.mian_recyclerview));
        linearLayoutManager = new CustomLinearManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerViewAdapter = new MainRecyclerViewAdapter(null, getActivity(), this);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mScollView = ((ScrollView) view.findViewById(R.id.main_scollview));


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mErrorImage.setOnClickListener(this);
        mPosition.setOnClickListener(this);
        mProvision.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(this);


        //mViewPager.setOnTouchListener(this);
        //mViewPager.addOnPageChangeListener(this);


        mYongCan.setOnClickListener(this);
        mDingZhi.setOnClickListener(this);

        mScollTextView.init(getActivity().getWindowManager());

        mScollTextView.startScroll();
        requestData();

        requestPhoneChange();
    }

    private void requestPhoneChange() {
        try {
            OkHttpUtils.get()

                    .url(BaseUrl.PHONE_CHANGE + new Date().getTime() + BaseUrl.PHONE_CHANGE2 + URLEncoder.encode(Location.city, "UTF-8"))
                    .addHeader(HttpParams.CACHE_CONTROL, BaseApplication.getCacheControl())
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {

                            Gson gson = new Gson();
                            PhoneChange phoneChange = gson.fromJson(response, PhoneChange.class);
                            mScollTextView.setText(phoneChange.getData().getNotice().get(0).getTitle());
                            mScollTextView.init(getActivity().getWindowManager());
                            mScollTextView.startScroll();
                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    private void requestData() {
        Log.e(TAG, "onActivityCreated:============== " + Location.city);
        try {

            OkHttpUtils.get()

                    .url(BaseUrl.MAIN_PATH + new Date().getTime() + BaseUrl.MAIN_PATH2 + URLEncoder.encode(Location.city, "UTF-8"))
                    .addHeader(HttpParams.CACHE_CONTROL, BaseApplication.getCacheControl())
                    .build()
                    .execute(new StringCallback() {


                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.e(TAG, "onError: " + e.getCause());
                            Log.e(TAG, "onError: " + e.getMessage());
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.e(TAG, "onResponse: " + response);

                            String[] s = response.split("\\\\");

                            StringBuffer stringBuffer = new StringBuffer();

                            for (int i = 0; i < s.length; i++) {
                                stringBuffer.append(s[i]);
                            }
                            Log.e(TAG + "---------", "onResponse: " + stringBuffer.toString());
                            Gson gson = new Gson();
                            String json = stringBuffer.toString();
                            MainModel mainModel = gson.fromJson(json, MainModel.class);


                            Picasso.with(getActivity()).load(mainModel.getData().getButtons().get(0).getIcon()).into(mYongCan);
                            Picasso.with(getActivity()).load(mainModel.getData().getButtons().get(1).getIcon()).into(mDingZhi);
                            //手动解析
                            //JsonObject jsonObject = new JsonObject(json);
                            topData = new ArrayList<TopModel>();
                            List<ImageView> Images = new ArrayList<>();
                            getTop(json, topData, Images);

                            List<HotModel> hotData = new ArrayList<HotModel>();


                            try {

                                JSONObject jsonObject = new JSONObject(json);
                                JSONObject data = jsonObject.getJSONObject("data");
                                JSONArray hot = data.getJSONArray("hot");

                                for (int i = 0; i < hot.length(); i++) {

                                    HotModel hotModel = new HotModel();
                                    String title = hot.getJSONObject(i).getString("title");
                                    String img = hot.getJSONObject(i).getString("img");
                                    hotModel.setTitle(title);
                                    hotModel.setImg(img);

                                    if (i == 3) {

                                        String uri1 = hot.getJSONObject(i).getString("uri");

                                        danPin = uri1;
                                        hotModel.setUri(uri1);

                                    } else {
                                        String uri2 = hot.getJSONObject(i).getJSONObject("uri").getString("url");

                                        hotModel.setUri(uri2);
                                    }


                                    hotData.add(hotModel);
                                }
                            } catch (JSONException e) {
                                Log.e(TAG, "onResponse: " + e.getCause());
                                Log.e(TAG, "onResponse: " + e.getMessage());
                                e.printStackTrace();
                            }
                            Log.e(TAG, "onResponse:=========11111111-====== " + hotData.get(0).getImg());
                            mRecyclerViewAdapter.updateRec(hotData);


                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MainViewPagerAdapter2 mViewPagerAdapter;
    private List<ImageView> l;

    private void getTop(String json, List<TopModel> topData, List<ImageView> images) {
        l = images;
        try {

            mPointLinearLayout.removeAllViews();
            JSONObject jsonObject = new JSONObject(json);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray top = data.getJSONArray("top");

            Log.e(TAG, "onResponse:````````````````````````` " + top.get(0));
            for (int i = 0; i < top.length(); i++) {

                addPoint();
                Log.e(TAG, "onResponse: 啥?" + top.length());
                ImageView view = new ImageView(getActivity());

                view.setScaleType(ImageView.ScaleType.FIT_XY);
                TopModel topModel1 = new TopModel();
                String title = top.getJSONObject(i).getString("title");
                String img = top.getJSONObject(i).getString("img");

                Picasso.with(getActivity()).load(img).into(view);

                images.add(view);
                topModel1.setTitle(title);
                topModel1.setImg(img);


                if (i != 2) {

                    String uri1 = top.getJSONObject(i).getString("uri");


                    Log.e(TAG, "onResponse: 120000000000000." + uri1);
                    topModel1.setUri(uri1);

                } else {
                    String uri2 = top.getJSONObject(i).getJSONObject("uri").getString("url");
                    Log.e(TAG, "onResponse: 30000000000000000." + uri2);

                    topModel1.setUri(uri2);


                }

                topData.add(topModel1);
            }

            mPointLinearLayout.getChildAt(currposition % 3).setBackgroundResource(R.mipmap.yuandian_click);
        } catch (JSONException e) {
            Log.e(TAG, "onResponse: " + e.getCause());
            Log.e(TAG, "onResponse: " + e.getMessage());
            e.printStackTrace();
        }
        mViewPagerAdapter = new MainViewPagerAdapter2(images);

        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setCurrentItem(currposition);

    }

    private void addPoint() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
        layoutParams.setMargins(12, 0, 12, 0);
        View view = new View(getActivity());
        view.setLayoutParams(layoutParams);

        view.setBackgroundResource(R.mipmap.yuandian);
        mPointLinearLayout.addView(view);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.top_position:
                a.toggle();

                break;

            case R.id.top_provision:

                break;

            case R.id.error_img:
                mRelativeLayout.setVisibility(View.GONE);
                break;

            case R.id.sirendingzhi:

                Intent intent = new Intent(getActivity(), PrivateActivity.class);

                startActivity(intent);

                break;


            case R.id.jiachangyongcan:

                Intent intent1 = new Intent(getActivity(), YongCanActivity.class);


                startActivity(intent1);
                break;
        }


    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MyEventBus event) {

        MyEventBus stickyEvent = EventBus.getDefault().getStickyEvent(MyEventBus.class);


        city = stickyEvent.getCity();
        mPosition.setText(city);
        // Log.e(TAG, "MainonEvent: " + stickyEvent.getCity());

        requestData();
        mScollTextView.stopScroll();

        requestPhoneChange();
    }

    private boolean flag = false;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e(TAG, "onPageScrolled: " + positionOffset + ":::::" + positionOffsetPixels);
       /* if (currState == ViewPager.SCROLL_STATE_SETTLING && positionOffset == 0) {
            Log.e(TAG, "onPageSelected: " + currState + "进啦");
            Message message = handler.obtainMessage();
            message.what = START_SCOLL;
            handler.sendMessage(message);

        }
*/

    }

    private int currposition = 4999998;


    @Override
    public void onPageSelected(int position) {


        mPointLinearLayout.getChildAt(currposition % 3).setBackgroundResource(R.mipmap.yuandian);

        mPointLinearLayout.getChildAt(position % 3).setBackgroundResource(R.mipmap.yuandian_click);

        currposition = position;

    }

    private int currState;

    @Override
    public void onPageScrollStateChanged(int state) {
        currState = state;

        Log.e(TAG, "onPageScrollStateChanged: " + state);
       /* switch (state) {
            case ViewPager.SCROLL_STATE_DRAGGING://手指滑动状态
                Log.e(TAG, "onPageScrollStateChanged: " + "一处了");
                handler.removeMessages(START_SCOLL);
                break;
            case ViewPager.SCROLL_STATE_IDLE:
//停止状态

                break;
            case ViewPager.SCROLL_STATE_SETTLING://自动滑动状态

                break;

            default:
                break;
        }*/
    }

    @Override
    public void sendWeb(int pos) {

        Log.e(TAG, "sendWeb: " + pos);

        Intent intent = new Intent(getActivity(), DanPinHotActivity.class);

        intent.putExtra("path", danPin);

        startActivity(intent);


    }

    int i = currposition;

    @Override
    public boolean handleMessage(Message message) {

        switch (message.what) {
            case START_SCOLL:


                // mViewPager.removeView(l.get(i));
                mViewPager.setCurrentItem(i);

                i++;

                break;
        }


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Message message = handler.obtainMessage();
                message.what = START_SCOLL;
                handler.sendMessage(message);
            }
        }, 3000);
        return false;
    }

    private boolean isLoop = true;

  /*  @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(getActivity(), "Down", Toast.LENGTH_SHORT).show();
                isLoop = false;
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(getActivity(), "Up", Toast.LENGTH_SHORT).show();
                isLoop = true;
                break;
        }

        handleMessage(handler.obtainMessage());
        return false;
    }*/


    public interface backToggle {
        void toggle();

    }


}
