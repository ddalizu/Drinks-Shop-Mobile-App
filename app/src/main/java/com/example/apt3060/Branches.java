package com.example.apt3060;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Branches extends AppCompatActivity {
    ImageButton btn_logout;
    Button btn_HQ,btn_nairobi,btn_kisumu,btn_mombasa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_branches);

        btn_HQ=findViewById(R.id.btn_HQ);
        btn_HQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Branches.this, Headquarters.class);
                intent.putExtra("branch", "Headquarters");
                startActivity(intent);
            }
        });

        btn_kisumu=findViewById(R.id.btn_kisumu);
        btn_kisumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Branches.this, Kisumu.class);
                intent.putExtra("branch", "Kisumu");
                startActivity(intent);
            }
        });

        btn_nairobi=findViewById(R.id.btn_nairobi);
        btn_nairobi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Branches.this, Nairobi.class);
                intent.putExtra("branch", "Nairobi");
                startActivity(intent);
            }
        });

        btn_mombasa=findViewById(R.id.btn_mombasa);
        btn_mombasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Branches.this, Mombasa.class);
                intent.putExtra("branch", "Mombasa");
                startActivity(intent);
            }
        });
        btn_logout=findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Branches.this, userLogin.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}



