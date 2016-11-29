package com.other.project.live.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class CustomLinearManager extends LinearLayoutManager {
    public CustomLinearManager(Context context) {
        super(context);
    }

    public CustomLinearManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomLinearManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }
    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
