package com.gojek.entity;

import com.gojek.enums.VehicleType;

public class Car extends Vehicle {

    public Car() {
        this.vehicleType = VehicleType.COMPACT;
    }
}
