package src.com.albaycan.cardealership.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import src.com.albaycan.cardealership.domain.Car;
import src.com.albaycan.cardealership.domain.Make;
import src.com.albaycan.cardealership.domain.ModificationType;
import src.com.albaycan.cardealership.domain.Status;

public class ConnectDB {	
	
	Connection myConn;
			
	public ConnectDB() { 		
	
		try {
	
			Properties props = new Properties();
			props.load(new FileInputStream("cardealership.properties"));
			
			String dburl = props.getProperty("dburl");
			String user = props.getProperty("user");
			String password = props.getProperty("password");
			
			myConn = DriverManager.getConnection(dburl, user, password);		
				
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return myConn;
		
	}
	
}
