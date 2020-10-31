package sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sports.entity.Sports;

/**
 * 
 * @author tazh_
 *
 */

public class SportsDao {
	//private Connection connection = DbConnections.getInstance().getConnection();
	
	public void createSports(String sport_name) throws SQLException {
		String sql = "INSERT INTO sports (sport_name) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnections.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, sport_name);
			
			statement.executeUpdate();
			
		}
		finally {
			if(statement != null) {
			statement.close();
			
		}
			if(connection != null) {
				connection.close();
			}
		}
	}
	/**
	 * 
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<Sports> fetchSports() throws SQLException {
		String sql = "Select * FROM sports";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Sports> sports = new ArrayList<>();
		
		try {
			connection = DbConnections.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				int sport_id = rs.getInt("sport_id");
				String sport_name = rs.getString("sport_name");
				Sports sport = new Sports(sport_id, sport_name);
				sports.add(sport);
			}
			return sports;
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			
			if(statement != null) {
				statement.close();
				
			}
				if(connection != null) {
					connection.close();
				}
			
					}
		
	}
	
	/**
	 * 
	 * 
	 * @param sport_id
	 * @param sport_name
	 * @throws SQLException
	 */
	
	
	public void modifySports(int sport_id, String sport_name) throws SQLException {
		String sql = "UPDATE sports SET sport_name = ? WHERE sport_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnections.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, sport_name);
			statement.setInt(2,  sport_id);
			
			statement.executeUpdate();
			
		}
		finally {
			
			if(statement != null) {
				statement.close();
				
			}
				if(connection != null) {
					connection.close();
				}
		}
	}
	/**
	 * 
	 * @param sport_id
	 * @throws SQLException
	 */
	
	
	public void deleteSports(int sport_id) throws SQLException {
		String sql = "DELETE FROM sports WHERE sport_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnections.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, sport_id);
			
			statement.executeUpdate();
			
		}
		finally {
			if(statement != null) {
				statement.close();
				
			}
				if(connection != null) {
					connection.close();
				}
		}
	}
}