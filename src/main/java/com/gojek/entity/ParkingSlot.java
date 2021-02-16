package com.gojek.entity;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ParkingSlot {

    private static ParkingSlot instance;
    private PriorityQueue<Slot> parkingSlots;
    private HashMap<Long, Slot> reservedSlots;

    private ParkingSlot() {
        parkingSlots = new PriorityQueue<>();
        reservedSlots = new HashMap<>();
    }

    public static ParkingSlot getInstance() {
        if (instance == null) {
            instance = new ParkingSlot();
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
