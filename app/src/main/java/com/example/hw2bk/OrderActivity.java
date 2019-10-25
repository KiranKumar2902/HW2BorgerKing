package com.example.hw2bk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private ArrayList<Item> OrderArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        OrderArrayList = (ArrayList<Item>) getIntent().getSerializableExtra("OrderArrayList");

        RecyclerView recyclerView = findViewById(R.id.rv_order);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter();
        orderAdapter.setData(OrderArrayList);
        recyclerView.setAdapter(orderAdapter);

        ConstraintLayout activity_order_footer = findViewById(R.id.orderValue);
        TextView totalText = activity_order_footer.findViewById(R.id.totalText);
        String orderTotal = "Grand Total: $" + Double.toString(orderAdapter.getOrderTotal()) + "0";
        totalText.setText(orderTotal);

        ConstraintLayout activity_order_header = findViewById(R.id.orderHeader);
        ImageView returnToMenuButton = activity_order_header.findViewById(R.id.returnToMenuButton);
        returnToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("returnFromOrders", 2);
                intent.putExtra("OrderArrayList", OrderArrayList);
                OrderAdapter.setOrderTotal(0);
                startActivity(intent);
            }
        });

    }

}