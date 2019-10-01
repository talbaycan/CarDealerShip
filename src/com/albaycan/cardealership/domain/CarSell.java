package src.com.albaycan.cardealership.domain;

import java.time.LocalDateTime;

public class CarSell {
	
	int carSellId;
	int carId; 
	double sellPrice; 
	String customerName;
	String customerAddress;
	String customerPostCode; 
	CustomerCountry customerCountry; 
	String customerPhone;
	String customerEmail;
	LocalDateTime saleDate;
	
	
	public CarSell(int carId, double sellPrice, String customerName, String customerAddress, String customerPostCode,
			CustomerCountry customerCountry, String customerPhone, String customerEmail) {

		this.carSellId = carSellId; 
		this.carId = carId;
		this.sellPrice = sellPrice;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPostCode = customerPostCode;
		this.customerCountry = customerCountry;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.saleDate = LocalDateTime.now();
	}


	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
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


	public LocalDateTime getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(LocalDateTime saleDate) {
		this.saleDate = saleDate;
	}


	public int getCarSellId() {
		return carSellId;
	}


	public double getSellPrice() {
		return sellPrice;
	}
	
	public void setCarSellId(int carSellId) {
		this.carSellId = carSellId;
	}
	
	

}
