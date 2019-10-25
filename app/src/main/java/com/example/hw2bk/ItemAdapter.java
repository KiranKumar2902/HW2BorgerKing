package com.example.hw2bk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Item> ItemArray;

    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);

        return itemViewHolder;
    }

    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        Item itemObject = ItemArray.get(position);

        final Context context = holder.itemName.getContext();

        holder.image.setImageResource(itemObject.getImage());

        holder.itemName.setText(itemObject.getItemName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra("itemID", position + 1);
                context.startActivity(intent);
            }
        });
    }

    public void setData(ArrayList<Item> itemData) { this.ItemArray = itemData; }

    public int getItemCount() {
        return ItemArray.size();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView image;
        public TextView itemName;

        public ItemViewHolder(View v) {
            super(v);
            view = v;
            image = v.findViewById(R.id.image);
            itemName = v.findViewById(R.id.name);
        }
    }

}