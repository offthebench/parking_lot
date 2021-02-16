package com.gojek.strategy;

import com.gojek.entity.Slot;
import com.gojek.entity.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    Integer createParingSlots(Long numberOfSlots);
    Slot park(Vehicle vehicle);
    Slot unPark(Long slotNumber);
    List<Slot> status();
    List<Vehicle> getAllVehiclesByColor(String color);
    Slot getParkingSlotByRegistrationNumber(String registrationNumber);
    List<Slot> getReservedSlotsByVehicleColor(String color);
    List<Slot> getUnreservedParkingSlots();
}
