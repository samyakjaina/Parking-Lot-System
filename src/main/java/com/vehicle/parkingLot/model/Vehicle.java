package com.vehicle.parkingLot.model;

import java.time.LocalTime;

import com.vehicle.parkingLot.enums.VehicleType;

public interface Vehicle {
	public String getRegNumber();

	public String getPhoneNumber();

	public LocalTime getAllocatedTime();

	public Integer getRate();

	public Integer getVehicleRate();

	public VehicleType getType();
}
