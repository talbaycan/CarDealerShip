package src.com.albaycan.cardealership.service;

import java.util.List;

import src.com.albaycan.cardealership.domain.CarRent;

public interface RentACar {

	void rentACar(CarRent carRent);
	void returnACar(int carId);
	List<CarRent> listRentedCars();
	List<CarRent> listCarsWillBeReturned();
}
