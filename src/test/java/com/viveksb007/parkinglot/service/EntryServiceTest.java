package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.models.Car;
import com.viveksb007.parkinglot.models.ParkingLot;
import com.viveksb007.parkinglot.models.Slot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EntryServiceTest {

    private EntryService entryService;

    @BeforeClass
    public void setUp() {
        ParkingLot parkingLot = new ParkingLot(5);
        entryService = new EntryService(parkingLot);
    }

    @Test
    public void shouldBeAbleToAllocateSlotToCar() {
        Car myCar = new Car("BLACK", "DL01");
        Slot allocatedSlot = entryService.allocateSlot(myCar);
        assertEquals(1, allocatedSlot.getSlotNumber());
        Car secondCar = new Car("BLUE", "DL02");
        allocatedSlot = entryService.allocateSlot(secondCar);
        assertEquals(2, allocatedSlot.getSlotNumber());
    }

}
