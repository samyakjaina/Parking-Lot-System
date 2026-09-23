package com.vehicle.parkingLot.model;

import java.util.UUID;

import org.springframework.validation.FieldError;

import com.vehicle.parkingLot.enums.VehicleType;
import com.vehicle.parkingLot.strategy.fee.FeeStrategy;

public class Ticket implements Listener {

	private String id;
	private Vehicle vehicle;
	private Floor floorNumber;
	private Cell cell;
	private FeeStrategy feeStrategy;

	public Ticket(Vehicle vehicle, Floor floorNumber, Cell cell, FeeStrategy feeStrategy) {
		super();
		this.id = UUID.randomUUID().toString();
		this.vehicle = vehicle;
		this.floorNumber = floorNumber;
		this.cell = cell;
		this.feeStrategy = feeStrategy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Floor getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Floor floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public FeeStrategy getFeeStrategy() {
		return feeStrategy;
	}

	public void setFeeStrategy(FeeStrategy feeStrategy) {
		this.feeStrategy = feeStrategy;
	}

	@Override
	public void update(String str) {
		System.out.println("Sending msg to this number : " + getVehicle().getPhoneNumber() + " with the msg : " + str);
	}

}
