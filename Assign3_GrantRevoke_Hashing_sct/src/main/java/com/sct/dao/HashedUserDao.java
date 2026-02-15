package com.sct.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sct.model.HashedUser;

//this code is similar to the skeleton provided by teacher in lessons


public class HashedUserDao {
	
	// method for inserting values to db using prepared statement. 
	public int registerUser(HashedUser user) throws ClassNotFoundException {
		
		// create SQL statement
		String INSERT_SQL = "INSERT INTO regist_with_hash (username, password_h, mobileNumber, emailId) VALUES (?, ?, ?, ?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig03a", "comp3026_w2026_sct",
				"class123")) {
			
			// prepared statements..
			PreparedStatement ps = connection.prepareStatement(INSERT_SQL);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword()); // hashed password
            ps.setString(3, user.getMobileNumber());
            ps.setString(4, user.getEmailId());

            System.out.println(ps);
            result = ps.executeUpdate();
			
			
		}
		catch (SQLException e) {
			printSQLException(e);
			
		}
		return result;
		
		
		
		
	}// end of insert
	
	// method for selecting all values from db 
	 public List<HashedUser> getAllUsers() throws ClassNotFoundException {
		 
		// create SQL statement
		 String SELECT_SQL =  "SELECT username, password_h, mobileNumber, emailId FROM regist_with_hash;"; 
		 
		 List<HashedUser> users = new ArrayList<>();
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     
	     try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig03a", "comp3026_w2026_sct",
					"class123");
	    		 
	    		 PreparedStatement ps = connection.prepareStatement(SELECT_SQL);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                HashedUser user = new HashedUser();
	                user.setUsername(rs.getString("username"));
	                user.setPassword(rs.getString("password_h"));
	                user.setMobileNumber(rs.getString("mobileNumber"));
	                user.setEmailId(rs.getString("emailId"));

	                users.add(user);
	            }

	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return users;
	         		
		 
	}// end of select
	
	
	
	// SQLException e
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {

				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();

				}
			}

		}

	}

}
