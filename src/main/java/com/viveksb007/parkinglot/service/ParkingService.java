package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.exceptions.ParkingLotAlreadyCreatedException;
import com.viveksb007.parkinglot.models.Car;
import com.viveksb007.parkinglot.models.ParkingLot;
import com.viveksb007.parkinglot.models.Slot;

public class ParkingService {

    private static ParkingService parkingService;
    private ParkingLot parkingLot;
    private EntryService entryService;
    private ExitService exitService;

    private ParkingService() {
    }

    public static ParkingService getInstance() {
        if (parkingService == null) {
            parkingService = new ParkingService();
        }
        return parkingService;
    }

    public boolean createParkingLot(int n) {
        if (parkingLot != null) {
            throw new ParkingLotAlreadyCreatedException("Parking lot already created");
        }
        this.parkingLot = new ParkingLot(n);
        this.entryService = new EntryService(parkingLot);
        this.exitService = new ExitService(parkingLot);
        return true;
    }

    public String parkCar(String registrationNumber, String color) {
        Slot allocatedSlot = this.entryService.allocateSlot(new Car(registrationNumber, color));
        int allocatedSlotNumber = allocatedSlot.getSlotNumber();
        return (allocatedSlotNumber != -1) ? "Allocated Slot Number : " + allocatedSlotNumber : "No Slot left";
    }

    public String unParkCar(int slotNumber) {
        Slot deAllocatedSlot = this.exitService.deallocateSlot(slotNumber);
        return "DeAllocated slot number : " + deAllocatedSlot.getSlotNumber();
    }

}
