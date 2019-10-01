package src.com.albaycan.cardealership.data;

import java.util.List;

import src.com.albaycan.cardealership.domain.CarRent;

public interface RentACarRepository {

	void rentACar(CarRent carRent) throws Exception;
	void returnACar(int carId) throws Exception;
	// List<CarRent> listRentedCars();
	List<CarRent> listCarsWillBeReturned() throws Exception;
}
