package com.example.quiz1_driverrecordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    final int EnterRecord_Activty=1;
    EditText etUsername, etPassword;
    Button btnLogin, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()){
                    Intent intent=new Intent(LoginActivity.this, com.example.quiz1_driverrecordapp.EnterRecord.class);
                    startActivityForResult(intent, EnterRecord_Activty);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsername.setText("");
                etPassword.setText("");
            }
        });
    }

    private Boolean validation() {
        Boolean check=true;
        String username= etUsername.getText().toString().trim();
        String password=etPassword.getText().toString();
        if(username.isEmpty() && username!="Manager")
        {
            etUsername.setError("Invalid Username");
            check=false;
        }
        else if(password.isEmpty() && password!="Manager")
        {
            etUsername.setError("Invalid Password");
            check=false;
        }
        return check;
    }

    private void init() {
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnCancel=findViewById(R.id.btnCancel);
    }
}