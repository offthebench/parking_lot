package com.gojek.entity;

public class CompactVehicleSlot extends Slot {

    private Long slotNumber;

    public CompactVehicleSlot(Long slotNumber) {
        super(slotNumber);
        this.slotNumber = slotNumber;
    }

    @Override
    public int compareTo(Slot slot) {
        return this.getSlotNumber().compareTo(slot.getSlotNumber());
    }

    @Override
    public Long getSlotNumber() {
        return slotNumber;
    }
}
