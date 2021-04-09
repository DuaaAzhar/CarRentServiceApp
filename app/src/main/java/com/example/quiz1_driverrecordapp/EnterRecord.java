package com.example.quiz1_driverrecordapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterRecord extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etAddress, etCarPlate;
    Button btnEnterRecord,btnCancel;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_record);
        init();
        btnEnterRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=etName.getText().toString().trim();
                String Email=etEmail.getText().toString().trim();
                String Phone=etPhone.getText().toString().trim();
                String Address=etAddress.getText().toString().trim();
                String CarPlate=etCarPlate.getText().toString().trim();
                if(checkValidation())
                {
                    Intent intent=new Intent();
                    intent.putExtra("Name", Name);
                    intent.putExtra("Email", Email);
                    intent.putExtra("Phone", Phone);
                    intent.putExtra("Address", Address);
                    intent.putExtra("CarPlate", CarPlate);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void init() {
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        etAddress=findViewById(R.id.etAddress);
        etCarPlate=findViewById(R.id.etCarPlate);
        btnEnterRecord=findViewById(R.id.btnEnterRecord);
        btnCancel=findViewById(R.id.btnCancel);

    }
    private boolean checkValidation() {
        boolean valid=true;
        if(etName.getText().toString().isEmpty()) {
            etName.setError("Enter Name");
            valid=false;
        }
        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("Enter Email address");
            valid=false;
        }
        if(etPhone.getText().toString().isEmpty()){
            etPhone.setError("Enter Phone Number");
            valid=false;
        }
        if(etAddress.getText().toString().isEmpty()){
            etAddress.setError("Enter Address");
            valid=false;
        }
        if(etCarPlate.getText().toString().isEmpty()){
            etCarPlate.setError("Enter Car Plate Number");
            valid=false;
        }
        return valid;
    }


}