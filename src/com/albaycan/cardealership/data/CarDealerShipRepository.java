package src.com.albaycan.cardealership.data;

import java.util.List;

import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.Status;

public interface CarDealerShipRepository {
	
	int addCar(Car car) throws Exception;
	void modifyCar(int choice, String choiceStr) throws Exception;
	boolean carExist(int choice) throws Exception;
	boolean checkModification(int choice, String choiceStr) throws Exception;
	List<Car> listAllCars() throws Exception;
	Car getCar(int choice) throws Exception;
	void statusUpdate(int choice, Status status) throws Exception;

}
