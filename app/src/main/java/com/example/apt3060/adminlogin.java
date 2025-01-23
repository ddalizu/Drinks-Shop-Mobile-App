package com.example.apt3060;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060.R;
import com.example.apt3060.admindashboard;

public class adminlogin extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("a") && password.getText().toString().equals("1")) {
                    Toast.makeText(adminlogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(adminlogin.this, admindashboard.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(adminlogin.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}