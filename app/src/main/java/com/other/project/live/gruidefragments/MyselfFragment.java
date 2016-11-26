package com.other.project.live.gruidefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.other.project.live.R;
import com.other.project.live.base.BaseFragment;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class MyselfFragment extends BaseFragment {

    public static final String TAG = MyselfFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_myself_layout, container, false);
        return view;
    }
}
