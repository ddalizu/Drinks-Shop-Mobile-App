package com.example.apt3060;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admindashboard extends AppCompatActivity {

    Button viewOrdersButton;
    Button viewInventoryButton;
    Button generateReportsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);

        viewOrdersButton = findViewById(R.id.viewOrdersButton);
        viewInventoryButton = findViewById(R.id.viewInventoryButton);
        generateReportsButton = findViewById(R.id.generateReportsButton);

        viewOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this, vieworders.class);
                startActivity(intent);
            }
        });

        viewInventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this, viewinventory.class);
                startActivity(intent);
            }
        });

        generateReportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this, generatereports.class);
                startActivity(intent);
            }
        });
    }
}
