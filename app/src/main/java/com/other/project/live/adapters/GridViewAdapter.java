package com.other.project.live.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.other.project.live.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghaixin on 16/12/1.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<String> data;
    private LayoutInflater inflater;

    private Context context;

    public GridViewAdapter(List<String> data, Context context) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public String getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item, viewGroup, false);
            holder = new ViewHolder(view);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv.setText(data.get(i));


        View view1 = view.findViewById(R.id.tv);
        ViewGroup.LayoutParams params = view1.getLayoutParams();
        params.height = viewGroup.getHeight() / 4 - 1;
        view1.setLayoutParams(params);
        view1.setBackgroundColor(Color.WHITE);
        Log.e("daaaaaaa121212121", "getView: " + viewGroup.getHeight());
        Log.e("daaaaaaa", "getView: " + params.height);

        return view;
    }


    private static class ViewHolder {

        TextView tv;


        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }
}
