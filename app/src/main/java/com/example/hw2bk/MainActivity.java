package com.example.hw2bk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Item> OrderArrayList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_menu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.setData(ItemDatabase.getAllItems());
        recyclerView.setAdapter(itemAdapter);

        Intent intent = getIntent();
        int returnFromOrders = intent.getIntExtra("returnFromOrders", 0);
        if (returnFromOrders == 1) {
            OrderArrayList.clear();
        } else if (returnFromOrders == 2) {
            OrderArrayList = (ArrayList<Item>) getIntent().getSerializableExtra("OrderArrayList");
        }

        int itemID = intent.getIntExtra("itemID", 0);
        if (itemID != 0) {
            Item MenuItemObject = new Item(itemID);
            int Quantity = intent.getIntExtra("quantity", 0);
            MenuItemObject.setOrderQuantity(Quantity);
            OrderArrayList.add(MenuItemObject);
        }

        Button viewOrderButton = findViewById(R.id.viewOrderButton);
        viewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), OrderActivity.class);
                intent2.putExtra("OrderArrayList", OrderArrayList);
                startActivity(intent2);
            }
        });
    }
}