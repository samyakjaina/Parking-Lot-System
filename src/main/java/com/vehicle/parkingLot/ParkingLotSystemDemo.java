package com.vehicle.parkingLot;

import com.vehicle.parkingLot.enums.VehicleType;
import com.vehicle.parkingLot.model.Cell;
import com.vehicle.parkingLot.model.Floor;
import com.vehicle.parkingLot.model.Ticket;
import com.vehicle.parkingLot.model.Vehicle;
import com.vehicle.parkingLot.strategy.fee.FlatRateFeeStrategy;
import com.vehicle.parkingLot.strategy.search.BestFitStrategy;
import com.vehicle.parkingLot.strategy.search.ParkingStrategy;

public class ParkingLotSystemDemo {

	public static void main(String[] args) {
		ParkingLotSystem system = ParkingLotSystem.getInstance();

		Floor floorFirst = new Floor("1", "P1");
		floorFirst.addCell(new Cell("P1-B1", VehicleType.BIKE));
		floorFirst.addCell(new Cell("P1-C1", VehicleType.CAR));
		floorFirst.addCell(new Cell("P1-T1", VehicleType.TRUCK));

		Floor floorSecond = new Floor("2", "P2");
		floorSecond.addCell(new Cell("P2-B1", VehicleType.BIKE));
		floorSecond.addCell(new Cell("P2-C1", VehicleType.CAR));
		floorSecond.addCell(new Cell("P2-T1", VehicleType.TRUCK));

		Floor floorThird = new Floor("3", "P3");
		floorThird.addCell(new Cell("P3-B1", VehicleType.BIKE));
		floorThird.addCell(new Cell("P3-C1", VehicleType.CAR));
		floorThird.addCell(new Cell("P3-C2", VehicleType.CAR));

		system.addFloor(floorFirst);
		system.addFloor(floorSecond);
		system.addFloor(floorThird);
		system.setParkingStrategy(null);

		system.displayAvailablity();

		Vehicle vehicle = system.createVehicle("RG01-1785", "8003940321", VehicleType.BIKE);

		system.findParkingSpot(vehicle, new BestFitStrategy());
		system.displayAvailablity();
		Integer price = system.unparkVehicle(vehicle.getRegNumber(), new FlatRateFeeStrategy());
		System.out.println("Amount Paid :  " + price);

	}

}
