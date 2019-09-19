package com.viveksb007.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Slot> slots;

    public ParkingLot(int n) {
        slots = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            slots.add(new Slot(i + 1, false, null));
        }
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
