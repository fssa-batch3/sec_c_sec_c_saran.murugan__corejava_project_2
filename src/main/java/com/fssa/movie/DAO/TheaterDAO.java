package com.fssa.movie.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
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

	public static List<Theater> readAllTheaters() throws SQLException {
	    List<Theater> theaterList = new ArrayList<>();
	    String READ_QUERY = "SELECT * FROM theater_details";
	    try (Connection conn = GetConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                Theater theater = new Theater();

	                theater.setTheaterId(rs.getInt("theater_id"));
	                theater.setName(rs.getString("theater_name"));
	                theater.setLocation(rs.getString("location"));
	                theater.setAddress(rs.getString("address"));
	                theater.setNumSeats(rs.getInt("num_seats"));

	                theaterList.add(theater);
	            }
	        }
	    }

	    return theaterList;
	}







}
