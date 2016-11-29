package com.other.project.live.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.other.project.live.Location;
import com.other.project.live.R;
import com.other.project.live.adapters.MainViewPagerAdapter;
import com.other.project.live.model.PrivateDingZhi;
import com.other.project.live.url.BaseUrl;
import com.other.project.live.widget.ZoomOutPageTransformer;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;

public class PrivateActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnKeyListener {

    private static final String TAG = PrivateActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private ArrayList<ImageView> data;
    private TextView mPageBottom;
    private TextView left_tv;
    private TextView price;
    private ImageView mShare;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.cookery_book_viewpager);

        mPageBottom = (TextView) findViewById(R.id.page_bottom);
        left_tv = (TextView) findViewById(R.id.left_tv);
        price = (TextView) findViewById(R.id.price);


        mViewPager.addOnPageChangeListener(this);

        mShare = (ImageView) findViewById(R.id.siren_share);
        mShare.setOnClickListener(this);


        getDataFromHttp();
    }


    private PrivateDingZhi privateDingZhi;

    private void getDataFromHttp() {
        Log.e(TAG, "getDataFromHttp: " + "进啦");
        data = new ArrayList<>();

        try {
            OkHttpUtils.get()
                    .url(BaseUrl.PRIVATE_PATH + new Date().getTime() + BaseUrl.PRIVATE_PATH2 + URLEncoder.encode(Location.city, "UTF-8"))
                    .build()
                    .execute(new StringCallback() {


                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            Log.e(TAG, "onError: " + e.getCause());
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            String[] s = response.split("\\\\");
                            StringBuffer stringBuffer = new StringBuffer();

                            for (int i = 0; i < s.length; i++) {
                                stringBuffer.append(s[i]);
                            }
                            Log.e(TAG + "---------", "onResponse: " + stringBuffer.toString());
                            Gson gson = new Gson();
                            String json = stringBuffer.toString();


                            privateDingZhi = gson.fromJson(json, PrivateDingZhi.class);

                            Log.e(TAG + "---------", "onResponse: " + privateDingZhi.getData().getItems().get(0).getList_img());
                            Log.e(TAG + "---------", "onResponse: " + privateDingZhi.getData().getItems().size());
                            left_tv.startAnimation(startAnimation());
                            left_tv.setText(privateDingZhi.getData().getItems().get(0).getName());


                            price.setText("RMB:" + privateDingZhi.getData().getItems().get(0).getPrice());
                            for (int i = 0; i < privateDingZhi.getData().getItems().size(); i++) {

                                ImageView view = new ImageView(PrivateActivity.this);


                                view.setScaleType(ImageView.ScaleType.FIT_XY);
                                Picasso.with(PrivateActivity.this)
                                        .load(privateDingZhi.getData().getItems().get(i).getList_img())

                                        .into(view);
                                data.add(view);
                            }

                            mainViewPagerAdapter = new MainViewPagerAdapter(data);

                            mViewPager.setAdapter(mainViewPagerAdapter);
                            mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                        }
                    });

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        left_tv.startAnimation(startAnimation());
        left_tv.setText(privateDingZhi.getData().getItems().get(position).getName());
        mPageBottom.setText(position + 1 + "/" + 7);
        price.setText("RMB:" + privateDingZhi.getData().getItems().get(position).getPrice());

    }

    private AnimationSet startAnimation() {
        AnimationSet set = new AnimationSet(true);

        ScaleAnimation animation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        TranslateAnimation animation2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f);


        set.addAnimation(animation);
        set.addAnimation(animation2);
        set.setDuration(3000);
        set.setFillAfter(true);
        return set;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.siren_share:

                Log.e(TAG, "onClick: " + "我去");
                showPopWindow(view);
                break;
        }
    }

    private void showPopWindow(View view) {
        View inflate = getLayoutInflater().inflate(R.layout.popwindow_layout, null);

        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));

        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        // popupWindow.getContentView().setFocusableInTouchMode(true);
        //l popupWindow.getContentView().setFocusable(true);

        popupWindow.getContentView().setOnKeyListener(this);


        popupWindow.setAnimationStyle(R.style.anim_menu_bottom);

        popupWindow.showAtLocation(findViewById(R.id.layout_main), Gravity.BOTTOM, 0, 0);

        // popupWindow.showAsDropDown(view);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if (i == KeyEvent.KEYCODE_MENU && keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

            if (popupWindow != null && popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            return true;
        }
        return false;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_MENU && event.getRepeatCount() == 0) {
            if (popupWindow != null && popupWindow.isShowing()) {
                popupWindow.showAtLocation(findViewById(R.id.layout_main), Gravity.BOTTOM, 0, 0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
