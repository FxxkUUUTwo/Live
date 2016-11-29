package com.other.project.live.gruidefragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.other.project.live.MainActivity;
import com.other.project.live.R;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.custom.MyEventBus;
import com.other.project.live.model.MainModel;
import com.other.project.live.widget.TopGroup;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import okhttp3.Call;

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

        OkHttpUtils.get().url("http://www.idachu.cn/api/welcome?timestamp=1480307555880&nonstr=d893ffbf4fa5454c6b7c053aeadc33a5&devicetoken=34c48d87bc6b03d6939190f1f77f90eb&ll=&sign=57323dc4dc570544e14ce64432652a49").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError: " + e.getCause());
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
                MainModel mainModel = gson.fromJson(stringBuffer.toString(), MainModel.class);


                Log.e(TAG, "onResponse: " + mainModel.getData().getShare().getTitle());


            }
        });


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
