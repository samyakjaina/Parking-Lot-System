package com.vehicle.parkingLot.strategy.fee;

import com.vehicle.parkingLot.model.Ticket;

public interface FeeStrategy {

	Integer calculateFee(Ticket ticket);

}
