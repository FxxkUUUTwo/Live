package com.other.project.live.gruidefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.other.project.live.R;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.widget.TopGroup;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class MainFragment extends BaseFragment {

    public static final String TAG = MainFragment.class.getSimpleName();
    private TopGroup mTopGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_layout, container, false);
        mTopGroup = (TopGroup) view.findViewById(R.id.main_top_group);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTopGroup.setTitle("是我");

    }
}
