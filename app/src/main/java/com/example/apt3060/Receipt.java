package com.example.apt3060;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Receipt extends AppCompatActivity {

    private TextView txtBranchName, txtTotalPrice;
    private RecyclerView recyclerViewOrderList;
    private ReceiptAdapter receiptAdapter;
    private ArrayList<ReceiptItem> orderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        txtBranchName = findViewById(R.id.txt_branch_name);
        txtTotalPrice = findViewById(R.id.txt_total_price);
        recyclerViewOrderList = findViewById(R.id.recycler_view_order_list);

        // Get data from Intent
        Intent intent = getIntent();
        String branchName = intent.getStringExtra("branch_name");
        double totalPrice = intent.getDoubleExtra("total_price", 0);
        orderItems = (ArrayList<ReceiptItem>) intent.getSerializableExtra("order_items");

        txtBranchName.setText(branchName != null && !branchName.isEmpty() ? branchName : "Branch not specified");
        txtTotalPrice.setText("Total: KSHS " + totalPrice);

        // Set up RecyclerView
        recyclerViewOrderList.setLayoutManager(new LinearLayoutManager(this));
        receiptAdapter = new ReceiptAdapter(orderItems);
        recyclerViewOrderList.setAdapter(receiptAdapter);
    }
}
