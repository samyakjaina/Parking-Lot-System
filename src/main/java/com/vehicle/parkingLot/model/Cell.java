package com.vehicle.parkingLot.model;

import com.vehicle.parkingLot.enums.VehicleType;

public class Cell {

	private String id;
	private boolean isOccupied;
	private Vehicle vehicle;
	private VehicleType type;

	public Cell(String id, VehicleType type) {
		super();
		this.id = id;
		this.isOccupied = false;
		this.type = type;
		this.vehicle = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void parkVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		setOccupied(true);
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Cell [id=" + id + ", isOccupied=" + isOccupied + ", vehicle=" + vehicle + ", type=" + type + "]";
	}

	public void unParkVehicle() {
		this.vehicle = null;
		this.isOccupied = false;
	}

	public boolean canFitVehicle(Vehicle vehicle) {
		if (isOccupied)
			return false;

		switch (vehicle.getType()) {
		case BIKE:
			return type == VehicleType.BIKE;
		case CAR:
			return type == VehicleType.CAR || type == VehicleType.TRUCK;
		case TRUCK:
			return type == VehicleType.TRUCK;
		default:
			return false;
		}
	}
}
