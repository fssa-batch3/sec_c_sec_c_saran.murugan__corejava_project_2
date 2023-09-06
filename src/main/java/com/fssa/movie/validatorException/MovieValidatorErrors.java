package com.fssa.movie.validatorException;

public class MovieValidatorErrors {

	    // Constant naming convention it should always be in CAPS
	
		// INVALID_STUDENT_NULL for throwing NULLity checks during validation
		public static final String INVALID_MOVIE_NULL = "Movie can't be NULL"; 
		public static final String INVALID_MOVIE_NAME = "Movie Name cannot be empty or null";
		public static final String INVALID_MOVIE_DESCRIPTION = "Movie description cannot be empty or null";
		public static final String INVALID_MOVIE_RELEASE_DATE = "Movie release date cannot be empty or null and not allow to before today";
		public static final String INVALID_MOVIE_DURATION_HOURS = "Movie duration hour cannot be 0";
		public static final String INVALID_MOVIE_DURATION_SECONDS = "Movie duration seconds cannot be 0";
		public static final String INVALID_MOVIE_DURATION_MINUTES = "Movie duration minutes cannot be 0";
		public static final String INVALID_MOVIE_ID = "Movie id cannot be less than zero or empty";
		public static final String INVALID_MOVIE_IMAGE = "Movie image url  cannot empty or null";
		public static final String INVALID_MOVIE_BANNER = "Movie banner url  cannot empty or null";
		public static final String INVALID_MOVIE_BANNER_NULL = "Movie banner url  cannot null";
		public static final String INVALID_MOVIE_BANNER_EMPTY = "Movie banner url  cannot empty ";
		public static final String INVALID_MOVIE_BANNER_LENGTH = "Movie banner url  length should be greater than 10 and should be start with https// dont need numbers";





		

}
