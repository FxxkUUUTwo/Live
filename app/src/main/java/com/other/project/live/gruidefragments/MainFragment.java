package com.other.project.live.gruidefragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.other.project.live.R;
import com.other.project.live.activities.PositionActivity;
import com.other.project.live.base.BaseFragment;
import com.other.project.live.widget.TopGroup;

/**
 * Created by wanghaixin on 16/11/26.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = MainFragment.class.getSimpleName();
    private static final int REQUEST_CODE = 100;
    private TopGroup mTopGroup;
    private View mPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_layout, container, false);

        mPosition = view.findViewById(R.id.top_position);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPosition.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        Intent intent = new Intent(getActivity(), PositionActivity.class);
        MainFragment.this.startActivityForResult(intent, REQUEST_CODE);

    }

}
