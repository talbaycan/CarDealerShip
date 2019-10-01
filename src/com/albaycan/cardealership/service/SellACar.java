package src.com.albaycan.cardealership.service;

import java.util.List;

import src.com.albaycan.cardealership.domain.CarSell;

public interface SellACar {
	
	void sellACar(CarSell carSell) throws Exception;
	List<CarSell> listSoldCars() throws Exception;


}
