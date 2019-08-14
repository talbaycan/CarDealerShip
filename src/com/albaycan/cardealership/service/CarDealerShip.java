package com.albaycan.cardealership.service;

import java.util.List;

import com.albaycan.cardealership.domain.Car;

public interface CarDealerShip {

	void addCar(Car car);
	void modifyCar(int choice, String choiceStr);
	List<Car> listAllCars();
	Car getCar(int choice);
	void statusUpdate(int choice, String status);
	
}
