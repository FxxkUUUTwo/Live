package com.other.project.live.gruidefragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.other.project.live.Location;
import com.other.project.live.MainActivity;
import com.other.project.live.R;
import com.other.project.live.adapters.MainViewPagerAdapter;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.custom.MyEventBus;
import com.other.project.live.model.MainModel;
import com.other.project.live.model.TopModel;
import com.other.project.live.url.BaseUrl;
import com.other.project.live.widget.AutoScollTextView;
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

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    public static final String TAG = MainFragment.class.getSimpleName();
    private TopGroup mTopGroup;
    private TextView mPosition;

    private MainActivity a;
    private TextView mProvision;
    private ViewPager mViewPager;
    private String city;
    private LinearLayout mPointLinearLayout;
    private AutoScollTextView mScollTextView;

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


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_layout, container, false);

        mPosition = (TextView) view.findViewById(R.id.top_position);
        mProvision = ((TextView) view.findViewById(R.id.top_provision));

        mViewPager = (ViewPager) view.findViewById(R.id.top_vp);

        mPointLinearLayout = (LinearLayout) view.findViewById(R.id.point_linearlayout);


        mScollTextView = (AutoScollTextView) view.findViewById(R.id.scoll_textview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPosition.setOnClickListener(this);
        mProvision.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(this);
        mScollTextView.init(getActivity().getWindowManager());

        mScollTextView.startScroll();
        requestData();


    }

    private void requestData() {
        Log.e(TAG, "onActivityCreated:============== " + Location.city);
        try {

            if (city == null) {
                this.city = this.city;

            }
            OkHttpUtils.get().url(BaseUrl.MAIN_PATH + new Date().getTime() + BaseUrl.MAIN_PATH2 + URLEncoder.encode(Location.city, "UTF-8")).build().execute(new StringCallback() {
                private MainViewPagerAdapter mViewPagerAdapter;


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


                    //手动解析
                    //JsonObject jsonObject = new JsonObject(json);
                    List<TopModel> topData = new ArrayList<TopModel>();
                    List<ImageView> Images = new ArrayList<>();

                    try {

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

                            Images.add(view);
                            topModel1.setTitle(title);
                            topModel1.setImg(img);


                            if (i != 2) {

                                String uri1 = top.getJSONObject(i).getString("uri");


                                Log.e(TAG, "onResponse: 120000000000000" + uri1);
                                topModel1.setUri(uri1);

                            } else {
                                String uri2 = top.getJSONObject(i).getJSONObject("uri").getString("url");
                                Log.e(TAG, "onResponse: 30000000000000000" + uri2);

                                topModel1.setUri(uri2);


                            }

                            topData.add(topModel1);
                        }
                    } catch (JSONException e) {
                        Log.e(TAG, "onResponse: " + e.getCause());
                        Log.e(TAG, "onResponse: " + e.getMessage());
                        e.printStackTrace();
                    }


                    mPointLinearLayout.getChildAt(0).setBackgroundResource(R.mipmap.yuandian_click);
                    mViewPagerAdapter = new MainViewPagerAdapter(Images);
                    mViewPager.setAdapter(mViewPagerAdapter);


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        }


    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MyEventBus event) {

        MyEventBus stickyEvent = EventBus.getDefault().getStickyEvent(MyEventBus.class);


        city = stickyEvent.getCity();
        mPosition.setText(city);
        // Log.e(TAG, "MainonEvent: " + stickyEvent.getCity());

        requestData();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    private int currposition = 0;

    @Override
    public void onPageSelected(int position) {


        mPointLinearLayout.getChildAt(currposition).setBackgroundResource(R.mipmap.yuandian);

        mPointLinearLayout.getChildAt(position).setBackgroundResource(R.mipmap.yuandian_click);

        currposition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public interface backToggle {
        void toggle();
    }

}
