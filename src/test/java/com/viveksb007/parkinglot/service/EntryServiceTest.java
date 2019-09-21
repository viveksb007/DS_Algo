package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.models.Car;
import com.viveksb007.parkinglot.models.ParkingLot;
import com.viveksb007.parkinglot.models.Slot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EntryServiceTest {

    private EntryService entryService;

    @Test
    public void shouldBeAbleToAllocateSlotToCar() {
        entryService = new EntryService(new ParkingLot(5));
        Car myCar = new Car("BLACK", "DL01");
        Slot allocatedSlot = entryService.allocateSlot(myCar);
        assertEquals(1, allocatedSlot.getSlotNumber());
        Car secondCar = new Car("BLUE", "DL02");
        allocatedSlot = entryService.allocateSlot(secondCar);
        assertEquals(2, allocatedSlot.getSlotNumber());
    }

    @Test
    public void shouldReturnInvalidSlotIfParkingLotFull() {
        entryService = new EntryService(new ParkingLot(5));
        for (int i = 1; i <= 5; i++) {
            Car car = new Car("C" + i, "DL" + i);
            Slot slot = entryService.allocateSlot(car);
            assertEquals(i, slot.getSlotNumber());
        }
        Car lastCar = new Car("C6", "DL06");
        Slot slot = entryService.allocateSlot(lastCar);
        assertEquals(-1, slot.getSlotNumber());
    }

}
