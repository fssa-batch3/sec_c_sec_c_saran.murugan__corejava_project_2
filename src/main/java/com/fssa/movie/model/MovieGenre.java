package com.fssa.movie.model;


public enum MovieGenre {
    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR("Horror"),
    SCIENCE_FICTION("Science Fiction"),
    ROMANCE("Romance"),
    LOVE("Love"),
    THRILLER("Thriller"),
    FANTASY("Fantasy"),
    ANIMATION("Animation"),
    ADVENTURE("Adventure"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    MUSICAL("Musical"),
    WAR("War"),
    WESTERN("Western"),
    HISTORICAL("Historical"),
    MYSTERY("Mystery"),
    SUPERHERO("Superhero");

    private final String value;

    MovieGenre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    

    public static MovieGenre fromValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Priority value cannot be empty or null");
        }
        for (MovieGenre genre : MovieGenre.values()) {
            if (genre.value.equalsIgnoreCase(value.trim())) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Invalid priority value: " + value);
    }
    

}
