package com.other.project.live.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class MainViewPagerAdapter extends PagerAdapter {

    private List<LinearLayout> data;

    public MainViewPagerAdapter(List<LinearLayout> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }

    }

    @Override
    public LinearLayout instantiateItem(ViewGroup container, int position) {

        container.addView(data.get(position));
        return data.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(data.get(position));

    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
