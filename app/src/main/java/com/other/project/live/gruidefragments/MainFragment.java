package com.other.project.live.gruidefragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.other.project.live.MainActivity;
import com.other.project.live.R;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.custom.MyEventBus;
import com.other.project.live.widget.TopGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = MainFragment.class.getSimpleName();
    private static final int REQUEST_CODE = 100;
    private TopGroup mTopGroup;
    private TextView mPosition;

    private MainActivity a;
    private TextView mProvision;

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


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPosition.setOnClickListener(this);
        mProvision.setOnClickListener(this);


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


        mPosition.setText(stickyEvent.getCity());

        Log.e(TAG, "MainonEvent: " + stickyEvent.getCity());
    }


    public interface backToggle {
        void toggle();
    }

}
