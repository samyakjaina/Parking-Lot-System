package com.vehicle.parkingLot.strategy.search;

import java.util.List;
import java.util.Optional;

import com.vehicle.parkingLot.model.Cell;
import com.vehicle.parkingLot.model.Floor;
import com.vehicle.parkingLot.model.Vehicle;

public class NearestFirstStrategy implements ParkingStrategy {

	@Override
	public Optional<Cell> findSpot(List<Floor> floors, Vehicle vehicle) {

		for (Floor floor : floors) {
			Optional<Cell> cell = floor.availableSpot(vehicle);

			if (cell.isPresent()) {
				return cell;
			}
		}
		return Optional.empty();
	}

}
