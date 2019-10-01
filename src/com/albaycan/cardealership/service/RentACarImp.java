package src.com.albaycan.cardealership.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import src.com.albaycan.cardealership.data.RentACarRepository;
import src.com.albaycan.cardealership.data.RentACarRepositoryImp;
import src.com.albaycan.cardealership.domain.CarRent;

public class RentACarImp implements RentACar {
	
	List<CarRent> rentedCars = new ArrayList<CarRent>();
	
	RentACarRepository rentACarRepository = new RentACarRepositoryImp();

	@Override
	public void rentACar(CarRent carRent) throws Exception {
		
		rentACarRepository.rentACar(carRent);
		// rentedCars.add(carRent);

	}

	@Override
	public void returnACar(int carId) throws Exception {
		
		rentACarRepository.returnACar(carId);

	}

	/*
	@Override
	public List<CarRent> listRentedCars() {
	
		return rentedCars;
	}

	*/
	
	@Override
	public List<CarRent> listCarsWillBeReturned() throws Exception {
		
		List<CarRent> carsWillBeReturned = rentACarRepository.listCarsWillBeReturned();
		
		/*
		List<CarRent> carsWillBeReturned = new ArrayList<CarRent>();
		
		for (CarRent rentedCar: rentedCars) {

			LocalDateTime returnDate = rentedCar.getRentStartDate().plusDays(rentedCar.getTotalRentDay());
			
			LocalDateTime date1 = returnDate.minus(Period.ofDays(7));
			LocalDateTime date2 = LocalDateTime.now();
			int diff = date2.compareTo(date1);
			
			if (diff>=0) {
				
				carsWillBeReturned.add(rentedCar);				
			}						
		}			
			
		*/
		return carsWillBeReturned;
	}

	}
