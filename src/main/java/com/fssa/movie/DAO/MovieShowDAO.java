package com.fssa.movie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.connection.GetConnection;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.MovieShow;

public class MovieShowDAO {

	public static boolean createShow(MovieShow showTime) throws DAOExceptions {
		try (Connection connection = GetConnection.getConnection()) {
			// Create insert statement
			String insertQuery = "INSERT INTO movie_show_times (movie_id, theater_id, show_time,show_date)"
					+ "VALUES (?, ?, ?,?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
				// Set values for the prepared statement
				preparedStatement.setInt(1, showTime.getMovieId());
				preparedStatement.setInt(2, showTime.getTheaterId());
				preparedStatement.setTime(3, java.sql.Time.valueOf(showTime.getShowTime()));
				preparedStatement.setDate(4, java.sql.Date.valueOf(showTime.getShowDate()));

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

	public static List<MovieShow> readAllShows() throws DAOExceptions {
		List<MovieShow> showList = new ArrayList<>();
		String READ_QUERY = "SELECT * FROM movie_show_times";

		try (Connection conn = GetConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					MovieShow show = new MovieShow();

					show.setMovieId(rs.getInt("movie_id"));
					show.setShow_id(rs.getInt("show_id"));
					show.setTheaterId(rs.getInt("theater_id"));
					show.setShowTime(rs.getTime("show_time").toLocalTime());
					show.setShowDate(rs.getDate("show_date").toLocalDate());

					showList.add(show);
				}
			}
		} catch (SQLException e) {
			// Handle any database-related errors
			throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
		}

		return showList;
	}
	
	public static List<Map<String, String>> getMovieShowDetails() throws DAOExceptions {
	    List<Map<String, String>> showDetailsList = new ArrayList<>();

	    try (Connection connection = GetConnection.getConnection()) {
	        String query = "SELECT movie_show_times.movie_id, theater_details.theater_name,theater_details.num_seats, movie_show_times.show_time, movie_show_times.show_date, " +
	                "(SELECT movie_title FROM movie_details WHERE movie_id = movie_show_times.movie_id) AS selected_movie_title " +
	                "FROM movie_show_times " +
	                "JOIN movie_details ON movie_details.movie_id = movie_show_times.movie_id " +
	                "JOIN theater_details ON theater_details.theater_id = movie_show_times.theater_id";

	        try (PreparedStatement statement = connection.prepareStatement(query)){
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    Map<String, String> showDetails = new HashMap<>();
	                    showDetails.put("movie_id", String.valueOf(resultSet.getInt(("movie_id")))); // Convert to String
	                    showDetails.put("movie_title", resultSet.getString("selected_movie_title"));
	                    showDetails.put("theater_name", resultSet.getString("theater_name"));
	                    showDetails.put("num_seats", String.valueOf(resultSet.getInt(("num_seats")))); // Convert to String
	                    showDetails.put("show_time", resultSet.getTime("show_time").toString());
	                    showDetails.put("show_date", resultSet.getDate("show_date").toString());
	                    
	                    showDetailsList.add(showDetails);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
	    }

	    return showDetailsList;
	}
	
	public static void main(String[] args) {
	    try {
	        List<Map<String, String>> showDetailsList = getMovieShowDetails();

	        for (Map<String, String> showDetails : showDetailsList) {
	            System.out.println("Movie Title: " + showDetails.get("movie_title"));
	            System.out.println("Theater Name: " + showDetails.get("theater_name"));
	            System.out.println("Show Time: " + showDetails.get("show_time"));
	            System.out.println("Show Date: " + showDetails.get("show_date"));
	            System.out.println(showDetails.get("num_seats"));
	        }
	    } catch (DAOExceptions e) {
	        e.printStackTrace();
	    }
	}


}
