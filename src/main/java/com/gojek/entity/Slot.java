package com.gojek.entity;

abstract public class Slot implements Comparable<Slot> {

    private boolean isOccupied;
    protected Long slotNumber;
    protected Vehicle vehicle;

    public Slot(Long slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Long getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
