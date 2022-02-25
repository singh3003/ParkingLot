package com.example.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingLot {

    private String parkingLotName;
    private List<Floor> floorList;

    ParkingLot(String parkingLotName, int floorCount, int slotCountPerFloor) {
        this.parkingLotName = parkingLotName;
        floorList = new ArrayList<>();
        for(int i = 0;i<floorCount;i++){
            floorList.add(i, new Floor(slotCountPerFloor, i, parkingLotName));
        }
        System.out.println("Created parking lot with " + floorCount + " floors and " + slotCountPerFloor + " slots per floor");

    }

    public void displayFreeCount(String vehicleType) {
        for(int i = 0; i < floorList.size(); i++) {
            int freeCount = floorList.get(i).getFreeCount(vehicleType);
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + (i + 1) + ": " + freeCount);
        }
        }



    public void displayFreeSlot(String vehicleType) {
        for(int i = 0; i < floorList.size(); i++) {
            System.out.print("Free slots for " + vehicleType + " on Floor " + (i + 1) + ": ");
            floorList.get(i).diplayFreeSlots(vehicleType);
        }
    }

    public void displayOccupiedSlot(String vehicleType) {
        int bound = floorList.size();
        IntStream.range(0, bound).forEach(i -> {
            System.out.print("Occupied slots for " + vehicleType + " on Floor " + (i + 1) + ": ");
            floorList.get(i).diplayOccupiedSlots(vehicleType);
        });
    }

    public void parkVehicle(Vehicle vehicle){
        for (Floor floor : floorList) {
            if (floor.parkVehicle(vehicle)) {
                return;
            }
        }
        System.out.println("Parking Lot is full.");
        return;
    }

    public void unParkVehicle(String ticketNumber){
        String[] arr = ticketNumber.split("_");
        int floorNumber = Integer.parseInt(arr[1]);
        int slotNumber = Integer.parseInt(arr[2]);
        if(arr[0].equals(parkingLotName) && floorNumber < floorList.size() && slotNumber < floorList.get(0).getSlotList().size()){
            if(floorList.get(floorNumber).unparkVehicle(slotNumber)){
                return;
            }
        }
        System.out.println("Invalid Ticket");
        return;
    }

}
