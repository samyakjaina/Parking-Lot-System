package com.vehicle.parkingLot.strategy.search;

import java.util.List;
import java.util.Optional;

import com.vehicle.parkingLot.model.Cell;
import com.vehicle.parkingLot.model.Floor;
import com.vehicle.parkingLot.model.Vehicle;

public interface ParkingStrategy {
	Optional<Cell> findSpot(List<Floor> floors, Vehicle vehicle);
}
