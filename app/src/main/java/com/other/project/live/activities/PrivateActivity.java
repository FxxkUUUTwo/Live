package com.other.project.live.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.other.project.live.Location;
import com.other.project.live.R;
import com.other.project.live.adapters.MainViewPagerAdapter;
import com.other.project.live.model.PrivateDingZhi;
import com.other.project.live.url.BaseUrl;
import com.other.project.live.widget.ZoomOutPageTransformer2;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;

public class PrivateActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnKeyListener {

    private static final String TAG = PrivateActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private ArrayList<LinearLayout> data;
    private TextView mPageBottom;
    private TextView left_tv;
    private TextView price;
    private ImageView mShare;
    private PopupWindow popupWindow;
    private View PopLayout;
    private TextView shareCancel;

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

                                LinearLayout linearLayout = buildImageView(privateDingZhi.getData().getItems().get(i).getList_img(), i);
                                data.add(linearLayout);
                            }

                            mainViewPagerAdapter = new MainViewPagerAdapter(data);

                            mViewPager.setAdapter(mainViewPagerAdapter);

                            mViewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));
                            mViewPager.setOffscreenPageLimit(3);
                            mViewPager.setPageTransformer(true, new ZoomOutPageTransformer2());
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
                //showPopWindow(view);
                showShare();
                break;

            case R.id.share_cancel:
                Log.e(TAG, "onClick: " + "PopCancel");
                popupWindow.dismiss();
                break;
        }
    }

    private void showPopWindow(View view) {
        View inflate = getLayoutInflater().inflate(R.layout.popwindow_layout, null);

        shareCancel = ((TextView) inflate.findViewById(R.id.share_cancel));
        Log.e(TAG, "initView: " + shareCancel.getText().toString());
        shareCancel.setOnClickListener(this);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));

        popupWindow.setFocusable(true);
        // popupWindow.getContentView().setFocusableInTouchMode(true);
        //l popupWindow.getContentView().setFocusable(true);

        popupWindow.getContentView().setOnKeyListener(this);


        popupWindow.setAnimationStyle(R.style.anim_menu_bottom);

        popupWindow.showAtLocation(findViewById(R.id.layout_main), Gravity.BOTTOM, 0, 0);


        setBackGroundAlpha(0.5f);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //popupwindow消失的时候恢复成原来的透明度
                setBackGroundAlpha(1f);
            }
        });
        // popupWindow.showAsDropDown(view);
    }

    private void setBackGroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if (i == KeyEvent.KEYCODE_MENU && keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {

            if (popupWindow != null && popupWindow.isShowing()) {
                popupWindow.dismiss();
                setBackGroundAlpha(1f);
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

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://baidu.com");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://baidu.com");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

    private LinearLayout buildImageView(String url, int i) {

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

        Display defaultDisplay = manager.getDefaultDisplay();
        int width = defaultDisplay.getWidth();

        LinearLayout ll = new LinearLayout(PrivateActivity.this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        ll.setLayoutParams(params);
        ll.setGravity(Gravity.CENTER);
        ImageView iv = new ImageView(this);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.e(TAG, "buildImageView: " + (int) (width * (4.0f / 5.0f)));
        LinearLayout.LayoutParams iv_params = new LinearLayout.LayoutParams((int) (width * (5.0f / 6.0f)), ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        Log.i("width--height", "width = " + params.width + "---" + "height = " + params.height);
        iv.setLayoutParams(iv_params);

        Picasso.with(PrivateActivity.this)
                .load(url)

                .into(iv);
        ll.addView(iv);

        return ll;
    }
}
