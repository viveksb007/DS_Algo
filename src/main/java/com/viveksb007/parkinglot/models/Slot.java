package com.viveksb007.parkinglot.models;

public class Slot {

    private int slotNumber;
    private boolean isOccupied;
    private Car carParked;

    Slot() {
    }

    public Slot(int slotNumber, boolean isOccupied, Car car) {
        this.slotNumber = slotNumber;
        this.isOccupied = isOccupied;
        this.carParked = car;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public Car getCarParked() {
        return carParked;
    }

    public void setCarParked(Car carParked) {
        this.carParked = carParked;
    }
}
