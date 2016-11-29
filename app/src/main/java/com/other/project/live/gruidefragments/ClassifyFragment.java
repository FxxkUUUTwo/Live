package com.other.project.live.gruidefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.other.project.live.R;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.widget.TopGroup;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class ClassifyFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = ClassifyFragment.class.getSimpleName();
    private TopGroup mTopGroup;
    private TextView mFilter;
    private SwipeRefreshLayout mRefresh;
    private RecyclerView mRecycler;

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
    }

    private void initView() {
        mFilter = ((TextView) view.findViewById(R.id.filter));
        mFilter.setOnClickListener(this);
        mTopGroup = ((TopGroup) view.findViewById(R.id.top_group));
        mTopGroup.setTitle("厨师");
        mTopGroup.setSearchListener(this);
        mRefresh = ((SwipeRefreshLayout) view.findViewById(R.id.refresh));
        mRecycler = ((RecyclerView) view.findViewById(R.id.recycler));
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(manager);

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
}
