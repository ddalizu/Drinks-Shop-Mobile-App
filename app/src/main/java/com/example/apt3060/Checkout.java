package com.example.apt3060;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {

    private TextView txtBranchName, txtTotalPrice;
    private Button btnCheckout;
    private RadioGroup radioGroupPaymentMethod;
    private RadioButton radioCreditCard, radioMpesa;
    private LinearLayout layoutCreditCard, layoutMpesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        txtBranchName = findViewById(R.id.txt_branch_name);
        txtTotalPrice = findViewById(R.id.txt_total_price);
        btnCheckout = findViewById(R.id.btn_checkout);

        radioGroupPaymentMethod = findViewById(R.id.radioGroup_payment_method);
        radioCreditCard = findViewById(R.id.radio_credit_card);
        radioMpesa = findViewById(R.id.radio_mpesa);

        layoutCreditCard = findViewById(R.id.layout_credit_card);
        layoutMpesa = findViewById(R.id.layout_mpesa);

        // Get data from Intent
        Intent intent = getIntent();
        String branchName = intent.getStringExtra("branch");
        double totalPrice = intent.getDoubleExtra("totalPrice", 0);
        ArrayList<ReceiptItem> orderItems = (ArrayList<ReceiptItem>) intent.getSerializableExtra("order_items");

        txtBranchName.setText(branchName != null && !branchName.isEmpty() ? "Branch: " + branchName : "Branch not specified");
        txtTotalPrice.setText("Total Price: " + totalPrice);

        // Set default view
        updatePaymentDetails();

        // Listener for radio button selection
        radioGroupPaymentMethod.setOnCheckedChangeListener((group, checkedId) -> updatePaymentDetails());

        // Checkout button click listener
        btnCheckout.setOnClickListener(v -> {
            Intent intentReceipt = new Intent(Checkout.this, Receipt.class);
            intentReceipt.putExtra("branch_name", branchName);
            intentReceipt.putExtra("total_price", totalPrice);
            intentReceipt.putExtra("order_items", orderItems); // Pass orderItems to Receipt
            startActivity(intentReceipt);
        });
    }

    // Method to update payment details section visibility
    private void updatePaymentDetails() {
        if (radioCreditCard.isChecked()) {
            layoutCreditCard.setVisibility(LinearLayout.VISIBLE);
            layoutMpesa.setVisibility(LinearLayout.GONE);
        } else if (radioMpesa.isChecked()) {
            layoutCreditCard.setVisibility(LinearLayout.GONE);
            layoutMpesa.setVisibility(LinearLayout.VISIBLE);
        }
    }
}
