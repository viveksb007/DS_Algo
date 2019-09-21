package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.exceptions.ParkingException;
import com.viveksb007.parkinglot.models.ParkingLot;
import com.viveksb007.parkinglot.models.Slot;

import java.util.List;

public class ExitService {

    private ParkingLot parkingLot;

    public ExitService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Slot deallocateSlot(int slotNumber) {
        List<Slot> slotList = parkingLot.getSlots();

        if (slotNumber >= slotList.size()) {
            throw new ParkingException("Invalid slot to deallocate");
        }

        Slot allocatedSlot = slotList.get(slotNumber - 1);
        if (!allocatedSlot.isOccupied()) {
            throw new ParkingException("Slot number is unoccupied");
        }

        allocatedSlot.setOccupied(false);
        allocatedSlot.setCarParked(null);
        return allocatedSlot;
    }

}
