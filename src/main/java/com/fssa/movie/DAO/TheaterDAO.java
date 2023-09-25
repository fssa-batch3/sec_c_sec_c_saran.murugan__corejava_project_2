
package com.fssa.movie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.connection.GetConnection;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Theater;

public class TheaterDAO {
	
	public static boolean createTheater(Theater theater) throws DAOExceptions {
	    try (Connection connection = GetConnection.getConnection()) {
	        // Create insert statement
	        String insertQuery = "INSERT INTO theater_details (theater_name, location, address, num_seats)" +
	                             "VALUES (?, ?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            // Set values for the prepared statement
	            preparedStatement.setString(1, theater.getName());
	            preparedStatement.setString(2, theater.getLocation());
	            preparedStatement.setString(3, theater.getAddress());
	            preparedStatement.setInt(4, theater.getNumSeats());

	            // Execute insert statement
	            int rowsInserted = preparedStatement.executeUpdate();

	            if (rowsInserted == 0) {
	                throw new DAOExceptions("Failed to insert the theater into the database.");
	            }
	        }
	        CustomLogger.info("Theater added successfully");
	    } catch (SQLException e) {
	        // Handle any database-related errors
	        throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
	    }
	    return true;
	}


}
