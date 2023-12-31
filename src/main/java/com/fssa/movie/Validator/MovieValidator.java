package com.fssa.movie.Validator;

import java.time.LocalDate;

import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;
import com.fssa.movie.validatorException.MovieValidatorErrors;

public class MovieValidator {

	public static boolean validate(Movie movie) throws MovieValidateException {

		// check for nullity of the parameter
		if (movie == null) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_NULL);
		}
	
		validateName(movie.getMovieName());
		validateDescription(movie.getDescription());
		validateReleaseDate(movie.getReleaseDate());
		validateDurationMinutes(movie.getDurationMinutes());
		return true;

	}
	

	public static boolean validateName(String name) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// Check if name has length of 2.
	
		if (name == null || "".equals(name) || name.length() < 2) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_NAME);
		}
		return true;
	}

	public static boolean validateDescription(String description) throws MovieValidateException {
		// Check for description,description should have alphabets and some special characters.
		// For Simplicity, Check if name has length of 10.
		if (description == null || "".equals(description) || description.length() < 10) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION);
		}
		return true;
	}
	public static boolean validateMovieImage(String movieImage) throws MovieValidateException {
        // Check for movie image url, movie image url should have alpahbets and some characters.
        // For Simplicity, Check if movie image url are match with image re3gex pattern.
        if (movieImage == null || movieImage.isEmpty()) {
            throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_IMAGE);
        }

        // Replace the regex pattern below with the actual URL image pattern if needed
        String imageRegex = "^(https?:\\/\\/)?\\S+\\.(png|jpe?g|gif)$";
        if (!movieImage.matches(imageRegex)) {
            throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_IMAGE);
        }

        return true;
    }

	public static boolean validateMovieBanner(String movieBanner) throws MovieValidateException {
        // Check for banner image url, banner image url should have alpahbets and some characters.
        // For Simplicity, Check if banner image url are match with image re3gex pattern.
        if ( movieBanner == null || movieBanner.isEmpty()) {
            throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_BANNER );
        }

        // Replace the regex pattern below with the actual URL image pattern if needed
          String imageRegex2 = "^(https?:\\/\\/)?\\S+\\.(png|jpe?g|gif)$";
          if (!movieBanner.matches(imageRegex2)) {
            throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_BANNER );
        }

        return true;
    }

	
	public static boolean validateDurationMinutes(int durationMinutes) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (durationMinutes < 0) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_DURATION_MINUTES);
		}
		return true;
	}
	
	public static boolean validateMovieId(int movieId) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (movieId <= 0) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_ID);
		}
		return true;
	}


	static LocalDate today = LocalDate.now();
	// Expected format

	public static boolean validateReleaseDate(LocalDate releaseDate) throws MovieValidateException{
        	
        LocalDate today = LocalDate.now();
		if (today.equals(releaseDate) || releaseDate == null) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_RELEASE_DATE);
		}
		
		return true;
	}

	
	
}
