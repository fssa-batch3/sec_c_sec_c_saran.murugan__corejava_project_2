package com.fssa.movie.validatorException;

public class TheaterValidatorErrors {

	public static final String INVALID_THEATER_NULL = "Theater can't be NULL"; 
	public static final String INVALID_THEATER_NAME = "Theater Name cannot be empty or null";
	public static final String INVALID_THEATER_LOCATION = "Theater location cannot be  null and match with url regex pattern";
	public static final String INVALID_THEATER_ADDRESS = "Theater address cannot be empty or null";
	public static final String INVALID_THEATER_NUM_SEATS = "Theater seats not below 0 or negative numbers";

}
