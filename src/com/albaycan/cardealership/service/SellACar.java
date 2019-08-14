package com.albaycan.cardealership.service;

import java.util.List;

import com.albaycan.cardealership.domain.Car;
import com.albaycan.cardealership.domain.CarSell;

public interface SellACar {
	
	void sellACar(CarSell carSell);
	List<CarSell> listSoldCars();


}
