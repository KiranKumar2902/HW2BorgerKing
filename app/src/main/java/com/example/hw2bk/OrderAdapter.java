package com.example.hw2bk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<Item> OrderArrayList;

    public static void setOrderTotal(double orderTotal) {
        OrderAdapter.orderTotal = orderTotal;
    }

    public static double orderTotal = 0;

    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order, parent, false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    public void onBindViewHolder(@NonNull final OrderViewHolder holder, final int position) {
        Item itemMenuObject = OrderArrayList.get(position);
        final Context context = holder.itemMenuName3.getContext();
        holder.itemMenuImage3.setImageResource(itemMenuObject.getImage());
        holder.itemMenuName3.setText(itemMenuObject.getItemName());
        String itemMenuOrderQuantityString = Integer.toString(itemMenuObject.getOrderQuantity()) + "x ordered";
        holder.itemMenuQuantity2.setText(itemMenuOrderQuantityString);
        String itemMenuOrderQuantityPriceString = "Item Total = $" + Double.toString((itemMenuObject.getOrderQuantity())*itemMenuObject.getPrice()) + "0";
        holder.itemMenuQuantity3.setText(itemMenuOrderQuantityPriceString);
        holder.removeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;
                OrderArrayList.remove(position);
                if (getItemCount() == 0) {
                    intent1 = new Intent(context, MainActivity.class);
                    intent1.putExtra("returnFromOrders", 1);
                } else {
                    intent1 = new Intent(context, OrderActivity.class);
                    intent1.putExtra("OrderArrayList", OrderArrayList);
                }
                orderTotal = 0;
                context.startActivity(intent1);
            }
        });
    }

    public int getItemCount() {
        return OrderArrayList.size();
    }

    public void setData(ArrayList<Item> data) {
        this.OrderArrayList = data;
    }

    public double getOrderTotal() {
        for (int i = 0; i < OrderArrayList.size(); i++) {
            Item itemMenuObject = OrderArrayList.get(i);
            orderTotal += (itemMenuObject.getOrderQuantity() * itemMenuObject.getPrice());
        }
        return orderTotal;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView itemMenuImage3;
        public TextView itemMenuName3;
        public TextView itemMenuQuantity2;
        public Button removeOrder;
        public TextView itemMenuQuantity3;

        public OrderViewHolder(View v) {
            super(v);
            view = v;
            itemMenuImage3 = v.findViewById(R.id.image3);
            itemMenuName3 = v.findViewById(R.id.name3);
            itemMenuQuantity2 = v.findViewById(R.id.quantity2);
            removeOrder = v.findViewById(R.id.removeOrder);
            itemMenuQuantity3 = v.findViewById(R.id.itemMenuQuantity3);
        }
    }


}