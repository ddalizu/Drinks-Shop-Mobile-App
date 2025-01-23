package com.example.apt3060;

public class CartItem {
    private final String type;
    private final String name;
    private final int quantity;
    private final String price;

    public CartItem(String type, String name, int quantity, String price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }
}
