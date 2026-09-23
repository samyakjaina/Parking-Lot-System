package com.vehicle.parkingLot.strategy.fee;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.vehicle.parkingLot.model.Ticket;
import com.vehicle.parkingLot.model.Vehicle;

public class FlatRateFeeStrategy implements FeeStrategy {

	@Override
	public Integer calculateFee(Ticket ticket) {
		Vehicle vehicle = ticket.getVehicle();
		long hours = ChronoUnit.HOURS.between(vehicle.getAllocatedTime(), LocalTime.now());

		return new Integer((int) hours) * vehicle.getRate();
	}

}
