package com.fssa.movie.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.fssa.movie.connection.GetConnection;
import com.fssa.movie.model.*;


public class BookingDAO {
    
	
	public static List<Booking> getBookingsDetails() throws SQLException {
	    List<Booking> bookings = new ArrayList<>();
        String READ_QUERY = "SELECT * FROM booking_details";
	    
	    try (Connection conn = GetConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {
	   
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                Booking booking = new Booking();
	                booking.setBookingId(rs.getString("booking_id"));
	                booking.setEmail(rs.getString("email"));
	                booking.setSeatCount(rs.getInt("seat_count"));
	                booking.setSeatNames(rs.getString("seat_names"));
	                booking.setSeatPrice(rs.getString("seat_price"));
	                booking.setShowDate(rs.getString("show_date"));
	                booking.setShowDay(rs.getString("show_day"));
	                booking.setShowMonth(rs.getString("show_month"));
	                booking.setShowTime(rs.getString("show_time"));
	                booking.setTheatreName(rs.getString("theatre_name"));
	                booking.setMovieMainImage(rs.getString("movie_main_image"));
	                booking.setMovieTitle(rs.getString("movie_title"));
	                booking.setMovieBannerImage(rs.getString("movie_banner_image"));
	                booking.setLanguage(rs.getString("language"));
	                booking.setCertificate(rs.getString("certificate"));
	                booking.setGenre(rs.getString("genre"));
	                booking.setDescription(rs.getString("description"));
	                booking.setFormat(rs.getString("format"));

	                bookings.add(booking);	                
	            }
	        }
	    }

	    return bookings;
	}
	
	
}
