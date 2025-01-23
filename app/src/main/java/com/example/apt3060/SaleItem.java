package com.example.apt3060;

public class SaleItem {
    private String drinkId;
    private int quantity;
    private double price;

    // Default constructor (required for Firestore)
    public SaleItem() {}

    // Parameterized constructor
    public SaleItem(String drinkId, int quantity, double price) {
        this.drinkId = drinkId;
        this.quantity = quantity;
        this.price = price;
    }



    // Getters and setters
    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
