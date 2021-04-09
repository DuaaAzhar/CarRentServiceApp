package com.example.quiz1_driverrecordapp;

import android.app.Application;

import java.util.ArrayList;

public class MyData extends Application {
    static ArrayList<Drivers> drivers;

    @Override
    public void onCreate() {
        super.onCreate();
        drivers=new ArrayList<>();
    }
    public static void addDriver(Drivers d){
        drivers.add(d);
    }

}
