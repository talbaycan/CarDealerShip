package src.com.albaycan.cardealership;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.CarRent;
import src.com.albaycan.cardealership.domain.CarSell;
import src.com.albaycan.cardealership.domain.CustomerCountry;
import src.com.albaycan.cardealership.domain.Make;
import src.com.albaycan.cardealership.domain.ModificationType;
import src.com.albaycan.cardealership.domain.Status;
import src.com.albaycan.cardealership.service.CarDealerShip;
import src.com.albaycan.cardealership.service.CarDealerShipImp;
import src.com.albaycan.cardealership.service.RentACar;
import src.com.albaycan.cardealership.service.RentACarImp;
import src.com.albaycan.cardealership.service.SellACar;
import src.com.albaycan.cardealership.service.SellACarImp;

public class AppRunner {

	static Scanner input = new Scanner(System.in);
	static int choice; 
	static String choiceStr;
	static double choiceDbl;
	
	static CarDealerShip carDealerShip = new CarDealerShipImp();
	static SellACar sellACar = new SellACarImp();
	static RentACar rentACar = new RentACarImp();

	public static void main(String[] args) throws Exception {		
		
		
		
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
			System.out.println("This choice was not on the menu, please make another choice");
			choiceStr = "M";
			break;
		}
		
		} while(choiceStr.equals("M"));
		
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
		
		sb.append("\nWelcome to Car DealerShip Manager Menu\n");
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
		sb.append("2. List Sold Cars\n");
	
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
	
	public static String carDealerShipManager() throws Exception {		

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
		case 4:
			addDummyCar();
			break;
		default:
			System.out.println("This choice was not on the menu, please make another choice");
			choiceStr = "B";
			break;
		
		}
		
		} while (choiceStr.equals("B"));
		
		return choiceStr;
					
	}
	
	public static String addCar() throws Exception {
		
		Make make = null;
		
		do {			
		
		System.out.println("Please write Car's Make: (AUDI, BMW, MERCEDES or PORSCHE)");
		choiceStr = input.next();
		
		if (choiceStr.equals("AUDI") || choiceStr.equals("BMW") || choiceStr.equals("MERCEDES")  || choiceStr.equals("PORSCHE")) {
		
		make= Make.valueOf(choiceStr);
		
		} else {
			System.out.println("This is NOT one of The Authorized Makes");
		}		
		
		} while (!choiceStr.equals("AUDI") && !choiceStr.equals("BMW") && !choiceStr.equals("MERCEDES")  && !choiceStr.equals("PORSCHE"));
		
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
	
		List<ModificationType> modification = new ArrayList<ModificationType>();
		
		do {

		System.out.println("Please write Car's Modification:(LEATHERSEATS, PARKSENSORS or SUNROOF)");
		choiceStr = input.next();		
		
			if (choiceStr.equals("LEATHERSEATS") || choiceStr.equals("PARKSENSORS") || choiceStr.equals("SUNROOF")) {
						
			modification.add(ModificationType.valueOf(choiceStr));
			
			} else {
				System.out.println("This is NOT one of The Authorized Modification");
			}
		
		} while (!choiceStr.equals("LEATHERSEATS") && !choiceStr.equals("PARKSENSORS") && !choiceStr.equals("SUNROOF"));
		
		Status status= Status.NEW;
		
		Car car= new Car(make, model, fuel, RRP, dailyRentPrice, transmission, registrationYear, colour, modification, status);
		
		int id = carDealerShip.addCar(car);
		
		System.out.printf("The car has been added to the system with %d id\n\n", id);
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();
		
	}
	
	public static String modifyCar() throws Exception {
		
		do {

		System.out.println("Please write the ID of the car you would like to modify:");
		choice = input.nextInt();
		
			if (carDealerShip.carExist(choice) == false) {
				System.out.println("This car is not in your stock");
			}			
			
		} while(carDealerShip.carExist(choice) == false);
		
		Car car = carDealerShip.getCar(choice);
		
		do {
		
		System.out.printf("Please write the Modification to fit your %s %s:(LEATHERSEATS, PARKSENSORS or SUNROOF)\n", car.getMake(), car.getModel());
		choiceStr = input.next();
		
		if (choiceStr.equals("LEATHERSEATS") || choiceStr.equals("PARKSENSORS") || choiceStr.equals("SUNROOF")) {
			
			if (carDealerShip.checkModification(choice, choiceStr)==false) {
				
				carDealerShip.modifyCar(choice, choiceStr);			
				System.out.printf("%s modification has been added to your %s %s\n", choiceStr, car.getMake(), car.getModel());

			} else {
				System.out.println("This modification is already fitted");
			}
			
		} else {
			
			System.out.println("This is NOT one of The Authorized Modification");		
			
		}
		
		} while (!choiceStr.equals("LEATHERSEATS") && !choiceStr.equals("PARKSENSORS") && !choiceStr.equals("SUNROOF"));
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();
	}
	
	public static String listAllCars() throws Exception {
		
		List<Car> carList = carDealerShip.listAllCars();		
		
		System.out.println("***********List of All The Cars************\n\n");
		System.out.println("------|------------|------------|--------|-------------|-----------|----------|------|------------");
		System.out.println("Id    |Make        |Model       |Fuel    |RRP          |Rent Price |Transm.   |Reg Y.|Status      ");
		System.out.println("------|------------|------------|--------|-------------|-----------|----------|------|------------");
		
		
		for(Car car:carList) {		
		
			System.out.printf("%-6d|%-12s|%-12s|%-8s|�%-10f|�%-6f|%-10s|%-6s|%-12s\n", car.getId(), car.getMake(), car.getModel(), car.getFuel(), 
					car.getRRP(), car.getDailyRentPrice(), car.getTransmission(), car.getRegistrationYear(), car.getStatus());
		}
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();
		
	}
	
	
	public static String addDummyCar() throws Exception {
							
		List<ModificationType> modification = new ArrayList<ModificationType>();
		modification.add(ModificationType.SUNROOF);
		modification.add(ModificationType.LEATHERSEATS);
		
		Car car = new Car(Make.PORSCHE, "Cayenne", "Petrol", 50000.00, 250.00, "Automatic", "2011", "Dark Blue", modification, Status.NEW);
				
		int id = carDealerShip.addCar(car);
		
		System.out.printf("Your dummy car has been added to the system with %d id\n\n", id);
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();
	}
	
	
	public static void sellACarManager() throws Exception {
		
		do {
		
		System.out.println(sellingMenuText());
		choice = input.nextInt();
		
		switch (choice) {
		
		case 1: 
			sellACar();
			break;
			
		case 2:
			listSoldCars();
			break;
		
		default:
			System.out.println("This choice was not on the menu, please make another choice");
			choiceStr = "B";
			break;
		}
		
		} while (choiceStr.equals("B"));
					
	}
	

	private static String sellACar() throws Exception {
	
			
		System.out.println("Please write the Id of the car you would like to sell:");
		choice = input.nextInt();
		
		Car car = new Car();
		
		do {
			
		car = carDealerShip.getCar(choice);
		
		if (car.getStatus().equals(Status.SOLD) || car.getStatus().equals(Status.RENTED)) {
			System.out.printf("This car is %s, please try a different car\n", car.getStatus());
			choice = input.nextInt();
		}

		} while (car.getStatus().equals(Status.SOLD) || car.getStatus().equals(Status.RENTED));
		

		System.out.printf("You are selling a %s %s\n", car.getMake(), car.getModel());
		System.out.printf("It's RRP is %f, how much you would like to sell it for?\n",car.getRRP());
		double sellPrice = input.nextDouble();
		
		System.out.println("Customer Name:");		
		String customerName = input.next();
		
		System.out.println("Customer Address:");
		String customerAddress = input.next();
		
		System.out.println("Customer Postcode:");
		String customerPostCode = input.next();
		
		System.out.println("Customer Country: (UNITEDKINGDOM, USA OR FRANCE)");
		String customerCountryStr = input.next();
		CustomerCountry customerCountry = CustomerCountry.valueOf(customerCountryStr);
		
		System.out.println("Customer Phone:");
		String customerPhone = input.next();
		
		System.out.println("Customer Email:");
		String customerEmail = input.next();
		
		CarSell carSell = new CarSell(choice, sellPrice, customerName, customerAddress, customerPostCode, customerCountry, customerPhone, customerEmail);
		
			
		sellACar.sellACar(carSell);
		
		Status status = Status.SOLD;
		carDealerShip.statusUpdate(choice, status);
		
		System.out.printf("You have sold the %s %s to %s\n", car.getMake(), car.getModel(), customerName);
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();		
			
		
	}

	private static String listSoldCars() throws Exception {
		
		List<CarSell> soldCars = sellACar.listSoldCars();		
					
		System.out.println("***********List of All The Sold Cars************\n\n");
		System.out.println("------|--------|-----------|-----------|------------|------------|----------------|---------------|-------------|-------------------");
		System.out.println("CarID |SalesID |Make       |Model      |SellPrice   |CustomerName|CustomerPostCode|CustomerCountry|CustomerPhone|CustomerEmail   ");
		System.out.println("------|--------|-----------|-----------|------------|------------|----------------|---------------|-------------|-------------------");
		
		for(CarSell soldCar:soldCars) {		
		
			Car car = carDealerShip.getCar(soldCar.getCarId());
			
			System.out.printf("%-6d|%-8d|%-11s|%-11s|%-10f|%-12s|%-16s|%-15s|%-13s|%-12s\n", soldCar.getCarId(), soldCar.getCarSellId(), 
					car.getMake(), car.getModel(), soldCar.getSellPrice(), soldCar.getCustomerName(), soldCar.getCustomerPostCode(), 
					soldCar.getCustomerCountry(), soldCar.getCustomerPhone(), soldCar.getCustomerEmail());
		}
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();
		
	}
	

	public static void rentACarManager() throws Exception {
		
		
		do {			
		
		System.out.println(rentingMenuText());
		choice = input.nextInt();
		
		switch (choice) {
		
		case 1:
			rentACar();
			break;
		
		case 2:
			returnACar();
			break;
			
		case 3:
			listCarsWillBeReturned();
			break;
			
		default:
			System.out.println("This choice was not on the menu, please make another choice");
			choiceStr = "B";
			break;
		}
		
		} while(choiceStr.equals("B"));
					
	}

	private static String rentACar() throws Exception {
	
		System.out.println("Please write the Id of the car you would like to rent:");
		choice = input.nextInt();
		
		Car car = carDealerShip.getCar(choice);
		
		System.out.printf("%s %s's daily Rent Rate is %f. How many days would you like to rent it for?\n", car.getMake(), car.getModel(), car.getDailyRentPrice());
		
		int totalRentDay = input.nextInt();
		double totalRentPrice = car.getDailyRentPrice() * totalRentDay;
		
		System.out.println("Customer Name:");		
		String customerName = input.next();
		
		System.out.println("Customer Address:");
		String customerAddress = input.next();
		
		System.out.println("Customer Postcode:");
		String customerPostCode = input.next();
		
		System.out.println("Customer Country: (UNITEDKINGDOM, USA OR FRANCE)");
		String customerCountryStr = input.next();
		CustomerCountry customerCountry = CustomerCountry.valueOf(customerCountryStr);
		
		System.out.println("Customer Phone:");
		String customerPhone = input.next();
		
		System.out.println("Customer Email:");
		String customerEmail = input.next();
		
		
		CarRent carRent = new CarRent(choice, totalRentPrice, totalRentDay, customerName, 
									customerAddress, customerPostCode, customerCountry, customerPhone, customerEmail);		
		
		rentACar.rentACar(carRent);
		
		Status status = Status.RENTED;
		carDealerShip.statusUpdate(choice, status);
		
		System.out.printf("You have rented the %s %s to %s\n", car.getMake(), car.getModel(), customerName);
		
		System.out.println("\nPress 'B' to go back to Rent A Car Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();		
		
	}

	private static String returnACar() throws Exception {
			
		System.out.println("Please write the Id of the car you would like to return:");
		choice = input.nextInt();
		
		rentACar.returnACar(choice);
		Status status = Status.NEW;
		carDealerShip.statusUpdate(choice, status);
		
		Car car = carDealerShip.getCar(choice);
		
		System.out.printf("You have returned the %s %s\n", car.getMake(), car.getModel());
		
		System.out.println("\nPress 'B' to go back to Rent A Car Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();	
	}

	private static String listCarsWillBeReturned() throws Exception {
		
		List<CarRent> carsWillBeReturned = rentACar.listCarsWillBeReturned();		
		
		System.out.println("***********List of All The Cars Will be Returned in A Week************\n\n");
		System.out.println("------|-----------|-----------|----------------|----------|------------|-----------|---------");
		System.out.println("CarID |Make       |Model      |Return Date     |Fuel      |Rent Price  |Transm.    |Reg Y.   ");
		System.out.println("------|-----------|-----------|----------------|----------|------------|-----------|---------");
				
		for(CarRent carsWillBeReturne: carsWillBeReturned) {		
		
			Car car = carDealerShip.getCar(carsWillBeReturne.getCarId());
			
			LocalDateTime returnDate = carsWillBeReturne.getRentStartDate().plusDays(carsWillBeReturne.getTotalRentDay());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String formatDateTime = returnDate.format(formatter);
			
			System.out.printf("%-6d|%-11s|%-11s|%-11s|%-10s|%-12f|%-11s|%-11s\n", carsWillBeReturne.getCarId(), car.getMake(), car.getModel(), 
					formatDateTime, car.getFuel(), car.getDailyRentPrice(), car.getTransmission(), car.getRegistrationYear());
		}
		
		System.out.println("\nPress 'B' to go back to Car DealerShip Manager Menu or Press 'M' to go back to Main Menu");
		return choiceStr = input.next();
		
			
	}


}
