package com.fssa.movie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.movie.connection.GetConnection;

public class BookingHistoryDAO {


	public static void storeBookingDetails(String bookingId, String email, int seatCount, String seatNames, String seatPrice,
			String showDate, String showDay, String showMonth, String showTime, String theatreName,String movieImage,String movieBanner,String movieTitle,String language,String format,String genre,String certificate,String description)
			throws SQLException {
		
		try (Connection connection=GetConnection.getConnection()) {
			String query = "INSERT INTO booking_details (booking_id, email, seat_count, seat_names, seat_price, "
					+ "show_date, show_day, show_month, show_time,theatre_name,movie_main_image,movie_banner_image,movie_title,language,format,genre,certificate,description)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, bookingId);
				statement.setString(2, email);
     			statement.setInt(3, seatCount);
				statement.setString(4, seatNames);
				statement.setString(5, seatPrice);
				statement.setString(6, showDate);
				statement.setString(7, showDay);
				statement.setString(8, showMonth);
				statement.setString(9, showTime);
				statement.setString(10, theatreName);
				statement.setString(11, movieImage);
				statement.setString(12, movieBanner);
				statement.setString(13, movieTitle);
				statement.setString(14, language);
				statement.setString(15, format);
				statement.setString(16, genre);
				statement.setString(17, certificate);
				statement.setString(18, description);


				int rowsAffected = statement.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Booking details stored successfully!");
				} else {
					System.out.println("Failed to store booking details.");
				}
			}
		}
	}
	
	
	
	

}
