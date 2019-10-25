package com.example.hw2bk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ItemDetailActivity extends AppCompatActivity {

    private int quantity = 0;
    private String quantityDisplay = "";
    private int itemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_activity);


        Intent intent = getIntent();
        itemID = intent.getIntExtra("itemID", 0);
        Item itemObject = ItemDatabase.getItemByID(itemID);

        ConstraintLayout activity_detail = findViewById(R.id.activity_detail);

        TextView itemMenuName = activity_detail.findViewById(R.id.name2);

        itemMenuName.setText(itemObject.getItemName());
        ImageView itemMenuImage = activity_detail.findViewById(R.id.image2);

        itemMenuImage.setImageResource(itemObject.getImage());
        TextView itemMenuPrice = activity_detail.findViewById(R.id.price);

        String itemPriceString = "$" + Double.toString(itemObject.getPrice()) + "0";
        itemMenuPrice.setText(itemPriceString);


        TextView itemMenuDescription = activity_detail.findViewById(R.id.description);

        itemMenuDescription.setText(itemObject.getDescription());

        final TextView itemQuantity = activity_detail.findViewById(R.id.quantity);

        Button plusButton = activity_detail.findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++quantity;
                quantityDisplay = Integer.toString(quantity);
                itemQuantity.setText(quantityDisplay);
            }
        });
        Button minusButton = activity_detail.findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    return;
                } else {
                    --quantity;
                    quantityDisplay = Integer.toString(quantity);
                    itemQuantity.setText(quantityDisplay);
                }
            }
        });
        Button addButton = activity_detail.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    return;
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("itemID", itemID);
                    intent.putExtra("quantity", quantity);
                    startActivity(intent);
                }
            }
        });

        ConstraintLayout detailHeader = findViewById(R.id.detailHeader);
        ImageView returnToMenuButton2 = detailHeader.findViewById(R.id.returnToMenuButton2);
        returnToMenuButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}