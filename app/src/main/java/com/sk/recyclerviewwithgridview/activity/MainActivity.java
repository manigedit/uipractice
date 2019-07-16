package com.sk.recyclerviewwithgridview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sk.recyclerviewwithgridview.R;
import com.sk.recyclerviewwithgridview.adapter.HomeAdapter;
import com.sk.recyclerviewwithgridview.model.Item;
import com.sk.recyclerviewwithgridview.util.AutoFitGridLayoutManager;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements HomeAdapter.ItemListener{

    private RecyclerView recyclerView;
    private ArrayList<Item> arrayList;
    LinearLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (LinearLayout) findViewById(R.id.layout1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

        arrayList.add(new Item("Table 1", 1, "#FFFFFF", ""));
        arrayList.add(new Item("Table 2", 2, "#3E51B1",""));
        arrayList.add(new Item("Table 3", 1, "#673BB7",""));
        arrayList.add(new Item("Item 4", 2, "#4BAA50","4:30 PM"));
        arrayList.add(new Item("Item 5", 1, "#F94336",""));
        arrayList.add(new Item("Item 6", 1, "#0A9B88",""));

        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), arrayList, this);
        recyclerView.setAdapter(adapter);


        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onItemClick(Item item) {
        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();
        if (item.drawable == 2) {
            Intent i = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(i);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
