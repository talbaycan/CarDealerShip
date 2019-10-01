package src.com.albaycan.cardealership.service;

import java.util.ArrayList;
import java.util.List;

import src.com.albaycan.cardealership.data.CarDealerShipRepository;
import src.com.albaycan.cardealership.data.CarDealerShipRepositoryImp;
import src.com.albaycan.cardealership.data.ConnectDB;
import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.ModificationType;
import src.com.albaycan.cardealership.domain.Status;

public class CarDealerShipImp implements CarDealerShip {
	
	CarDealerShipRepository carDealerShipRepository = new CarDealerShipRepositoryImp();
		
	List<Car> carList = new ArrayList<>();
	
	@Override
	public int addCar(Car car) throws Exception {
		
		int id = carDealerShipRepository.addCar(car);
		// carList.add(car);		
		return id;
	}

	
	@Override
	public void modifyCar(int choice, String choiceStr) throws Exception {
		
		carDealerShipRepository.modifyCar(choice, choiceStr);
		
		/*
		Car car = getCar(choice);
		
		List<ModificationType> modification =car.getModification();			
			
		modification.add(ModificationType.valueOf(choiceStr));
		car.setModification(modification);
		carList.removeIf(i->i.getId()==choice);
		addCar(car);			
		*/
	}

	@Override
	public List<Car> listAllCars() throws Exception {
		
		return carDealerShipRepository.listAllCars();
		// return carList;		

	}

	@Override
	public Car getCar(int choice) throws Exception {
		
		Car car = carDealerShipRepository.getCar(choice);
	
		
		// Car car = carList.stream().filter(i -> i.getId()==choice).findFirst().get();
		
		return car;
	}

	@Override
	public void statusUpdate(int choice, Status status) throws Exception {
		
		// Car car = getCar(choice);
		// car.setStatus(status);
		
		carDealerShipRepository.statusUpdate(choice, status);
		
		
	}

	@Override
	public boolean checkModification(int choice, String choiceStr) throws Exception {
		/*
		Car car = getCar(choice);
		
		List<ModificationType> modification =car.getModification();
		
		return modification.stream().anyMatch(x -> x == ModificationType.valueOf(choiceStr));
		*/
		return carDealerShipRepository.checkModification(choice, choiceStr);
	}

	@Override
	public boolean carExist(int choice) throws Exception {
		
		//return carList.stream().anyMatch(x -> x.getId() == choice);
		return carDealerShipRepository.carExist(choice);
	}


}
