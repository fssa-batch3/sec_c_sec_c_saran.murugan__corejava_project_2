package com.fssa.movie.Validator;

import com.fssa.movie.model.Theater;
import com.fssa.movie.validatorException.TheaterValidateException;
import com.fssa.movie.validatorException.TheaterValidatorErrors;

public class TheaterValidator {
	
    public static boolean validateTheater(Theater theater) throws TheaterValidateException {
        if (theater == null) {
            throw new TheaterValidateException(TheaterValidatorErrors.INVALID_THEATER_NULL);
        }

        validateName(theater.getName());
        validateLocation(theater.getLocation());
        validateAddress(theater.getAddress());
        validateNumSeats(theater.getNumSeats());

        return true;
    }


    
    public static boolean validateName(String name) throws TheaterValidateException {
        if (name == null || "".equals(name) || name.length() < 2) {
            throw new TheaterValidateException(TheaterValidatorErrors.INVALID_THEATER_NAME);
        }
        return true;
       }
    
    public static boolean validateLocation(String location) throws TheaterValidateException {
        if (location == null || "".equals(location)) {
            throw new TheaterValidateException(TheaterValidatorErrors.INVALID_THEATER_LOCATION);
        }

        // Replace the regex pattern below with the actual URL pattern you want to use
        String urlRegex = "^(https?:\\/\\/)?\\S+$";

        if (!location.matches(urlRegex)) {
            throw new TheaterValidateException(TheaterValidatorErrors.INVALID_THEATER_LOCATION);
        }

        return true;
    }

    public static boolean validateAddress(String address) throws TheaterValidateException {
        if (address == null || "".equals(address)) {
            throw new TheaterValidateException(TheaterValidatorErrors.INVALID_THEATER_ADDRESS);
        }
        return true;
    }

    public static boolean validateNumSeats(int numSeats) throws TheaterValidateException {
        if (numSeats <= 0) {
            throw new TheaterValidateException(TheaterValidatorErrors.INVALID_THEATER_NUM_SEATS);
        }
        return true;
    }

    }
