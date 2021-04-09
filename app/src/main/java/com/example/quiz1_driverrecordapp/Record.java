package com.example.quiz1_driverrecordapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Record extends AppCompatActivity {
    final static int ENTER_RECORD=1;

    EditText etSearch;
    TextView tvName, tvEmail, tvCarPlate;
    ImageView ivPhone, ivMap;
    Button btnAddDriver,btnSearch;
    View showLayout;
    Drivers d_selected=new Drivers();
    ArrayList<Drivers> drivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        init();
        btnAddDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Record.this,com.example.quiz1_driverrecordapp.EnterRecord.class);
                startActivityForResult(intent,ENTER_RECORD);

                btnSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String search= etSearch.getText().toString();
                        if(search.isEmpty()) {
                           Toast.makeText(Record.this, "Enter Number Plate", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Boolean flag=false;
                            for (Drivers d : MyData.drivers) {
                                if (search.equals(d.getCarPlate())) {
                                    d_selected=d;
                                    display();
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag)
                            Toast.makeText(Record.this, "Driver For this Car Number Plate Does not Exist!!!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                ivPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(d_selected.getPhone()==null) {
                            Intent intent1 = new Intent(Intent.ACTION_DIAL);
                            startActivity(intent1);
                        }
                        else
                        {
                            Intent intent1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+d_selected.getPhone()));
                            startActivity(intent1);
                        }
                    }
                });
                ivMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (d_selected.getAddress() == null) {
                            Intent intent1 = new Intent(Intent.ACTION_DIAL);
                            startActivity(intent1);
                        } else {
                            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 0,0?q=" + d_selected.getAddress()));
                            startActivity(intent1);
                        }
                    }
                });
            }

        });
    }
        private void display() {
        showLayout.setVisibility(View.VISIBLE);
        tvName.setText("Name: "+d_selected.getName());
        tvEmail.setText("Email Address: "+d_selected.getEmail());
        tvCarPlate.setText("Car Plate Number: "+d_selected.getCarPlate());
        }


    private void init() {
        btnAddDriver=findViewById(R.id.btnAddDriver);
        etSearch=findViewById(R.id.etSearch);
        btnSearch=findViewById(R.id.btnSearch);
        drivers=new ArrayList<>();
        ivMap=findViewById(R.id.ivMap);
        ivPhone=findViewById(R.id.ivPhone);
        tvCarPlate=findViewById(R.id.tvCarPlate);
        tvEmail=findViewById(R.id.tvEmail);
        tvName=findViewById(R.id.tvName);
        showLayout= this.<View>findViewById(R.id.showLayout);
        showLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ENTER_RECORD)
        {
            if(resultCode==RESULT_OK)
            {
                Drivers d=new Drivers(
                        data.getStringExtra("Name"),
                        data.getStringExtra("Email"),
                        data.getStringExtra("Phone"),
                        data.getStringExtra("Address"),
                        data.getStringExtra("CarPlate"));
                MyData.addDriver(d);
                Toast.makeText(this, R.string.Record_Successfully_Entered, Toast.LENGTH_SHORT).show();


            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, R.string.Record_Not_Entered, Toast.LENGTH_SHORT).show();
            }
        }
    }

}