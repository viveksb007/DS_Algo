package com.viveksb007.parkinglot.models;

public class Car {

    private String color;
    private String registrationNumber;

    public Car(String color, String registrationNumber) {
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
