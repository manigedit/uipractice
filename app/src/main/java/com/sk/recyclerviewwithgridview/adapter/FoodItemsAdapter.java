package com.sk.recyclerviewwithgridview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sk.recyclerviewwithgridview.R;
import com.sk.recyclerviewwithgridview.model.FoodItem;

import java.util.ArrayList;

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemsAdapter.ViewHolder> {
    private ArrayList<FoodItem> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public FoodItemsAdapter(Context context, ArrayList<FoodItem> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView foodName;
        private TextView timeLeft;
        private TextView extraButton;
        private TextView custName;
        private ImageView custImage;
        private FoodItem item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            foodName = (TextView) v.findViewById(R.id.food_name);
            timeLeft = (TextView) v.findViewById(R.id.time_left);
            extraButton = (TextView) v.findViewById(R.id.extra_button);
            custName = (TextView) v.findViewById(R.id.cust_name);
            custImage = (ImageView) v.findViewById(R.id.cust_image);
        }

        public void setData(FoodItem item) {
            this.item = item;
            foodName.setText(item.foodName);
            timeLeft.setText(item.timeLeft);
            extraButton.setText(item.extraButton);
            custName.setText(item.custName);
            custImage.setImageDrawable(item.custImage);
            if(item.timeLeft == "") {
                timeLeft.setVisibility(View.GONE);
            }

        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onFoodItemClick(item);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.order_item, parent, false);
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
        void onFoodItemClick(FoodItem item);
    }
}
