package src.com.albaycan.cardealership.domain;

import java.time.LocalDateTime;

public class CarRent {
	
	private int carRentId;
	private int carId;
	private double totalRentPrice;
	private LocalDateTime rentStartDate;
	private int totalRentDay;
	private String customerName;
	private String customerAddress;
	private String customerPostCode;
	private CustomerCountry customerCountry;
	private String customerPhone;
	private String customerEmail;
	
	
	public CarRent(int carId, double totalRentPrice, int totalRentDay, String customerName, String customerAddress,
			String customerPostCode, CustomerCountry customerCountry, String customerPhone, String customerEmail) {

		// this.carRentId = (int)(Math.random()* 100+1);
		this.carId = carId;
		this.totalRentPrice = totalRentPrice;
		this.totalRentDay = totalRentDay;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPostCode = customerPostCode;
		this.customerCountry = customerCountry;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.rentStartDate = rentStartDate;
	}


	public void setRentStartDate(LocalDateTime rentStartDate) {
		this.rentStartDate = rentStartDate;
	}


	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public double getTotalRentPrice() {
		return totalRentPrice;
	}


	public void setTotalRentPrice(double totalRentPrice) {
		this.totalRentPrice = totalRentPrice;
	}


	public int getTotalRentDay() {
		return totalRentDay;
	}


	public void setTotalRentDay(int totalRentDay) {
		this.totalRentDay = totalRentDay;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public String getCustomerPostCode() {
		return customerPostCode;
	}


	public void setCustomerPostCode(String customerPostCode) {
		this.customerPostCode = customerPostCode;
	}


	public CustomerCountry getCustomerCountry() {
		return customerCountry;
	}


	public void setCustomerCountry(CustomerCountry customerCountry) {
		this.customerCountry = customerCountry;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public int getCarRentId() {
		return carRentId;
	}


	public LocalDateTime getRentStartDate() {
		return rentStartDate;
	}
	
	
	


}
