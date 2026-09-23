package com.vehicle.parkingLot.model;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleObservor {

	List<Listener> list = new ArrayList<>();

	public void addListener(Listener listener) {
		list.add(listener);
	}

	public void removeListener(Listener listener) {
		list.remove(listener);
	}

	public void update(String str) {
		System.out.println("Updating the Subject ");
		for (Listener listener : list) {
			listener.update(str);
		}
	}

}
