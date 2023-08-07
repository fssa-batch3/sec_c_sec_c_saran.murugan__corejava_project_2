package com.fssa.movie.validatorException;

public class MovieValidatorErrors {

	    // Constant naming convention it should always be in CAPS
	
		// INVALID_STUDENT_NULL for throwing NULLity checks during validation
		public static final String INVALID_MOVIE_NULL = "Movie can't be NULL"; 
		public static final String INVALID_MOVIE_NAME = "Movie Name cannot be empty or null";
		public static final String INVALID_MOVIE_LANGUAGE = "Language cannot be empty or null and length should greater than 2";
		public static final String INVALID_MOVIE_FORMAT = "Movie Format cannot be empty or null";
		public static final String INVALID_MOVIE_CERTIFICATE = "Movie certificate  cannot be empty or null";
		public static final String INVALID_MOVIE_GENRE= "Movie genre cannot be empty or null";
		public static final String INVALID_MOVIE_DESCRIPTION = "Movie description cannot be empty or null";
		public static final String INVALID_MOVIE_RELEASE_DATE = "Movie release date cannot be empty or null and not allow to before today";
		public static final String INVALID_MOVIE_DURATION_HOURS = "Movie Format cannot be empty or null";
		public static final String INVALID_MOVIE_DURATION_SECONDS = "Movie Format cannot be empty or null";
		public static final String INVALID_MOVIE_DURATION_MINUTES = "Movie Format cannot be empty or null";
		public static final String INVALID_MOVIE_ID = "Movie id cannot be less than zero or empty";
		public static final String INVALID_MOVIE_IMAGE = "Movie image url  cannot empty or null";
		public static final String INVALID_MOVIE_BANNER = "Movie banner url  cannot empty or null";



		

}
