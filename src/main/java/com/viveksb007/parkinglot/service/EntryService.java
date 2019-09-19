package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.models.Car;
import com.viveksb007.parkinglot.models.ParkingLot;
import com.viveksb007.parkinglot.models.Slot;

import java.util.List;

public class EntryService {

    private ParkingLot parkingLot;

    public EntryService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Slot allocateSlot(Car car) {
        List<Slot> slots = this.parkingLot.getSlots();
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.setOccupied(true);
                slot.setCarParked(car);
                return slot;
            }
        }
        return new Slot(-1, false, null);
    }
}
