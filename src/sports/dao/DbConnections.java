package sports.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnections {

	private final static String URL = "jdbc:mysql://localhost:3306/sports_db";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root01";
	private static DbConnections INSTANCE = new DbConnections();
	
	private Connection connection;
		
		
	private DbConnections() {
	}
	
	public static DbConnections getInstance() {
		return INSTANCE;
	}
	public Connection getConnection() throws SQLException {
	
				INSTANCE.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection successful.");
			
		
		return connection;
	}
}






