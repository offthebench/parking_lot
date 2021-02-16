package com.gojek.entity;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ParkingLot {

    private static ParkingLot instance;
    private PriorityQueue<Slot> parkingSlots;
    private HashMap<Long, Slot> reservedSlots;

    private ParkingLot() {
        parkingSlots = new PriorityQueue<>();
        reservedSlots = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public int createParkingSlots(Long numberOfSlots) {
        for (long i = 1; i <= numberOfSlots; i++) {
            parkingSlots.add(new CompactVehicleSlot(i));
        }

        return parkingSlots.size();
    }

    public PriorityQueue<Slot> getParkingSlots() {
        return parkingSlots;
    }

    public HashMap<Long, Slot> getReservedSlots() {
        return reservedSlots;
    }
}
