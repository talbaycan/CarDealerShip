package src.com.albaycan.cardealership.data;

import java.util.List;

import src.com.albaycan.cardealership.domain.CarSell;

public interface SellACarRepository {
	
	void sellACar(CarSell carSell) throws Exception;
	List<CarSell> listSoldCars() throws Exception;


}
