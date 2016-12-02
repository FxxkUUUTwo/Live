package com.other.project.live.activities;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.other.project.live.R;
import com.other.project.live.adapters.GridViewAdapter;
import com.other.project.live.adapters.MainViewPagerAdapter3;
import com.other.project.live.widget.CustomFlowLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class YongCanActivity extends AppCompatActivity implements View.OnClickListener, PopupWindow.OnDismissListener, ViewPager.OnPageChangeListener {

    private static final String TAG = YongCanActivity.class.getSimpleName();
    private TextView mEatTime;
    private PopupWindow popupWindow;
    private TabLayout popTablayout;
    private ViewPager popViewPager;
    private Map<Integer, String> map;
    private MainViewPagerAdapter3 mainViewPagerAdapter3;
    private ImageView mDelImage;
    private ImageView mAddImage;
    private TextView CaiNumber;
    private CustomFlowLayout mFlowLayout;
    private String mNames[] = {
            "不吃辣", "有小孩", "清单忌口", "有忌口", "有老人", "有孕妇"
    };
    private Button YuDing;
    private EditText mEditText;
    private TextView myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yong_can);

        initView();

    }

    private void initView() {


        map = new HashMap<>();
        map.put(1, "一");
        map.put(2, "二");
        map.put(3, "三");
        map.put(4, "四");
        map.put(5, "五");
        map.put(6, "六");
        map.put(7, "末");

        initFLowLayout();


        mDelImage = (ImageView) findViewById(R.id.del_img);
        mAddImage = (ImageView) findViewById(R.id.add_img);
        CaiNumber = (TextView) findViewById(R.id.number);

        YuDing = (Button) findViewById(R.id.yuding);
        YuDing.setOnClickListener(this);


        mEditText = (EditText) findViewById(R.id.et);


        myInfo = (TextView) findViewById(R.id.my_info);


        CaiNumber.setText(caiNumber + "菜/148");
        mEatTime = (TextView) findViewById(R.id.eat_time);
        mEatTime.setOnClickListener(this);


        mDelImage.setOnClickListener(this);
        mAddImage.setOnClickListener(this);
        CaiNumber.setOnClickListener(this);
    }

    private void initFLowLayout() {
        mFlowLayout = (CustomFlowLayout) findViewById(R.id.flow_layout);


        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                150, 50);
        lp.leftMargin = 20;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < mNames.length; i++) {


            TextView view = new TextView(this);
            // view.setBackgroundColor(Color.rgb(r, g, b));
            //view.setTextColor(Color.RGBToHSV(););
            view.setText(mNames[i]);
            //view.setTextColor(Color.rgb(255, 255, 255));

            view.setGravity(Gravity.CENTER);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));


            view.setTag(i);
            view.setId(i);
            view.setOnClickListener(this);
            mFlowLayout.addView(view, lp);


        }
    }

    int caiNumber = 4;

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if ("".equals(mEditText.getText().toString())) {
            buffer.delete(0, buffer.length());
        } else {
            buffer.delete(0, buffer.length());
            buffer.append(mEditText.getText().toString() + " ");
        }
        if (id >= 0 && id <= mNames.length - 1) {
            buffer.append(mNames[id] + "  ");
            mEditText.setText(buffer);
        }

        Log.e(TAG, "onClick: " + id);
        switch (view.getId()) {
            case R.id.eat_time:
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("EEEE MM-dd");

                String format1 = format.format(date);
                String substring = format1.substring(4, format1.length() - 1);
                int day = Integer.parseInt(format1.substring(format1.length() - 1, format1.length()));

                String weekNumber = format1.substring(2, 3);


                View inflate = LayoutInflater.from(this).inflate(R.layout.eat_time_popwindow_layout, null, false);
                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                popupWindow.setAnimationStyle(R.style.anim_menu_bottom);

                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.setOutsideTouchable(true);

                popupWindow.showAtLocation(findViewById(R.id.eat_main), Gravity.BOTTOM, 0, 0);
                setBackGroundAlpha(0.5f);

                popupWindow.setOnDismissListener(this);


                View contentView = popupWindow.getContentView();
                popTablayout = ((TabLayout) contentView.findViewById(R.id.eat_tablayout));
                popViewPager = ((ViewPager) contentView.findViewById(R.id.eat_viewpager));

                popViewPager.addOnPageChangeListener(this);
                int j = 0;

                for (int k = 1; k < 8; k++) {
                    if (map.get(k).equals(weekNumber)) {
                        j = k;
                    }
                }

                for (int i = 1; i < 6; i++) {
                    int m = 0;

                    TabLayout.Tab tab = popTablayout.newTab();
                    if (j != 7) {
                        m = (j % 7);
                    } else {
                        m = 7;
                    }
                    String s = map.get(m);

                    j++;

                    tab.setText("周" + s + "\n" + substring + day++);
                    popTablayout.addTab(tab);
                }

                List<GridView> data = new ArrayList<>();

                List<String> strings = new ArrayList<>();
                for (int i = 0; i < 16; i++) {

                    strings.add(i + "");
                }


                addGridViewToViewPager(R.layout.eat_vp_item_layout, R.id.schedule_gridview, data, strings);
                addGridViewToViewPager(R.layout.eat_vp_item_layout2, R.id.schedule_gridview2, data, strings);


                popTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(popViewPager));
                popViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(popTablayout));

                break;


            case R.id.add_img:

                if (caiNumber < 7) {
                    caiNumber += 1;
                    CaiNumber.setText(caiNumber + "菜/148");

                } else {
                    Snackbar.make(view, "目前只是支持7菜", 3000).show();
                }

                break;

            case R.id.del_img:

                if (caiNumber > 4) {
                    caiNumber -= 1;
                    CaiNumber.setText(caiNumber + "菜/148");
                } else {
                    Snackbar.make(view, "最少四个菜", 3000).show();

                }
                break;

            case R.id.number:

                break;

            case R.id.yuding:

                String info = myInfo.getText().toString();
                String time = mEatTime.getText().toString();
                String number = CaiNumber.getText().toString();
                String remarks = mEditText.getText().toString();

                Intent intent = new Intent(this, InfoAcitivity.class);

                intent.putExtra("info", info);
                intent.putExtra("time", time);
                intent.putExtra("number", number);
                intent.putExtra("remarks", remarks);
                startActivity(intent);

                break;


        }


    }


    private void addGridViewToViewPager(int Res, int ResId, List<GridView> data, List<String> strings) {
        View view1 = LayoutInflater.from(this).inflate(Res, null, false);
        GridView gridView = (GridView) view1.findViewById(ResId);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(strings, this);
        gridView.setAdapter(gridViewAdapter);

        data.add(gridView);


        int i = 0;
        gridView.setTag(i);
        i++;
        mainViewPagerAdapter3 = new MainViewPagerAdapter3(data);

        popViewPager.setAdapter(mainViewPagerAdapter3);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView childAt = (TextView) ((LinearLayout) adapterView.getChildAt(i)).getChildAt(0);
                String s = childAt.getText().toString();


                String s1 = popTablayout.getTabAt(currPos).getText().toString();

                popupWindow.dismiss();

                mEatTime.setText(s1 + "\n" + s);
            }
        });

    }


    @Override
    public void onDismiss() {

        setBackGroundAlpha(1f);
    }

    private void setBackGroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha; //0.0-1.0
        getWindow().setAttributes(lp);


    }

    private int currPos = 0;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {


        currPos = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
