package com.example.apt3060;


import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.DocumentReference;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class FireStoreManager {
    public final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void recordSale(String customerId, String branch, List<SaleItem> saleItems, double v) {
        Sale sale = new Sale(customerId, branch, saleItems, calculateTotalAmount(saleItems));
        db.collection("Sales").add(sale)
                .addOnSuccessListener(documentReference -> {
                    for (SaleItem item : saleItems) {
                        updateDrinkQuantityTransaction(item.getDrinkId(), item.getQuantity());
                    }
                })
                .addOnFailureListener(e -> Log.e("FirestoreManager", "Error recording sale", e));
    }

    private void updateDrinkQuantityTransaction(String drinkId, int quantity) {
        db.runTransaction(transaction -> {
            DocumentReference drinkRef = db.collection("Drinks").document(drinkId);
            Drink drink = transaction.get(drinkRef).toObject(Drink.class);
            if (drink != null) {
                int newQuantity = drink.getQuantity() - quantity;
                transaction.update(drinkRef, "quantity", newQuantity);
            }
            return null;
        }).addOnFailureListener(e -> Log.e("FirestoreManager", "Error updating drink quantity", e));
    }

    public void addDummySalesData() {
        // Example SaleItem data
        SaleItem item1 = new SaleItem("D001", 2, 5.99);
        SaleItem item2 = new SaleItem("D002", 1, 3.49);
        SaleItem item3 = new SaleItem("D003", 3, 4.99);

        // Example Sales data
        List<SaleItem> saleItems1 = Arrays.asList(item1, item2);
        List<SaleItem> saleItems2 = Arrays.asList(item3);

        Sale sale1 = new Sale("C001", "Branch 1", saleItems1, calculateTotalAmount(saleItems1));
        Sale sale2 = new Sale("C002", "Branch 2", saleItems2, calculateTotalAmount(saleItems2));

        // Add the sales to the Firestore
        db.collection("Sales").add(sale1)
                .addOnSuccessListener(documentReference -> Log.d("FirestoreManager", "Dummy sale added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.e("FirestoreManager", "Error adding dummy sale", e));

        db.collection("Sales").add(sale2)
                .addOnSuccessListener(documentReference -> Log.d("FirestoreManager", "Dummy sale added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.e("FirestoreManager", "Error adding dummy sale", e));
    }


    public double calculateTotalAmount(List<SaleItem> saleItems) {
        double total = 0;
        for (SaleItem item : saleItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }



    // Update the quantity of a specific drink using transactions

    // Get all drinks from the drinks collection
    public void getDrinks(FirestoreCallback<List<Drink>> callback) {
        db.collection("Drinks").get()
                .addOnSuccessListener(snapshot -> {

                    List<Drink> drinks = snapshot.toObjects(Drink.class);
                    callback.onSuccess(drinks);
                    Log.d("FirestoreManager", "Fetched drinks: " + drinks);
                })
                .addOnFailureListener(e -> {
                    Log.e("FirestoreManager", "Error getting drinks", e);
                    callback.onFailure(e);
                });
    }

    public void getSales(FirestoreCallback<List<Sale>> callback) {
        db.collection("Sales").get()
                .addOnSuccessListener(snapshot -> {
                    List<Sale> sales = new ArrayList<>();
                    for (QueryDocumentSnapshot document : snapshot) {
                        try {
                            Sale sale = document.toObject(Sale.class);
                            sales.add(sale);
                        } catch (RuntimeException e) {
                            Log.e("FirestoreManager", "Error parsing sale document: " + document.getId(), e);
                        }
                    }
                    callback.onSuccess(sales);
                })
                .addOnFailureListener(e -> {
                    Log.e("FirestoreManager", "Error getting sales", e);
                    callback.onFailure(e);
                });
    }





    // Generate a sales report
    public void generateSalesReport(FirestoreCallback<Map<String, Object>> callback) {
        db.collection("sales").get()
                .addOnSuccessListener(snapshot -> {
                    List<Sale> sales = snapshot.toObjects(Sale.class);
                    Map<String, Object> report = new HashMap<>();
                    double totalSales = 0.0;

                    for (Sale sale : sales) {
                        for (SaleItem item : sale.getItems()) {
                            String drinkName = item.getDrinkId();
                            double amount = item.getPrice() * item.getQuantity();
                            totalSales += amount;

                            if (report.containsKey(drinkName)) {
                                report.put(drinkName, (double) report.get(drinkName) + amount);
                            } else {
                                report.put(drinkName, amount);
                            }
                        }
                    }

                    report.put("totalSales", totalSales);
                    callback.onSuccess(report);
                })
                .addOnFailureListener(e -> {
                    Log.e("FirestoreManager", "Error generating sales report", e);
                    callback.onFailure(e);
                });
    }

    // Request restock of a specific drink
    public void requestRestock(String drinkName) {
        Map<String, String> restockRequest = new HashMap<>();
        restockRequest.put("drinkName", drinkName);
        restockRequest.put("status", "requested");

        db.collection("restock_requests").add(restockRequest)
                .addOnSuccessListener(documentReference -> Log.d("FirestoreManager", "Restock requested for: " + drinkName))
                .addOnFailureListener(e -> Log.e("FirestoreManager", "Error requesting restock", e));
    }

    // Get current inventory

    public interface FirestoreCallback<T> {
        void onSuccess(T result);
        void onFailure(Exception e);
    }
}
