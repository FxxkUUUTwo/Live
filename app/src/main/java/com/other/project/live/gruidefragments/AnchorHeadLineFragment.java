package com.other.project.live.gruidefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.other.project.live.R;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.custom.MyEventBus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class AnchorHeadLineFragment extends BaseFragment {

    public static final String TAG = AnchorHeadLineFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_anchorheadline_layout, container, false);
        return view;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MyEventBus event) {


        MyEventBus stickyEvent = EventBus.getDefault().getStickyEvent(MyEventBus.class);

        Log.e(TAG, "onEvent: " + stickyEvent.getCity());

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
}
