package com.fssa.movie.model;


public enum MovieLanguage {
	
	
	    TAMIL("Tamil"), ENGLISH("English"), HINDI("Hindi"), TELUGU("Telugu"),KANADA("Kanada"),MALAYALAM("Malayalam");

	    private final String value;

	    MovieLanguage(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	


	    public static MovieLanguage fromValue(String value) {
	        if (value == null || value.trim().isEmpty()) {
	            throw new IllegalArgumentException("Priority value cannot be empty or null");
	        }
	        for (MovieLanguage movieLanguage : MovieLanguage.values()) {
	            if (movieLanguage.value.equalsIgnoreCase(value.trim())) {
	                return movieLanguage;
	            }
	        }
	        throw new IllegalArgumentException("Invalid priority value: " + value);
	    }
	    
 }



