package src.com.albaycan.cardealership.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import src.com.albaycan.cardealership.domain.CarRent;
import src.com.albaycan.cardealership.domain.CustomerCountry;

public class RentACarRepositoryImp implements RentACarRepository {

	ConnectDB connectDB = new ConnectDB();
	
	Connection myConn = connectDB.getConnection();
	
	@Override
	public void rentACar(CarRent carRent) throws Exception {
	
		Statement myStmt = myConn.createStatement();
		
		int carId = carRent.getCarId(); 
		double totalRentPrice = carRent.getTotalRentPrice();
		String rentStartDate = LocalDateTime.now().toString();
		int totalRentDay = carRent.getTotalRentDay(); 
		String customerName = carRent.getCustomerName(); 
		String customerAddress = carRent.getCustomerAddress();
		String customerPostCode = carRent.getCustomerPostCode(); 
		String customerCountry = carRent.getCustomerCountry().name(); 
		String customerPhone = carRent.getCustomerPhone(); 
		String customerEmail = carRent.getCustomerEmail();
		
		String sql = "insert into carrent (carId, totalRentPrice, rentStartDate, totalRentDay, customerName, "
						+ "customerAddress, customerPostCode, customerCountry, customerPhone, "
						+ "customerEmail) values ("+carId+", "+totalRentPrice+", "
						+ "'"+rentStartDate+"', "+totalRentDay+", '"+customerName+"', '"+customerAddress+"', "
						+ "'"+customerPostCode+"', '"+customerCountry+"', '"+customerPhone+"', '"+customerEmail+"')";
		
		myStmt.executeUpdate(sql);		

	}

	@Override
	public void returnACar(int carId) throws Exception {
		
		String sql = "delete from carrent where carId = ?";
		
		PreparedStatement myStmt = myConn.prepareStatement(sql);
		
		myStmt.setInt(1, carId);
		
		myStmt.executeUpdate();		

	}

	/*
	@Override
	public List<CarRent> listRentedCars() {
		
		return null;
	}
	*/

	@Override
	public List<CarRent> listCarsWillBeReturned() throws Exception {
		
		Statement myStmt = myConn.createStatement();
		
		String sql = "select * from carrent where DATE_ADD(NOW(), INTERVAL 7 day) > DATE_ADD(rentStartDate, INTERVAL totalRentDay day)";
		
		ResultSet myRs = myStmt.executeQuery(sql);
		
		List<CarRent> carsWillBeReturned = new ArrayList<>();
		CarRent carRent = null;
		
		while (myRs.next()) {
			
			carRent = new CarRent(myRs.getInt("carId"), myRs.getDouble("totalRentPrice"), myRs.getInt("totalRentDay"), 
					myRs.getString("customerName"), myRs.getString("customerAddress"), myRs.getString("customerPostCode"), 
					CustomerCountry.valueOf(myRs.getString("customerCountry")), myRs.getString("customerPhone"), myRs.getString("customerEmail"));
			
			
			String rentStartDateStr = myRs.getString("rentStartDate");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(rentStartDateStr, formatter);
			

			carRent.setRentStartDate(dateTime);			
		}
		
		carsWillBeReturned.add(carRent);
		
		return carsWillBeReturned;
	}

}
