package com.vehicle.parkingLot.model;

import java.time.LocalTime;
import java.util.UUID;

import com.vehicle.parkingLot.enums.VehicleType;

public class Car implements Vehicle {

	private String id;
	private String regNumber;
	private String phoneNumber;
	private VehicleType type;
	private Integer rate;
	private LocalTime allocatedTime;
	private Integer vehicleRate;

	public Car(String regNumber, String phoneNumber) {
		super();
		this.id = UUID.randomUUID().toString();
		this.regNumber = regNumber;
		this.phoneNumber = phoneNumber;
		this.type = VehicleType.CAR;
		this.rate = 100;
		this.allocatedTime = LocalTime.now();
		this.vehicleRate = 350;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public LocalTime getAllocatedTime() {
		return allocatedTime;
	}

	public void setAllocatedTime(LocalTime allocatedTime) {
		this.allocatedTime = allocatedTime;
	}

	public Integer getVehicleRate() {
		return vehicleRate;
	}

	public void setVehicleRate(Integer vehicleRate) {
		this.vehicleRate = vehicleRate;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", regNumber=" + regNumber + ", phoneNumber=" + phoneNumber + ", type=" + type
				+ ", rate=" + rate + ", allocatedTime=" + allocatedTime + ", vehicleRate=" + vehicleRate + "]";
	}

}