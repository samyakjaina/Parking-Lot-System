package com.vehicle.parkingLot.model;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Floor {

	private String id;
	private String floorName;
	private Map<String, Cell> cells;
	private boolean isFilled;

	public Floor(String id, String floorName) {
		super();
		this.id = id;
		this.floorName = floorName;
		this.cells = new ConcurrentHashMap<>();
		this.isFilled = false;
	}

	public void clearCell() {
		cells.clear();
	}

	public void addCell(Cell cell) {
		cells.put(cell.getId(), cell);
	}

	public void removeCell(Cell cell) {
		cells.remove(cell.getId());
	}

	public Map<String, Cell> getCells() {
		return cells;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	@Override
	public String toString() {
		return "Floor [id=" + id + ", floorName=" + floorName + ", cells=" + cells + ", isFilled=" + isFilled + "]";
	}

	public Optional<Cell> availableSpot(Vehicle vehicle) {

		return this.cells.entrySet().stream()
				.filter(entry -> !entry.getValue().isOccupied() && entry.getValue().canFitVehicle(vehicle))
				.map(entry -> entry.getValue()).sorted(Comparator.comparing(Cell::getType)).findFirst();
	}

}
