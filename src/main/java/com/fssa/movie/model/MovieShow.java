package com.fssa.movie.model;

import java.time.LocalTime;

public class MovieShow{
	
    private int show_id;
    private int movieId; // ID of the associated movie
    private int theaterId; // ID of the associated theater
    private LocalTime showTime;

    // Constructors
    public MovieShow(int show_id, int movieId, int theaterId, LocalTime showTime) {
        this.show_id =show_id;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
    }

    public MovieShow(int movieId, int theaterId, LocalTime showTime) {
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
    }

    // Getters and setters
    public int getId() {
        return show_id;
    }

    public void setId(int id) {
        this.show_id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

}
