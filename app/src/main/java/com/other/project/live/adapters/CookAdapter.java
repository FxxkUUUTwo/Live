package com.other.project.live.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.other.project.live.R;
import com.other.project.live.model.CookList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class CookAdapter extends RecyclerView.Adapter<CookAdapter.ViewHolder> {
    private static final String TAG = CookAdapter.class.getSimpleName();
    private List<CookList.DataBean.ResultsBean> data;
    private LayoutInflater inflater;

    public CookAdapter(List<CookList.DataBean.ResultsBean> data, Context context) {
        if (data!=null) {
            this.data = data;
        }else {
            this.data=new ArrayList<>();
        }
        inflater=LayoutInflater.from(context);
    }

    public void updateRes(List<CookList.DataBean.ResultsBean> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    public void addRes(List<CookList.DataBean.ResultsBean> data){
        if (data!=null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.item_cook,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<CookList.DataBean.ResultsBean.TagsBean> tags = data.get(position).getTags();
        StringBuffer stringBuffer=new StringBuffer();
        for (CookList.DataBean.ResultsBean.TagsBean tag: tags) {
            stringBuffer.append(" "+tag);
        }
        String tagsStr = stringBuffer.toString();
        holder.good.setText(tagsStr);
        Log.e(TAG, "onBindViewHolder: "+tagsStr );
        holder.count.setText(data.get(position).getBespeak_num()+"人次");
        holder.cookName.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
     ImageView img;
        ImageView imgIcon;
        TextView good;
        TextView cookName;
        RatingBar starCount;
        TextView count;
        public ViewHolder(View itemView) {
            super(itemView);
            img= ((ImageView) itemView.findViewById(R.id.img));
            imgIcon= ((ImageView) itemView.findViewById(R.id.img_icon));
            good= ((TextView) itemView.findViewById(R.id.good_text));
            cookName= ((TextView) itemView.findViewById(R.id.cook_name));
            starCount= ((RatingBar) itemView.findViewById(R.id.ratingbar));
            count= ((TextView) itemView.findViewById(R.id.count));
        }
    }
}
