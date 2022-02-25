package com.example.ParkingLot;

public class Slot {

    private int slotNumber;
    private int floorNumber;
    private String slotType;
    private Vehicle vehicle;
    private Boolean isBooked;


    Slot(int floorNumber, int slotNumber, String slotType) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        isBooked = false;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    Vehicle freeVehicle(){
        isBooked= false;
        Vehicle tempVehicle = vehicle;
        setVehicle(null);
        return tempVehicle;
    }

    String generateTicketId(){
        return floorNumber + "_" + slotNumber;
    }
}
