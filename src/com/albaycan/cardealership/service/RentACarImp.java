package com.albaycan.cardealership.service;

import java.util.ArrayList;
import java.util.List;

import com.albaycan.cardealership.domain.CarRent;

public class RentACarImp implements RentACar {
	
	List<CarRent> rentedCars = new ArrayList<>();
	

	@Override
	public void rentACar(CarRent carRent) {
		
		rentedCars.add(carRent);

	}

	@Override
	public void returnACar(int carId) {
		

	}

	@Override
	public List<CarRent> listRentedCars() {
	
		return rentedCars;
	}

	@Override
	public List<CarRent> listCarsWillBeReturned() {
		
		List<CarRent> carsWillBeReturned = null;
		
		return carsWillBeReturned;
	}


}
