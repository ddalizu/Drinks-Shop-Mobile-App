package com.example.apt3060;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class viewinventory extends AppCompatActivity {

    private FireStoreManager firestoreManager;
    private List<Drink> drinkList;
    private InventoryAdapter inventoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewinventory);

        firestoreManager = new FireStoreManager();
        drinkList = new ArrayList<>();
        inventoryAdapter = new InventoryAdapter(drinkList);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewInventory);
        recyclerView.setAdapter(inventoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // Set LayoutManager

        fetchInventory();
    }

    private void fetchInventory() {
        firestoreManager.getDrinks(new FireStoreManager.FirestoreCallback<List<Drink>>() {
            @Override
            public void onSuccess(List<Drink> drinks) {
                if (drinks != null) {
                    drinkList.clear();
                    drinkList.addAll(drinks);
                    inventoryAdapter.notifyDataSetChanged();
                    for (Drink drink : drinks) {
                        Log.d("ViewInventoryActivity", "Drink: " + drink.getName() + ", Price: " + drink.getPrice() + ", Quantity: " + drink.getQuantity());
                    }
                } else {
                    Log.d("ViewInventoryActivity", "No drinks found.");
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("ViewInventoryActivity", "Failed to fetch inventory.", e);
            }
        });
    }
}
