package com.fssa.movie.Validator;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.model.*;

import com.fssa.movie.validatorException.MovieShowValidateException;
import com.fssa.movie.validatorException.MovieShowValidatorErrors;

public class TestMovieShowValidator {

	@Test
	void testMovieShowValidate() throws MovieShowValidateException {
		MovieShow showTime = new MovieShow(1, 1, LocalTime.of(15, 30),LocalDate.of(2023, 9, 20));
		Assertions.assertTrue(MovieShowValidator.validateMovieShow(showTime));
	}

	@Test
	void testValidMovieId() throws MovieShowValidateException {
		Assertions.assertTrue(MovieShowValidator.validateMovieId(1));
	}

	@Test
	void testInvalidMovieId() throws MovieShowValidateException {

		try {
			MovieShowValidator.validateMovieId(-1);
			Assertions.fail("ValidateMovieID failed");
		} catch (MovieShowValidateException ex) {
			Assertions.assertEquals(MovieShowValidatorErrors.INVALID_MOVIE_ID, ex.getMessage());
		}

	}

	@Test
	void testValidTheaterId() throws MovieShowValidateException {
		Assertions.assertTrue(MovieShowValidator.validateTheaterId(1));
	}

	@Test
	void testInvalidTheaterId() throws MovieShowValidateException {

		try {
			MovieShowValidator.validateTheaterId(-1);
			Assertions.fail("ValidateTheaterID failed");
		} catch (MovieShowValidateException ex) {
			Assertions.assertEquals(MovieShowValidatorErrors.INVALID_THEATER_ID, ex.getMessage());
		}

	}

	@Test
	void testValidShowTime() throws MovieShowValidateException {
		Assertions.assertTrue(MovieShowValidator.validateShowTime(LocalTime.of(15, 30)));
	}

	@Test
	void testNullShowTimeId() throws MovieShowValidateException {

		try {
			MovieShowValidator.validateShowTime(null);
			Assertions.fail("ValidateShowTime failed");
		} catch (MovieShowValidateException ex) {
			Assertions.assertEquals(MovieShowValidatorErrors.INVALID_SHOWTIME, ex.getMessage());
		}

	}
	

}
