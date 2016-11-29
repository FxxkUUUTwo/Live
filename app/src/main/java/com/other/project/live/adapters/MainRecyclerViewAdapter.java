package com.other.project.live.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.other.project.live.R;
import com.other.project.live.model.HotModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghaixin on 16/11/29.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = MainRecyclerViewAdapter.class.getSimpleName();
    private List<HotModel> data;

    private LayoutInflater inflater;

    private Context context;

    public MainRecyclerViewAdapter(List<HotModel> data, Context context) {

        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = inflater.inflate(R.layout.mian_item_layout, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.e(TAG, "onBindViewHolder:-------- " + data.get(position).getImg());
        if (position == 0) {
            holder.hot_service.setVisibility(View.VISIBLE);


        } else {

            holder.hot_service.setVisibility(View.GONE);

        }
        holder.content_img.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(context).load(data.get(position).getImg()).into(holder.content_img);
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

            hot_service = ((LinearLayout) itemView.findViewById(R.id.hot_service));

            content_img = ((ImageView) itemView.findViewById(R.id.content_img));
        }
    }

    public void updateRec(List<HotModel> data) {
        if (data != null) {
            this.data.clear();
            this.data = data;
            notifyDataSetChanged();
        }

    }
}
