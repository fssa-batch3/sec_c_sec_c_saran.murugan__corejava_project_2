package com.fssa.movie.model;


public enum MovieCertificate {
    UNIVERSAL("U"),
    UNIVERSAL_ADULT("UA"),
    ADULT("A"),
    SPECIAL("S"),
    RESTRICTED("R"),
    NOT_RATED("NR");

    private final String value;

    MovieCertificate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static MovieCertificate fromValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Priority value cannot be empty or null");
        }
        for (MovieCertificate movieCertificate : MovieCertificate.values()) {
            if (movieCertificate.value.equalsIgnoreCase(value.trim())) {
                return movieCertificate;
            }
        }
        throw new IllegalArgumentException("Invalid priority value: " + value);
    }


}

