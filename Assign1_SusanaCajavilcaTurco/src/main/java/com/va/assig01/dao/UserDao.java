package com.va.assig01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.va.assig01.model.User;

// this code is similar to the skeleton provided by teacher in week01, is not required for the assignment 01
// it is here just to be prepare in advance for next assignment

public class UserDao {
	

	// method for inserting values to db using preparedstatement. 	
		public int registerUser(User user) throws ClassNotFoundException {

			// create SQL statement
			String INSERT_USERS_SQL = " INSERT INTO user_tb" + " ( userId, password,  name, address, country, zipCode, email, sex, language, about) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assig01", "root",
					"[my password here]")) {
				// prepared statements..
				
				PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
				
				ps.setString(2, user.getUserId());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getName());
				ps.setString(5, user.getAddress());
				ps.setString(6, user.getCountry());
				ps.setString(7, user.getZipCode());
				ps.setString(8, user.getEmail());
				ps.setString(9, user.getSex());
				ps.setString(10, user.getLanguage());		
				ps.setString(11, user.getAbout());		
				System.out.println(ps);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
				
			}
			return result;
		}

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
