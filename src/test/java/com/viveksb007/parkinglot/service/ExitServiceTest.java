package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.exceptions.ParkingException;
import com.viveksb007.parkinglot.models.Car;
import com.viveksb007.parkinglot.models.ParkingLot;
import com.viveksb007.parkinglot.models.Slot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ExitServiceTest {

    @Test
    public void shouldBeAbleToDeallocateSlot() {
        ParkingLot parkingLot = createParkingLot();
        ExitService exitService = new ExitService(parkingLot);
        Slot slot = exitService.deallocateSlot(1);
        assertEquals(1, slot.getSlotNumber());
    }

    @Test(expectedExceptions = ParkingException.class)
    public void shouldThrowExceptionIfSlotNumberIsInvalid() {
        ParkingLot parkingLot = createParkingLot();
        ExitService exitService = new ExitService(parkingLot);
        exitService.deallocateSlot(10);
    }

    @Test(expectedExceptions = ParkingException.class)
    public void shouldThrowExceptionIfSlotIsUnOccupied() {
        ParkingLot parkingLot = createParkingLot();
        ExitService exitService = new ExitService(parkingLot);
        exitService.deallocateSlot(5);
    }

    private ParkingLot createParkingLot() {
        ParkingLot parkingLot = new ParkingLot(5);
        EntryService entryService = new EntryService(parkingLot);
        for (int i = 1; i <= 4; i++) {
            entryService.allocateSlot(new Car("C" + i, "DL" + i));
        }
        return parkingLot;
    }

}
