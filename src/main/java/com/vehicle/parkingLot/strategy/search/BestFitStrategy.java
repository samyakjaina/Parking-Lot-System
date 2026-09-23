package com.vehicle.parkingLot.strategy.search;

import java.util.List;
import java.util.Optional;

import com.vehicle.parkingLot.model.Cell;
import com.vehicle.parkingLot.model.Floor;
import com.vehicle.parkingLot.model.Vehicle;

public class BestFitStrategy implements ParkingStrategy {

	@Override
	public Optional<Cell> findSpot(List<Floor> floors, Vehicle vehicle) {
		Optional<Cell> bestSpot = Optional.empty();

		for (Floor floor : floors) {
			Optional<Cell> cell = floor.availableSpot(vehicle);

			if (bestSpot.isEmpty() || bestSpot.get().getType().ordinal() > cell.get().getType().ordinal()) {
				bestSpot = cell;
			}
		}
		return bestSpot;
	}

}
