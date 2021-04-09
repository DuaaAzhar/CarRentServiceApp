package com.example.quiz1_driverrecordapp;

public class Drivers {
    String Name;
    String Email;
    String Phone;
    String Address;
    String CarPlate;

    public Drivers(String name, String email, String phone, String address, String carPlate) {
        Name = name;
        Email = email;
        Phone = phone;
        Address = address;
        CarPlate = carPlate;
    }

    public Drivers() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public void setCarPlate(String carPlate) {
        CarPlate = carPlate;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone=" + Phone +
                ", Address='" + Address + '\'' +
                ", CarPlate='" + CarPlate + '\'' +
                '}';
    }
}
