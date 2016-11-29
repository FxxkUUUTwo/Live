package com.other.project.live.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.other.project.live.R;
import com.other.project.live.model.MainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private List<MainModel> data;

    private LayoutInflater inflater;

    public MainRecyclerViewAdapter(List<MainModel> data, Context context) {

        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {


        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout hot_service;

        ImageView content_img;

        public ViewHolder(View itemView) {
            super(itemView);

            hot_service= ((LinearLayout) itemView.findViewById(R.id.hot_service));

        }
    }

}
