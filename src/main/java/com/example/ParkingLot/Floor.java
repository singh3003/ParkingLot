package com.example.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private int floorNumber;
    private List<Slot> slotList;
    private String parkingName;


    Floor(int slotCount, int floorNumber, String parkingLotName) {
        this.floorNumber = floorNumber;
        this.parkingName = parkingLotName;
        slotList = new ArrayList<Slot>();
        for(int i = 0; i < Math.min(slotCount, 1); i++) {
            slotList.add(i, new Slot(floorNumber, i, "TRUCK"));
        }
        for(int i = 1; i < Math.min(slotCount, 3); i++) {
            slotList.add(i, new Slot(floorNumber, i, "BIKE"));
        }
        for(int i = 3; i < slotCount; i++) {
            slotList.add(i, new Slot(floorNumber, i, "CAR"));
        }
    }

    int getFreeCount(String vehicleType) {
        int freeCount = 0;
        for(int i = 0; i < slotList.size(); i++) {
            if(slotList.get(i).getBooked().equals(Boolean.FALSE) && slotList.get(i).getSlotType().equals(vehicleType)) {
                freeCount++;
            }
        }
        return freeCount;
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(int i =0;i<slotList.size();i++){
            Slot slot = slotList.get(i);
            if(slot.getBooked().equals(Boolean.FALSE) && slot.getSlotType().equals(vehicle.getVehicleType())) {
                slot.setBooked(Boolean.TRUE);
                slot.setVehicle(vehicle);
                System.out.println("Parked Vehicle. Ticket ID: " + parkingName + slot.generateTicketId());
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(int slotNumber){
        if(slotList.get(slotNumber).getBooked()){
            Vehicle vehicle = slotList.get(slotNumber).freeVehicle();
            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getVehicleNumber() + " and Color "
                    + vehicle.getColor());
            return true;
        }
        return false;
    }

    public void diplayFreeSlots(String vehicleType){
        boolean printed = false;
        for(int i = 0; i < slotList.size(); i++) {
            Slot currentSlot = slotList.get(i);
            if(currentSlot.getSlotType().equals(vehicleType) && currentSlot.getBooked().equals(Boolean.FALSE)) {
                if(printed) {
                    System.out.print(",");
                }
                printed = true;
                System.out.print(currentSlot.getSlotNumber() + 1);
            }
        }
    }

    public void diplayOccupiedSlots(String vehicleType) {
        boolean print  = false;
        for(int i =0;i<slotList.size();i++){
            Slot slot = slotList.get(i);

            if(slot.getBooked().equals(Boolean.TRUE) && slot.getVehicle().getVehicleType().equals(vehicleType)){
                if(print){
                    System.out.print(",");
                }
                print = true;
                System.out.print(slot.getSlotNumber() + 1);
            }
        }
        System.out.println();
    }

    public List<Slot> getSlotList() {
        return slotList;
    }


}
