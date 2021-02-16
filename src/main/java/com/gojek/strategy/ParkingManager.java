package com.gojek.strategy;

import com.gojek.entity.ParkingSlot;
import com.gojek.entity.Slot;
import com.gojek.entity.Vehicle;
import com.gojek.exception.ParkingLotException;

import java.util.*;
import java.util.stream.Collectors;

import static com.gojek.constants.Constants.*;

public class ParkingManager implements ParkingStrategy {

    private static ParkingManager instance;

    private ParkingManager() {
    }

    public static ParkingManager getInstance() {
        if (instance == null) {
            instance = new ParkingManager();
        }

        return instance;
    }

    @Override
    public Integer createParingSlots(Long numberOfSlots) {
        return ParkingSlot.getInstance().createParkingSlots(numberOfSlots);
    }

    @Override
    public Slot park(Vehicle vehicle) {
        PriorityQueue<Slot> parkingSlots = getPriorityQueue();

        if (parkingSlots.isEmpty()) {
            throw new ParkingLotException(SORRY_PARKING_LOT_IS_FULL);
        }
        Slot nearestEmptyParkingSlot =  parkingSlots.poll();
        nearestEmptyParkingSlot.setOccupied(true);
        nearestEmptyParkingSlot.setVehicle(vehicle);

        HashMap<Long, Slot> reservedSlots = ParkingSlot.getInstance().getReservedSlots();
        reservedSlots.put(nearestEmptyParkingSlot.getSlotNumber(), nearestEmptyParkingSlot);

        return nearestEmptyParkingSlot;
    }

    @Override
    public Slot unPark(Long slotNumber) {
        PriorityQueue<Slot> parkingSlots = getPriorityQueue();
        HashMap<Long, Slot> reservedSlots = ParkingSlot.getInstance().getReservedSlots();

        if (!reservedSlots.containsKey(slotNumber)) {
            throw new ParkingLotException(NOT_FOUND);
        }

        Slot slot = reservedSlots.get(slotNumber);
        slot.setOccupied(false);
        slot.setVehicle(null);
        parkingSlots.add(slot);
        reservedSlots.remove(slot.getSlotNumber());

        return slot;
    }

    @Override
    public List<Slot> status() {
        HashMap<Long, Slot> reservedSlots = ParkingSlot.getInstance().getReservedSlots();
        return new ArrayList<>(reservedSlots.values());
    }

    @Override
    public List<Vehicle> getAllVehiclesByColor(String color) {
        HashMap<Long, Slot> reservedSlots = ParkingSlot.getInstance().getReservedSlots();
        return reservedSlots
                .values()
                .stream()
                .filter(slot -> slot.getVehicle().getColor().equals(color))
                .map(Slot::getVehicle).collect(Collectors.toList());
    }

    @Override
    public Slot getParkingSlotByRegistrationNumber(String registrationNumber) {
        HashMap<Long, Slot> reservedSlots = ParkingSlot.getInstance().getReservedSlots();
        Optional<Slot> slotOptional = reservedSlots
                .values()
                .stream()
                .filter(s -> s.getVehicle()
                        .getRegistrationNumber()
                        .equals(registrationNumber))
                .findFirst();

        if (slotOptional.isEmpty()) {
            throw new ParkingLotException(NOT_FOUND);
        }

        return slotOptional.get();
    }

    @Override
    public List<Slot> getReservedSlotsByVehicleColor(String color) {
        HashMap<Long, Slot> reservedSlots = ParkingSlot.getInstance().getReservedSlots();
        return reservedSlots
                .values()
                .stream()
                .filter(s -> s.getVehicle()
                        .getColor()
                        .equals(color))
                .collect(Collectors.toList());
    }

    @Override
    public List<Slot> getUnreservedParkingSlots() {
        PriorityQueue<Slot> parkingSlots = getPriorityQueue();
        return new ArrayList<>(parkingSlots);
    }

    private PriorityQueue<Slot> getPriorityQueue() {
        PriorityQueue<Slot> parkingSlots = ParkingSlot.getInstance().getParkingSlots();

        if (parkingSlots == null) {
            throw new ParkingLotException(NO_PARKING_LOTS_ALLOCATED);
        }

        return parkingSlots;
    }
}
