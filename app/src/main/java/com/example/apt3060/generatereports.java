package com.example.apt3060;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class generatereports extends AppCompatActivity {

    private TextView headquarterSalesValue;
    private TextView nairobiSalesValue;
    private TextView kisumuSalesValue;
    private TextView mombasaSalesValue;
    private TextView totalCompanySalesValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatereports);

        // Initialize views
        TextView headquarterLabel = findViewById(R.id.headquarter_label);
        TextView headquarterSales = findViewById(R.id.headquarter_sales);
        headquarterSalesValue = findViewById(R.id.headquarter_sales_value);

        TextView nairobiLabel = findViewById(R.id.nairobi_label);
        TextView nairobiSales = findViewById(R.id.nairobi_sales);
        nairobiSalesValue = findViewById(R.id.nairobi_sales_value);

        TextView kisumuLabel = findViewById(R.id.kisumu_label);
        TextView kisumuSales = findViewById(R.id.kisumu_sales);
        kisumuSalesValue = findViewById(R.id.kisumu_sales_value);

        TextView mombasaLabel = findViewById(R.id.mombasa_label);
        TextView mombasaSales = findViewById(R.id.mombasa_sales);
        mombasaSalesValue = findViewById(R.id.mombasa_sales_value);

        TextView totalCompanySalesLabel = findViewById(R.id.total_company_sales_label);
        totalCompanySalesValue = findViewById(R.id.total_company_sales_value);


        // Example data
        headquarterSalesValue.setText("1000.00");
        nairobiSalesValue.setText("250.00");
        kisumuSalesValue.setText("300.00");
        mombasaSalesValue.setText("400.00");
        totalCompanySalesValue.setText("1950.00");
    }
}