package com.sk.recyclerviewwithgridview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sk.recyclerviewwithgridview.R;
import com.sk.recyclerviewwithgridview.model.Item;

import java.util.ArrayList;



public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Item> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public HomeAdapter(Context context, ArrayList<Item> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private TextView imageView;
        private TextView timeText;
        private RelativeLayout relativeLayout;
        private Item item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (TextView) v.findViewById(R.id.imageView);
            timeText = (TextView) v.findViewById(R.id.table_time);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        }

        public void setData(Item item) {
            this.item = item;
            textView.setText(item.text);
            //timeText.setBackgroundResource(R.drawable.sharp_corners);
            timeText.setText(item.time);
            imageView.setText(String.valueOf(item.drawable));
            if(item.time == "") {
                timeText.setVisibility(View.GONE);
            }
           relativeLayout.setBackgroundColor(Color.parseColor(item.color));
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setData(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(Item item);
    }
}