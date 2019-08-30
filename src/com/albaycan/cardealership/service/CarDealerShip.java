package src.com.albaycan.cardealership.service;

import java.util.List;

import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.Status;

public interface CarDealerShip {

	void addCar(Car car);
	void modifyCar(int choice, String choiceStr);
	boolean carExist(int choice);
	boolean checkModification(int choice, String choiceStr);
	List<Car> listAllCars();
	Car getCar(int choice);
	void statusUpdate(int choice, Status status);
	
}
