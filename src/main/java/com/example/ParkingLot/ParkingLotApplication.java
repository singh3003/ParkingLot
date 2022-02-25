package com.example.ParkingLot;


import java.io.*;

public class ParkingLotApplication {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/klbairwa/Documents/ParkingLot.txt"));
		PrintStream printStream = new PrintStream(new FileOutputStream("/Users/klbairwa/Documents/ParkingOutput.txt"));
		System.setOut(printStream);
		System.out.println("reading data from file");
		String[] input;
		input = bufferedReader.readLine().trim().split("\\s+");
		ParkingLot parkingLot = null;
		while (!input[0].equals("exit")) {
			System.out.println("input "+input[0]);
			switch (input[0]) {
				case "create_parking_lot" :
					parkingLot = new ParkingLot(input[1], Integer.parseInt(input[2]),Integer.parseInt(input[3]));
					break;
				case "display" :
					switch ((input[1])) {
						case "free_count":
							if(parkingLot != null){
								parkingLot.displayFreeCount(input[2]);
							}
							break;
						case "free_slots":
							if(parkingLot != null){
								parkingLot.displayFreeSlot(input[2]);
							}
							break;
						case "occupied_slots":
							if(parkingLot != null){
								parkingLot.displayOccupiedSlot(input[2]);
							}
							break;
						default:
							System.out.println("Invalid request");
							break;
					}
					break;
				case "park_vehicle" :
					Vehicle vehicle = new Vehicle(input[2], input[3], input[1]);
					if(parkingLot!= null) {
						parkingLot.parkVehicle(vehicle);
					}
					break;
				case "unpark_vehicle" :
					if(parkingLot != null) {
						parkingLot.unParkVehicle(input[1]);
					}
					break;
				default:
					System.out.println("Invalid Request");
			}
			input = bufferedReader.readLine().trim().split("\\s+");
		}
	}

}
