package com.viveksb007.parkinglot.service;

import com.viveksb007.parkinglot.exceptions.ParkingLotAlreadyCreatedException;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ParkingServiceTest {

    @Test
    public void shouldBeAbleToCreateParkingLot() {
        ParkingService parkingService = ParkingService.getInstance();
        boolean status = parkingService.createParkingLot(5);
        assertTrue(status);
    }

    @Test(expectedExceptions = ParkingLotAlreadyCreatedException.class)
    public void shouldThrowExceptionIfParkingLotAlreadyExists() {
        ParkingService parkingService = ParkingService.getInstance();
        boolean status = parkingService.createParkingLot(5);
        assertTrue(status);
        parkingService.createParkingLot(10);
    }

    @Test
    public void shouldBeAbleToParkAndUnParkCar() {
        ParkingService parkingService = ParkingService.getInstance();
        boolean status = parkingService.createParkingLot(5);
        assertTrue(status);
        String response = parkingService.parkCar("DL01", "BLACK");
        assertEquals("Allocated Slot Number : 1", response);
        response = parkingService.parkCar("DL02", "BLACK");
        assertEquals("Allocated Slot Number : 2", response);
        response = parkingService.parkCar("DL03", "BLACK");
        assertEquals("Allocated Slot Number : 3", response);
        response = parkingService.unParkCar(1);
        assertEquals("DeAllocated slot number : 1", response);
        response = parkingService.unParkCar(3);
        assertEquals("DeAllocated slot number : 3", response);
    }

}
