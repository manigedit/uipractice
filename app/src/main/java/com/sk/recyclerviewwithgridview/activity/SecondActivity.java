package com.sk.recyclerviewwithgridview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sk.recyclerviewwithgridview.R;
import com.sk.recyclerviewwithgridview.adapter.FoodItemsAdapter;
import com.sk.recyclerviewwithgridview.adapter.HomeAdapter;
import com.sk.recyclerviewwithgridview.model.FoodItem;
import com.sk.recyclerviewwithgridview.model.Item;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements HomeAdapter.ItemListener, FoodItemsAdapter.ItemListener {

    private RecyclerView tablesRecycler;
    private RecyclerView foodItemsRecycler;
    private ArrayList<Item> items;
    private ArrayList<FoodItem> foodItems;
    TextView incerementButton;
    TextView decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        incerementButton = (TextView) findViewById(R.id.increment_button);
        decrementButton = (TextView) findViewById(R.id.decrement_button);
        tablesRecycler = (RecyclerView) findViewById(R.id.tables_recycler);
        foodItemsRecycler = (RecyclerView) findViewById(R.id.order_items);
        incerementButton.setBackgroundResource(R.drawable.rounded_corners);
        decrementButton.setBackgroundResource(R.drawable.rounded_corners);

         items = new ArrayList<>();
         foodItems = new ArrayList<>();

         items.add(new Item("Table One",1, "#FFFFFF", ""));
        items.add(new Item("Table Two",2, "#FFFFFF", "Ready"));
        items.add(new Item("Table Three",3, "#FFFFFF", ""));

        foodItems.add( new FoodItem("Mac and Cheese", "","I want extra cheese","Salman Khan",getDrawable(R.drawable.salman)));
        foodItems.add( new FoodItem("Peperini Pizza","2 min left","I want extra toppings","Ranbir Singh",getDrawable(R.drawable.ranbir)));

        FoodItemsAdapter foodItemsAdapter =  new FoodItemsAdapter(getApplicationContext(), foodItems, this);
        foodItemsRecycler.setAdapter(foodItemsAdapter);

        HomeAdapter mAdapter = new HomeAdapter(getApplicationContext(),items,this );
        tablesRecycler.setAdapter(mAdapter);

        LinearLayoutManager lmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager lmv = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        tablesRecycler.setLayoutManager(lmh);
        foodItemsRecycler.setLayoutManager(lmv);
        foodItemsRecycler.addItemDecoration(new DividerItemDecoration(foodItemsRecycler.getContext(), DividerItemDecoration.VERTICAL));



    }

    @Override
    public void onItemClick(Item item) {

    }

    @Override
    public void onFoodItemClick(FoodItem item) {

    }
}