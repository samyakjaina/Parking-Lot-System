package com.vehicle.parkingLot.strategy.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.vehicle.parkingLot.model.Cell;
import com.vehicle.parkingLot.model.Floor;
import com.vehicle.parkingLot.model.Vehicle;

public class FarthestFirstStrategy implements ParkingStrategy {

	@Override
	public Optional<Cell> findSpot(List<Floor> floors, Vehicle vehicle) {
		List<Floor> reversedFloors = new ArrayList<>(floors);
		Collections.reverse(reversedFloors);

		for (Floor floor : reversedFloors) {
			Optional<Cell> spot = floor.availableSpot(vehicle);
			if (spot.isPresent()) {
				return spot;
			}
		}
		return Optional.empty();
	}

}
