package com.other.project.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.other.project.live.R;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class TopGroup extends FrameLayout {
    private ImageView mBack;
    private TextView mTitle;
    private ImageView mSearch;


    public TopGroup(Context context) {
        this(context, null);
    }

    public TopGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        LayoutInflater.from(context).inflate(R.layout.topgroup_layout, this, true);

        mBack = (ImageView) findViewById(R.id.top_back);
        mTitle = (TextView) findViewById(R.id.top_title);
        mSearch = (ImageView) findViewById(R.id.top_search);


    }


    public void setTitle(String title) {

        mTitle.setVisibility(VISIBLE);
        mTitle.setText(title);
    }

    public void setTitle(int strRes) {
        mTitle.setVisibility(VISIBLE);
        mTitle.setText(strRes);
    }

    public void setGoBackListener(OnClickListener listener)

    {


        mBack.setVisibility(VISIBLE);
        mBack.setOnClickListener(listener);
    }
    public void setSearchListener( OnClickListener listener)

    {

        mSearch.setVisibility(VISIBLE);
        mSearch.setOnClickListener(listener);
    }

}
