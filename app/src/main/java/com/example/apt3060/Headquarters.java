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
import java.util.List;

public class Headquarters extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DrinkAdapter drinkAdapter;
    private List<Drink> drinkList;
    private Button btnProceedToCart;
    private String branchName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headquaters);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnProceedToCart = findViewById(R.id.btn_proceed_to_cart);

        Intent intent = getIntent();
        branchName = intent.getStringExtra("branch");

        // Initialize the drink list
        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Coca Cola", "Soft Drink", 150, 0));
        drinkList.add(new Drink("Pepsi", "Soft Drink", 140, 0));
        drinkList.add(new Drink("Fanta", "Soft Drink", 130, 0));
        drinkList.add(new Drink("Sprite", "Soft Drink", 120, 0));
        drinkList.add(new Drink("Mountain Dew", "Soft Drink", 160, 0));

        // Set the adapter
        drinkAdapter = new DrinkAdapter(this, drinkList);
        recyclerView.setAdapter(drinkAdapter);

        if (branchName != null) {
            Toast.makeText(this, "Ordering from " + branchName, Toast.LENGTH_LONG).show();
        }

        // Handle button click to proceed to cart
        btnProceedToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Headquarters.this, Cart.class);
                ArrayList<Drink> selectedDrinks = new ArrayList<>();

                for (Drink drink : drinkList) {
                    if (drink.getQuantity() > 0) {
                        selectedDrinks.add(drink);
                    }
                }

                // Log the selected drinks for debugging
                for (Drink drink : selectedDrinks) {
                    Log.d("Headquarters", "Selected Drink: " + drink.getName() + ", Quantity: " + drink.getQuantity());
                }

                intent.putParcelableArrayListExtra("selectedDrinks", selectedDrinks);
                intent.putExtra("branch", "Headquarters");
                startActivity(intent);
            }
        });
    }
}
