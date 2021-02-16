package com.gojek.entity;

import com.gojek.enums.VehicleType;

abstract public class Vehicle {
    protected String registrationNumber;
    protected String color;
    protected VehicleType vehicleType;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
