package com.fssa.movie.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieShow{
	
    private int show_id;
    private int movieId; // ID of the associated movie
    private int theaterId; // ID of the associated theater
    private LocalTime showTime;
    private LocalDate showDate; // Added showDate variable

    

  

	// Constructors
    public MovieShow(int show_id, int movieId, int theaterId, LocalTime showTime) {
        this.show_id =show_id;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
    }

    public MovieShow(int movieId, int theaterId, LocalTime showTime, LocalDate showDate) {
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
        this.showDate = showDate;
    }

    public MovieShow() {
		// TODO Auto-generated constructor stub
	}

	
	public MovieShow(String movieTitle, String theaterName, String showTime2, String showDate2) {
		// TODO Auto-generated constructor stub
	}

	public int getShow_id() {
  		return show_id;
  	}

  	public void setShow_id(int show_id) {
  		this.show_id = show_id;
  	}

  	public LocalDate getShowDate() {
  		return showDate;
  	}

  	public void setShowDate(LocalDate showDate) {
  		this.showDate = showDate;
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
