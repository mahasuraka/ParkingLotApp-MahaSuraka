package service;

import model.*;
import java.util.*;

public class ParkingLotService {

    private List<ParkingSlot> slots = new ArrayList<>();

    public void createParkingLot(int n) {
        int smallCount = (int)(n * 0.5);
        int largeCount = (int)(n * 0.3);
        int oversizeCount = n - smallCount - largeCount;

        int id = 1;

        for(int i = 0; i < smallCount; i++) {
            slots.add(new ParkingSlot(id++, SlotSize.SMALL));
        }
        for(int i = 0; i < largeCount; i++) {
            slots.add(new ParkingSlot(id++, SlotSize.LARGE));
        }
        for(int i = 0; i < oversizeCount; i++) {
            slots.add(new ParkingSlot(id++, SlotSize.OVERSIZE));
        }

        System.out.println("Created parking lot with " + n + " slots.");
    }

    public void parkVehicle(String plate, VehicleType type) {
        for(ParkingSlot slot : slots) {
            if(!slot.isOccupied() && matches(slot.getSize(), type)) {
                slot.park(new Vehicle(plate, type));
                System.out.println("Parked vehicle " + plate + " in slot " + slot.getId());
                return;
            }
        }
        System.out.println("No available slot for this vehicle type.");
    }

    private boolean matches(SlotSize slot, VehicleType vehicle) {
        switch(vehicle) {
            case SMALL:
                return true;  // can park anywhere: SMALL, LARGE, OVERSIZE
            case LARGE:
                return slot == SlotSize.LARGE || slot == SlotSize.OVERSIZE;
            case OVERSIZE:
                return slot == SlotSize.OVERSIZE;
            default:
                return false;
        }
    }    

    public void exitVehicle(String plate) {
        for(ParkingSlot slot : slots) {
            if(slot.isOccupied() && slot.getParkedVehicle().getLicensePlate().equals(plate)) {
                slot.clear();
                System.out.println("Vehicle " + plate + " exited from slot " + slot.getId());
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void displayStatus() {
        System.out.println("\nParking Lot Status:");
        for(ParkingSlot slot : slots) {
            if(slot.isOccupied()) {
                System.out.println("Slot " + slot.getId() + " (" + slot.getSize() + "): " +
                        slot.getParkedVehicle().getLicensePlate());
            } else {
                System.out.println("Slot " + slot.getId() + " (" + slot.getSize() + "): EMPTY");
            }
        }
        System.out.println();
    }
}
