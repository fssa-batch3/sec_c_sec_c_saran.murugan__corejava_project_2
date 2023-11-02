package com.fssa.movie.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fssa.movie.DAO.BookingDAO;
import com.fssa.movie.model.Booking;

public class BookingService {

    public List<Booking> getBookingDetails() throws SQLException {
    	return BookingDAO.getBookingsDetails();
    }

}