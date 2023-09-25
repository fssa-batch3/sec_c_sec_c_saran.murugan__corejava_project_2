package com.fssa.movie.Validator;

import java.time.LocalTime;

import com.fssa.movie.model.MovieShow;
import com.fssa.movie.validatorException.MovieShowValidateException;
import com.fssa.movie.validatorException.MovieShowValidatorErrors;

public class MovieShowValidator {

	
	  public static boolean validateMovieShow(MovieShow showTime) throws MovieShowValidateException {
	        if (showTime == null) {
	            throw new MovieShowValidateException(MovieShowValidatorErrors.INVALID_MOVIESHOW_NULL);
	        }

	        validateMovieId(showTime.getMovieId());
	        validateTheaterId(showTime.getTheaterId());
	        validateShowTime(showTime.getShowTime());

	        return true;
	    }

	    public static boolean validateMovieId(int movieId) throws MovieShowValidateException {
	        if (movieId <= 0) {
	            throw new MovieShowValidateException(MovieShowValidatorErrors.INVALID_MOVIE_ID);
	        }
	        return true;
	    }

	    public static boolean validateTheaterId(int theaterId) throws MovieShowValidateException {
	        if (theaterId <= 0) {
	            throw new MovieShowValidateException(MovieShowValidatorErrors.INVALID_THEATER_ID);
	        }
	        return true;
	    }

	    public static boolean validateShowTime(LocalTime showTime) throws MovieShowValidateException {
	        if (showTime == null ) {
	            throw new MovieShowValidateException(MovieShowValidatorErrors.INVALID_SHOWTIME);
	        }
	        return true;
	    }

		

}
