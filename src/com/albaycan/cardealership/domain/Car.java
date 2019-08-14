package com.albaycan.cardealership.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Car {
	
	private int id;
	private String make;
	private String model; 
	private String fuel;
	private double RRP;
	private double dailyRentPrice;
	private String transmission; 
	private String registrationYear;
	private String colour;
	private List<String> modification;
	private String status;
	private LocalDateTime createDateTime;
	
	public Car () {
		
	}
	
	public Car(String make, String model, String fuel, double RRP, double dailyRentPrice, String transmission,
			String registrationYear, String colour, List<String> modification, String status) {
		
		this.id = (int)(Math.random()* 1000+1); 
		this.make = make;
		this.model = model;
		this.fuel = fuel;
		this.RRP = RRP;
		this.dailyRentPrice = dailyRentPrice;
		this.transmission = transmission;
		this.registrationYear = registrationYear;
		this.colour = colour;
		this.modification = modification;
		this.status = status;
		this.createDateTime = LocalDateTime.now();
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public double getRRP() {
		return RRP;
	}

	public void setRRP(double rRP) {
		RRP = RRP;
	}

	public double getDailyRentPrice() {
		return dailyRentPrice;
	}

	public void setDailyRentPrice(double dailyRentPrice) {
		this.dailyRentPrice = dailyRentPrice;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public List<String> getModification() {
		return modification;
	}

	public void setModification(List<String> modification) {
		this.modification = modification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	
	
	
	
	

}
