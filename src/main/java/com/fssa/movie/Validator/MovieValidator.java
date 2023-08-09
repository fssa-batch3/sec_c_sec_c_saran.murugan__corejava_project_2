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
		validateLanguage(movie.getLanguage());
		validateFormat(movie.getFormat());
		validateCertificate(movie.getCertificate());
		validateDescription(movie.getDescription());
		validateGenre(movie.getGenre());
		validateReleaseDate(movie.getReleaseDate());
		validateDurationHours(movie.getDurationHours());
		validateDurationMinutes(movie.getDurationMinutes());
		validateDurationSeconds(movie.getDurationSeconds());
		return true;

	}

	public static boolean validateName(String name) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (name == null || "".equals(name) || name.length() < 2) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_NAME);
		}
		return true;
	}

	public static boolean validateLanguage(String language) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (language == null || "".equals(language) || language.length() < 3) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_LANGUAGE);
		}
		return true;
	}

	public static boolean validateFormat(String format) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (format == null || "".equals(format.trim()) || format.length() < 2 || !format.equals(format.toUpperCase())) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_FORMAT);
		}
		return true;
	}

	

	public static boolean validateCertificate(String certificate) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (certificate == null || "".equals(certificate.trim()) || certificate.length() < 1||!certificate.equals(certificate.toUpperCase())) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_CERTIFICATE);
		}
		return true;
	}

	public static boolean validateDescription(String description) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (description == null || "".equals(description) || description.length() < 3) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION);
		}
		return true;
	}

	public static boolean validateGenre(String genre) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (genre == null || "".equals(genre) || genre.length() < 3) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_GENRE);
		}
		return true;
	}
	
	public static boolean validateMovieImage(String movieImage) throws MovieValidateException {
        // Check for name, name should only have alphabets
        // For Simplicity, Check if name has a length of 1.
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
        // Check for name, name should only have alphabets
        // For Simplicity, Check if name has a length of 1.
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

	
		public static boolean validateDurationHours(int durationHours) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (durationHours <= 0 || durationHours > 12) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_DURATION_HOURS);
		}
		return true;
	}

	public static boolean validateDurationMinutes(int durationMinutes) throws MovieValidateException {
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 1.
		if (durationMinutes > 59) {
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


	public static boolean validateDurationSeconds(int durationSeconds) throws MovieValidateException {

		// For Simplicity, Check if name has length of 1.
		if (durationSeconds > 59) {
			throw new MovieValidateException(MovieValidatorErrors.INVALID_MOVIE_DURATION_SECONDS);
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
