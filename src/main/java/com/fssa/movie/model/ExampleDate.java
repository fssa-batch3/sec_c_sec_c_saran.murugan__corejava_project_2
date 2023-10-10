package com.fssa.movie.model;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class ExampleDate {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2023, 9, 26);

	    // Get the month name
	    String monthName = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String dayOfWeekName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);


	    System.out.println("Month Name: " + monthName);
	    System.out.println(dayOfWeekName);

	}
	

}
