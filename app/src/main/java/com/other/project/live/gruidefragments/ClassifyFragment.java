package com.other.project.live.gruidefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.other.project.live.R;
import com.other.project.live.adapters.CookAdapter;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.custom.MyEventBus;
import com.other.project.live.model.CookList;
import com.other.project.live.url.BaseUrl;
import com.other.project.live.widget.TopGroup;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;

import okhttp3.Call;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class ClassifyFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = ClassifyFragment.class.getSimpleName();
    private TopGroup mTopGroup;
    private TextView mFilter;
    private SwipeRefreshLayout mRefresh;
    private RecyclerView mRecycler;
    private CookAdapter adapter;
    private int page=1;
    private double longitude;
    private double latitude;
    private String city;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_classify_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView(new Date().getTime());
    }


    private void initView() {
        mFilter = ((TextView) view.findViewById(R.id.filter));
        mFilter.setOnClickListener(this);
        mTopGroup = ((TopGroup) view.findViewById(R.id.top_group));
        mTopGroup.setTitle("厨师");
        mTopGroup.setSearchListener(this);
        mRefresh = ((SwipeRefreshLayout) view.findViewById(R.id.refresh));
        mRefresh.setOnRefreshListener(this);
        mRecycler = ((RecyclerView) view.findViewById(R.id.recycler));
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(manager);
        adapter = new CookAdapter(null,getContext());
        mRecycler.setAdapter(adapter);

    }

    private void setupView(long time) {

        OkHttpUtils.get()
                .url(BaseUrl.COOK_ONE+page+BaseUrl.COOK_TWO+longitude+","+latitude+BaseUrl.COOK_THREE+time+BaseUrl.COOK_FOUR+city)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: "+e.getMessage()+"/"+e.getCause() );
                        mRefresh.setRefreshing(false);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "onResponse: "+response );
                        Gson gson = new Gson();
                        CookList cookList = gson.fromJson(response, CookList.class);
                        adapter.updateRes(cookList.getData().getResults());
                        mRefresh.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_search:

                break;
            case R.id.filter:

                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
    @Subscribe(sticky=true,threadMode = ThreadMode.MAIN)
    public void onEvent(MyEventBus event){
        MyEventBus stickyEvent = EventBus.getDefault().getStickyEvent(MyEventBus.class);
        longitude = stickyEvent.getLongitude();//经度
        latitude = stickyEvent.getLatitude();//纬度
        city = stickyEvent.getCity();
    }

    @Override
    public void onRefresh() {
        //
        setupView(new Date().getTime());
    }
}
