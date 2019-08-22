package src.com.albaycan.cardealership.service;

import java.util.ArrayList;
import java.util.List;

import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.ModificationType;
import src.com.albaycan.cardealership.domain.Status;

public class CarDealerShipImp implements CarDealerShip {

	List<Car> carList = new ArrayList<>();
	
	@Override
	public void addCar(Car car) {
		
		carList.add(car);		

	}

	@Override
	public void modifyCar(int choice, String choiceStr) {
		
		Car car = getCar(choice);
		
		List<ModificationType> modification =car.getModification();
		modification.add(ModificationType.valueOf(choiceStr));
		car.setModification(modification);
		carList.removeIf(i->i.getId()==choice);
		addCar(car);

	}

	@Override
	public List<Car> listAllCars() {
		
		return carList;		

	}

	@Override
	public Car getCar(int choice) {
		
		Car car = carList.stream().filter(i -> i.getId()==choice).findFirst().get();
		
		return car;
	}

	@Override
	public void statusUpdate(int choice, Status status) {
		
		Car car = getCar(choice);
		car.setStatus(status);
		
	}

}
