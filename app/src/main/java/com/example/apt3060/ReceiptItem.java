package com.example.apt3060;

import java.io.Serializable;

public class ReceiptItem implements Serializable {
    private final String drinkName;
    private final int quantity;
    private final double price;

    public ReceiptItem(String drinkName, int quantity, double price) {
        this.drinkName = drinkName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
