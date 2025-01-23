package com.example.apt3060;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private Button btnCheckout;
    private ArrayList<Drink> selectedDrinks;
    private String branchName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recycler_view_cart);
        btnCheckout = findViewById(R.id.btn_checkout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve selected drinks from intent
        Intent intent = getIntent();
        selectedDrinks = intent.getParcelableArrayListExtra("selectedDrinks");
        branchName = intent.getStringExtra("branch");

        // Calculate total price
        final double[] totalPrice = {0};
        if (selectedDrinks != null) {
            for (Drink drink : selectedDrinks) {
                totalPrice[0] += drink.getQuantity() * drink.getPrice();
            }
        }

        // Log received data
        if (selectedDrinks != null) {
            Log.d("Cart", "Received Drinks Count: " + selectedDrinks.size());
            for (Drink drink : selectedDrinks) {
                Log.d("Cart", "Drink: " + drink.getName() + ", Quantity: " + drink.getQuantity());
            }
        } else {
            Log.d("Cart", "No drinks received.");
        }

        // Check if the list is not null and not empty
        if (selectedDrinks != null && !selectedDrinks.isEmpty()) {
            // Convert selectedDrinks to ReceiptItems
            ArrayList<ReceiptItem> orderItems = new ArrayList<>();
            for (Drink drink : selectedDrinks) {
                ReceiptItem item = new ReceiptItem(drink.getName(), drink.getQuantity(), drink.getPrice());
                orderItems.add(item);
            }

            // Set the adapter
            cartAdapter = new CartAdapter(this, selectedDrinks);
            recyclerView.setAdapter(cartAdapter);

            // Show a Toast message with the number of items
            Toast.makeText(this, "Items in Cart: " + selectedDrinks.size(), Toast.LENGTH_LONG).show();

            // Handle checkout button click
            btnCheckout.setOnClickListener(v -> {
                Intent checkoutIntent = new Intent(Cart.this, Checkout.class);
                checkoutIntent.putExtra("branch", branchName);
                checkoutIntent.putExtra("totalPrice", totalPrice[0]); // Pass the total price
                checkoutIntent.putExtra("order_items", orderItems); // Pass the orderItems
                startActivity(checkoutIntent);
            });
        } else {
            // Show a Toast message if no items are found
            Toast.makeText(this, "Cart is empty", Toast.LENGTH_LONG).show();
        }
    }
}
