package com.fssa.movie.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.connection.GetConnection;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.MovieShow;

public class MovieShowDAO {

	public static boolean createShow(MovieShow showTime) throws DAOExceptions {
	    try (Connection connection = GetConnection.getConnection()) {
	        // Create insert statement
	        String insertQuery = "INSERT INTO movie_show_times (movie_id, theater_id, show_time)" +
	                "VALUES (?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            // Set values for the prepared statement
	            preparedStatement.setInt(1, showTime.getMovieId());
	            preparedStatement.setInt(2, showTime.getTheaterId());
	            preparedStatement.setTime(3, java.sql.Time.valueOf(showTime.getShowTime()));

	            // Execute insert statement
	            int rowsInserted = preparedStatement.executeUpdate();

	            if (rowsInserted == 0) {
	                throw new DAOExceptions("Failed to insert the show time into the database.");
	            }
	        }
	        CustomLogger.info("Show time added successfully");
	    } catch (SQLException e) {
	        // Handle any database-related errors
	        throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
	    }
	    return true;
	}

}
