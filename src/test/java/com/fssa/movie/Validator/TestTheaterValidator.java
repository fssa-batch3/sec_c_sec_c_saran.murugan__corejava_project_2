package com.fssa.movie.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.model.*;
import com.fssa.movie.validatorException.TheaterValidateException;
import com.fssa.movie.validatorException.TheaterValidatorErrors;

public class TestTheaterValidator {

    @Test
    void testTheatervalidate() throws TheaterValidateException {
        Theater theater = new Theater("Grand Theater", "https://maps.app.goo.gl/c4RuXc8UTgL6FeGW9", "City Center", 200);
        Assertions.assertTrue(TheaterValidator.validateTheater(theater));
    }

    @Test
    void testValidName() throws TheaterValidateException {
        Assertions.assertTrue(TheaterValidator.validateName("Grand Theater"));
    }

    @Test
    void testNullName() throws TheaterValidateException {
        try {
            TheaterValidator.validateName(null);
            Assertions.fail("Validate name failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_NAME, ex.getMessage());
        }
    }

    @Test
    void testEmptyName() throws TheaterValidateException {
        try {
            TheaterValidator.validateName("");
            Assertions.fail("Validate name failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_NAME, ex.getMessage());
        }
    }

    @Test
    void testLengthName() throws TheaterValidateException {
        try {
            TheaterValidator.validateName("G");
            Assertions.fail("Validate name failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_NAME, ex.getMessage());
        }
    }

    @Test
    void testValidLocation() throws TheaterValidateException {
        Assertions.assertTrue(TheaterValidator.validateLocation("https://maps.app.goo.gl/c4RuXc8UTgL6FeGW9"));
    }

    @Test
    void testNullLocation() {
        try {
            TheaterValidator.validateLocation(null);
            Assertions.fail("Validate location failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_LOCATION, ex.getMessage());
        }
    }

    @Test
    void testEmptyLocation() {
        try {
            TheaterValidator.validateLocation("");
            Assertions.fail("Validate location failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_LOCATION, ex.getMessage());
        }
    }

    @Test
    void testInvalidLocation() {
        try {
            TheaterValidator.validateLocation("Invalid Location123!");
            Assertions.fail("Validate location failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_LOCATION, ex.getMessage());
        }
    }
    
    @Test
    void testValidAddress() throws TheaterValidateException {
        Assertions.assertTrue(TheaterValidator.validateAddress("City Center"));
    }

    @Test
    void testNullAddress() {
        try {
            TheaterValidator.validateAddress(null);
            Assertions.fail("Validate address failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_ADDRESS, ex.getMessage());
        }
    }

    @Test
    void testEmptyAddress() {
        try {
            TheaterValidator.validateAddress("");
            Assertions.fail("Validate address failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_ADDRESS, ex.getMessage());
        }
    }

    @Test
    void testValidNumSeats() throws TheaterValidateException {
        Assertions.assertTrue(TheaterValidator.validateNumSeats(100));
    }

    @Test
    void testZeroNumSeats() {
        try {
            TheaterValidator.validateNumSeats(0);
            Assertions.fail("Validate numSeats failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_NUM_SEATS, ex.getMessage());
        }
    }

    @Test
    void testNegativeNumSeats() {
        try {
            TheaterValidator.validateNumSeats(-5);
            Assertions.fail("Validate numSeats failed");
        } catch (TheaterValidateException ex) {
            Assertions.assertEquals(TheaterValidatorErrors.INVALID_THEATER_NUM_SEATS, ex.getMessage());
        }
    }

}
