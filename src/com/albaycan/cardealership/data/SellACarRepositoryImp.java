package src.com.albaycan.cardealership.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import src.com.albaycan.cardealership.domain.CarSell;
import src.com.albaycan.cardealership.domain.CustomerCountry;

public class SellACarRepositoryImp implements SellACarRepository {

	ConnectDB connectDB = new ConnectDB();
	Connection myConn = connectDB.getConnection(); 
	
	@Override
	public void sellACar(CarSell carSell) throws Exception {
		
		Statement myStmt = myConn.createStatement();
		
		int carId = carSell.getCarId();
		double sellPrice = carSell.getSellPrice();
		String customerName = carSell.getCustomerName();
		String customerAddress = carSell.getCustomerAddress();
		String customerPostcode = carSell.getCustomerPostCode();
		String customerCountry = carSell.getCustomerCountry().name();
		String customerPhone = carSell.getCustomerPhone();
		String customerEmail = carSell.getCustomerEmail();
		LocalDateTime saleDate = LocalDateTime.now();		
		
		String url = "insert into carsales (carId, sellPrice, customerName, customerAddress, customerPostcode, "
						+ "customerCountry, customerPhone, customerEmail, saleDate) values ("+carId+", "+sellPrice+", "
						+ "'"+customerName+"', '"+customerAddress+"', '"+customerPostcode+"', '"+customerCountry+"', "
						+ "'"+customerPhone+"', '"+customerEmail+"', '"+saleDate+"') ";

		myStmt.executeUpdate(url);		
		
	}

	@Override
	public List<CarSell> listSoldCars() throws Exception {
		
		Statement myStmt = myConn.createStatement();
		ResultSet myRs = null; 
				
		List<CarSell> soldCars = new ArrayList<>();
		
		CarSell carSell = null;
		
		String url = "select carSellId, carId, sellPrice, customerName, customerAddress, customerPostcode, customerCountry, "
						+ "customerPhone, customerEmail from carsales";

		myRs = myStmt.executeQuery(url);
		
		while(myRs.next()) {
			
			int carSellId = myRs.getInt("carSellId");
			int carId = myRs.getInt("carId");
			double sellPrice = myRs.getDouble("sellPrice");
			String customerName = myRs.getString("customerName");
			String customerAddress = myRs.getString("customerAddress");
			String customerPostCode = myRs.getString("customerPostcode");
			CustomerCountry customerCountry = CustomerCountry.valueOf(myRs.getString("customerCountry"));
			String customerPhone = myRs.getString("customerPhone");
			String customerEmail = myRs.getString("customerEmail");		
			
			carSell = new CarSell(carId, sellPrice, customerName, customerAddress, customerPostCode, customerCountry, customerPhone, customerEmail);
			carSell.setCarSellId(carSellId);
			
			soldCars.add(carSell);
		}
		
		return soldCars;
	}

}
