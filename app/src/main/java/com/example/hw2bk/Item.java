package com.example.hw2bk;

import java.io.Serializable;

public class Item implements Serializable {

    private int itemID;
    private int image;
    private String itemName;
    private double price;
    private String description;
    private int OrderQuantity;


    public Item(int itemID) {
        this.itemID = ItemDatabase.getItemByID(itemID).getItemID();
        this.image = ItemDatabase.getItemByID(itemID).getImage();
        this.itemName = ItemDatabase.getItemByID(itemID).getItemName();
        this.price = ItemDatabase.getItemByID(itemID).getPrice();
        this.description = ItemDatabase.getItemByID(itemID).getDescription();
        this.OrderQuantity = ItemDatabase.getItemByID(itemID).getOrderQuantity();
    }

    public Item(int itemID, int image, String itemName, double price, String description, int OrderQuantity) {
        this.itemID = itemID;
        this.image = image;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.OrderQuantity = OrderQuantity;
    }


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) { this.itemID = itemID; }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        OrderQuantity = orderQuantity;
    }


}
