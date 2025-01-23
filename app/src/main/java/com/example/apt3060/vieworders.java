package com.example.apt3060;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class vieworders extends AppCompatActivity {

    private RecyclerView recyclerViewOrders;
    private recyclerAdapter ordersAdapter;
    private List<Sale> saleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vieworders);

        // Initialize FirestoreManager
        FireStoreManager firestoreManager = new FireStoreManager();

        // Add dummy sales data to Firestore
        firestoreManager.addDummySalesData();

        recyclerViewOrders = findViewById(R.id.recyclerViewOrders);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));

        saleList = new ArrayList<>();
        ordersAdapter = new recyclerAdapter(saleList);
        recyclerViewOrders.setAdapter(ordersAdapter);

        fetchOrders();
    }

    private void fetchOrders() {
        FireStoreManager firestoreManager = new FireStoreManager();
        firestoreManager.getSales(new FireStoreManager.FirestoreCallback<List<Sale>>() {
            @Override
            public void onSuccess(List<Sale> sales) {
                saleList.clear();
                saleList.addAll(sales);
                ordersAdapter.notifyDataSetChanged();
                for (Sale sale : sales) {
                    Log.d("vieworders", "Sale: " + sale.getItems());
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("vieworders", "Failed to fetch sales.", e);
            }
        });
    }
}
