package model;

public class ParkingSlot {
    private int id;
    private SlotSize size;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(int id, SlotSize size) {
        this.id = id;
        this.size = size;
        this.occupied = false;
    }

    public int getId() {
        return id;
    }

    public SlotSize getSize() {
        return size;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
    }

    public void clear() {
        this.parkedVehicle = null;
        this.occupied = false;
    }
}
