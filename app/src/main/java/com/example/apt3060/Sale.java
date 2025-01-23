package com.example.apt3060;

import java.util.List;

public class Sale {
    private String customerId;
    private String branch;
    private List<SaleItem> items;
    private double total;

    // Default constructor (required for Firestore)
    public Sale() {}

    // Parameterized constructor
    public Sale(String customerId, String branch, List<SaleItem> items, double total) {
        this.customerId = customerId;
        this.branch = branch;
        this.items = items;
        this.total = total;
    }

    // Getters and setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
