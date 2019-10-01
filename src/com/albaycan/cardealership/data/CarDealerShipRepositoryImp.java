package src.com.albaycan.cardealership.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.Make;
import src.com.albaycan.cardealership.domain.ModificationType;
import src.com.albaycan.cardealership.domain.Status;

public class CarDealerShipRepositoryImp implements CarDealerShipRepository {
		
	ConnectDB connectDB = new ConnectDB();
	Connection myConn = connectDB.getConnection();

	@Override
	public int addCar(Car car) throws Exception {		
	
		Statement myStmt = null;
		myStmt = myConn.createStatement();
		
		String make = car.getMake().name();
		String model= car.getModel();
		String fuel= car.getFuel();
		double RRP = car.getRRP();
		double dailyRentPrice = car.getDailyRentPrice();
		String transmission = car.getTransmission();
		String registrationYear= car.getRegistrationYear();
		String colour = car.getColour();
		String status = car.getStatus().name();	
		LocalDateTime createDateTime = LocalDateTime.now();
					
		String url = "insert into car (make, model, fuel, RRP, dailyRentPrice, transmission, registrationYear, colour, status, createDateTime)"
					+ " values('"+make+"', '"+model+"', '"+fuel+"', "+RRP+", "+dailyRentPrice+", '"+transmission+"', "
					+ "'"+registrationYear+"', '"+colour+"', '"+status+"', '"+createDateTime+"')";
				
		myStmt.executeUpdate(url);		
		
		PreparedStatement ps = myConn.prepareStatement("select id from car order by createDateTime desc limit 1");
		ResultSet rs = ps.executeQuery();
		
		int id = 0;
		
		while (rs.next()) {
			id = rs.getInt("id");
		}
		
		List<ModificationType> modifications = car.getModification();
		
		for(ModificationType modification: modifications) {
			String modificationStr = modification.name();
			modifyCar(id, modificationStr);
		}
		return id;
		
		
	}

	@Override
	public void modifyCar(int choice, String choiceStr) throws Exception {
		
		Statement myStmt = null;
		myStmt = myConn.createStatement();
					
		String url = "insert into modification (car_id, modificationtype) values("+choice+", '"+choiceStr+"')";
				
		myStmt.executeUpdate(url);		

	}

	@Override
	public boolean carExist(int choice) throws Exception {
		
		Statement myStmt = null;
		myStmt = myConn.createStatement();
					
		String url = "select * from car where id = "+choice+"";
		
		ResultSet rs = myStmt.executeQuery(url);
		
		if(rs.next()) {
			return true;
		} else {		
		return false;
		}
	}

	@Override
	public boolean checkModification(int choice, String choiceStr) throws Exception {
		Statement myStmt = null;
		myStmt = myConn.createStatement();
					
		String url = "select * from modification where car_id = "+choice+" and modificationtype='"+choiceStr+"'";
		
		ResultSet rs = myStmt.executeQuery(url);
		
		if(rs.next()) {
			return true;
		} else {		
		return false;
		}
	}

	@Override
	public List<Car> listAllCars() throws Exception {
		
		Statement myStmt = null;
		myStmt = myConn.createStatement();
					
		String url = "select * from car";
		
		ResultSet rs = myStmt.executeQuery(url);
		
		List<Car> carList = new ArrayList<Car>();
		
		while(rs.next()) {			
			
			Car car = new Car();

			car.setId(rs.getInt("id"));
			car.setMake(Make.valueOf(rs.getString("make")));
			car.setModel(rs.getString("model"));	
			car.setFuel(rs.getString("fuel"));
			car.setRRP(rs.getDouble("rrp"));
			car.setDailyRentPrice(rs.getDouble("dailyRentPrice"));
			car.setTransmission(rs.getString("transmission"));
			car.setRegistrationYear(rs.getString("registrationYear"));
			car.setStatus(Status.valueOf(rs.getString("status")));
						
			carList.add(car);
		}	
		return carList;
	}

	@Override
	public Car getCar(int choice) throws Exception {
		
		Statement myStmt = null;
		myStmt = myConn.createStatement();
					
		String url = "select * from car where id = "+choice+"";
		
		ResultSet rs = myStmt.executeQuery(url);
		
		Car car = new Car();
		
		if(rs.next()) {
			car.setId(rs.getInt("id"));
			car.setMake(Make.valueOf(rs.getString("make")));
			car.setModel(rs.getString("model"));	
			car.setFuel(rs.getString("fuel"));
			car.setRRP(rs.getDouble("rrp"));
			car.setDailyRentPrice(rs.getDouble("dailyRentPrice"));
			car.setTransmission(rs.getString("transmission"));
			car.setRegistrationYear(rs.getString("registrationYear"));
			car.setStatus(Status.valueOf(rs.getString("status")));
		}		
		return car;
	}

	@Override
	public void statusUpdate(int choice, Status status) throws Exception {
		
		String statusStr = status.name(); 
				
		PreparedStatement myStmt = null;
		
		String url = "update car set status = ? where id = ?";
		
		myStmt = myConn.prepareStatement(url);
		
		myStmt.setString(1, statusStr);
		myStmt.setInt(2, choice);	
		
		myStmt.executeUpdate();

	}

}
