package com.vehicle.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vehicle.parkingLot.enums.VehicleType;
import com.vehicle.parkingLot.model.Bike;
import com.vehicle.parkingLot.model.Car;
import com.vehicle.parkingLot.model.Cell;
import com.vehicle.parkingLot.model.Floor;
import com.vehicle.parkingLot.model.Ticket;
import com.vehicle.parkingLot.model.Truck;
import com.vehicle.parkingLot.model.Vehicle;
import com.vehicle.parkingLot.model.VehicleObservor;
import com.vehicle.parkingLot.strategy.fee.FeeStrategy;
import com.vehicle.parkingLot.strategy.search.ParkingStrategy;

public class ParkingLotSystem extends VehicleObservor {

	private static volatile ParkingLotSystem INSTANCE = null;
	private List<Floor> floors;
	private ParkingStrategy parkingStrategy;
	private Map<String, Ticket> activeTickets;

	private ParkingLotSystem() {
		this.activeTickets = new HashMap<>();
		this.floors = new ArrayList<>();
		this.parkingStrategy = null;
	}

	public static ParkingLotSystem getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ParkingLotSystem();
		}
		return INSTANCE;
	}

	public ParkingStrategy getParkingStrategy() {
		return parkingStrategy;
	}

	public void setParkingStrategy(ParkingStrategy parkingStrategy) {
		this.parkingStrategy = parkingStrategy;
	}

	public void addFloor(Floor floor) {
		floors.add(floor);
	}

	public void addTicket(String vehicleNumber, Ticket ticket) {
		this.activeTickets.put(vehicleNumber, ticket);
	}

	public Vehicle createVehicle(String regNumber, String phoneNumber, VehicleType type) {
		if (type.equals(VehicleType.BIKE)) {
			return new Bike(regNumber, phoneNumber);
		} else if (type.equals(VehicleType.CAR)) {
			return new Car(regNumber, phoneNumber);
		} else {
			return new Truck(regNumber, phoneNumber);
		}
	}

	public Optional<Ticket> findParkingSpot(Vehicle vehicle, ParkingStrategy parkingStrategy) {

		Optional<Cell> cell = parkingStrategy.findSpot(floors, vehicle);
		if (cell.isEmpty()) {
			System.out.println("Cell is not Available . Please try after some time");
			return Optional.empty();
		}
		Cell cur = cell.get();
		cur.parkVehicle(vehicle);
		Ticket ticket = new Ticket(vehicle, null, cur, null);
		addTicket(vehicle.getRegNumber(), ticket);
		addListener(ticket);
		update("Parking allocated ");
		return Optional.of(ticket);
	}

	public Integer unparkVehicle(String vehicleNumber, FeeStrategy feeStrategy) {

		Ticket ticket = activeTickets.get(vehicleNumber);
		if (ticket == null) {
			System.out.println("Ticket not found");
			return 0;
		}
		Integer priceToPay = feeStrategy.calculateFee(ticket);
		System.out.println("Amount to pay : " + priceToPay);
		update("Amount to pay : " + priceToPay);
		ticket.getCell().unParkVehicle();
		removeListener(ticket);
		return priceToPay;
	}

	public void displayAvailablity() {
		List<Floor> floors = this.floors.stream().filter(floor -> !floor.isFilled()).collect(Collectors.toList());
		for (Floor floor : floors) {
			Map<VehicleType, Long> map = floor.getCells().entrySet().stream()
					.filter(entry -> !entry.getValue().isOccupied())
					.collect(Collectors.groupingBy(entry -> entry.getValue().getType(), Collectors.counting()));

			System.out.println("On the floor : " + floor.getFloorName());
			for (VehicleType size : VehicleType.values()) {
				System.out.printf("  %s spots: %d\n", size, map.getOrDefault(size, 0L));
			}
		}

	}

}
