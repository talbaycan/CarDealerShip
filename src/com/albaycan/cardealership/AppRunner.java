package com.albaycan.cardealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.albaycan.cardealership.domain.Car;
import com.albaycan.cardealership.service.CarDealerShip;
import com.albaycan.cardealership.service.CarDealerShipImp;

public class AppRunner {

	static Scanner input = new Scanner(System.in);
	static int choice; 
	static String choiceStr;
	static double choiceDbl;
	
	static CarDealerShip carDealerShip = new CarDealerShipImp();

	public static void main(String[] args) {
		
		do {
		
		System.out.println(mainMenuText());
		
		choice = input.nextInt();					
			
		switch (choice) {
		case 1:
			carDealerShipManager();		
			break;
		case 2:
			sellACarManager();			
			break;
		case 3:
			rentACarManager();			
			break;
		 default:
		     System.out.println("Your selection is not in the menu, please select again");
		     break;
		}
		
		} while(choice!=1 && choice!=2 && choice!=3);
		
	}

	public static String mainMenuText() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nPlease select 1 of these:\n\n");
		sb.append("1. Car DealerShip Manager\n");
		sb.append("2. Sell a car Manager\n");
		sb.append("3. Rent a Car Manager\n");
		
		return sb.toString();
	}
	
	public static String dealershipMenuText() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Welcome to Car DealerShip Manager Menu\n");
		sb.append("Please select 1 of these:\n\n");
		sb.append("1. Add New Car\n");
		sb.append("2. Modify Car\n");
		sb.append("3. List All Cars\n");
		
		return sb.toString();
	}

	public static String sellingMenuText() {
	
		StringBuilder sb = new StringBuilder();
	
		sb.append("Welcome to Sell a Car Manager Menu\n");
		sb.append("Please select 1 of these:\n\n");
		sb.append("1. Sell a Car\n");
		sb.append("2. List All Salable Cars\n");
	
		return sb.toString();
	}

	public static String rentingMenuText() {
	
		StringBuilder sb = new StringBuilder();
		
		sb.append("Welcome to Rent a Car Manager Menu\n");
		sb.append("Please select 1 of these:\n\n");
		sb.append("1. Rent a Car\n");
		sb.append("2. Return a Car\n");
		sb.append("3. List all the Cars which will be available in a Week\n");
		
		return sb.toString();
	}
	
	public static void carDealerShipManager() {
		
		do {
		
		System.out.println(dealershipMenuText());
		choice = input.nextInt();
		
		switch (choice) {
		case 1:
			addCar();		
			break;
		case 2:
			modifyCar();			
			break;
		case 3:
			listAllCars();			
			break;
		 default:
		     System.out.println("Your selection is not in the menu, please select again");
		     break;
		}
		
		} while (choiceStr.equals("B"));
					
	}
	
	public static String addCar() {
		
		System.out.println("Please write Car's Make:");
		choiceStr = input.next();
					
		String make= choiceStr;
		
		System.out.println("Please write Car's Model:");
		choiceStr = input.next();
					
		String model= choiceStr;
		
		System.out.println("Please write Car's Fuel Type:");
		choiceStr = input.next();
			
		String fuel= choiceStr;		
		
		System.out.println("Please write Car's RRP:");
		choiceDbl = input.nextDouble();
			
		double RRP = choiceDbl;
		
		System.out.println("Please write Car's DailyRentPrice:");
		choiceDbl = input.nextDouble();
			
		double dailyRentPrice = choiceDbl;
		
		System.out.println("Please write Car's Transmission:");
		choiceStr = input.next();
			
		String transmission= choiceStr;
		
		System.out.println("Please write Car's Registration Year:");
		choiceStr = input.next();
			
		String registrationYear= choiceStr;
		
		System.out.println("Please write Car's Colour:");
		choiceStr = input.next();
			
		String colour= choiceStr;
	
		System.out.println("Please write Car's Modification:");
		choiceStr = input.next();
		input.nextLine();
					
		List<String> modification = new ArrayList<String>();
		modification.add(choiceStr);
		
		System.out.println("Please write Car's Status:");
		choiceStr = input.next();
			
		String status= choiceStr;
		
		Car car= new Car(make, model, fuel, RRP, dailyRentPrice, transmission, registrationYear, colour, modification, status);
		
		carDealerShip.addCar(car);
		
		System.out.printf("The car has been added to the system with %d id\n\n", car.getId());
		
		System.out.println("Press 'B' to go back to Car DealerShip Manager Menu");
		return choiceStr = input.next();
		
	}
	
	public static void modifyCar() {
		
		System.out.println("Please write the ID of the car you would like to modify:");
		choice = input.nextInt();
		
		Car car = carDealerShip.getCar(choice);
		
		System.out.printf("Please write the Modification for %s %s:", car.getMake(), car.getModel());
		choiceStr = input.next();
		
		carDealerShip.modifyCar(choice, choiceStr);
	}
	
	public static void listAllCars() {
		
		List<Car> carList = carDealerShip.listAllCars();
		
		//make, model, fuel, RRP, dailyRentPrice, transmission, registrationYear, status
		
		System.out.println("***********List of All The Cars************\n\n");
		System.out.println("------|--------------|--------------|----------|--------|-----|----------|------|------------|-------\n");
				
		for(Car car:carList) {
			System.out.printf("|%-8d|%-12s|%-12s|%-8s|%-f|%-f|%-8s|%-6s|%-12s|\n", car.getId(), car.getMake(), car.getModel(), car.getFuel(), car.getRRP()
				, car.getDailyRentPrice(), car.getTransmission(), car.getRegistrationYear(), car.getStatus());
		}
		
	}
	
	public static void sellACarManager() {
		
		System.out.println(sellingMenuText());
					
	}
	
	public static void rentACarManager() {
		
		System.out.println(rentingMenuText());
					
	}
}
