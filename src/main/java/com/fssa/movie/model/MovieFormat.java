package com.fssa.movie.model;


public enum MovieFormat {

	    DVD("DVD"),
	    BLU_RAY("Blu-ray"),
	    DIGITAL("Digital"),
	    VHS("VHS"),
	    STREAMING("Streaming"),
	    _4K("4K Ultra HD"),
	    _2D("2D"),
	    _3D("3D"),
	    DOLBY_ATMOS("Dolby Atmos");

	    private final String value;

	    MovieFormat(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	    
	    public static MovieFormat fromValue(String value) {
	        if (value == null || value.trim().isEmpty()) {
	            throw new IllegalArgumentException("Priority value cannot be empty or null");
	        }
	        for (MovieFormat movieFormat : MovieFormat.values()) {
	            if (movieFormat.value.equalsIgnoreCase(value.trim())) {
	                return movieFormat;
	            }
	        }
	        throw new IllegalArgumentException("Invalid priority value: " + value);
	    }

	    
	
}
