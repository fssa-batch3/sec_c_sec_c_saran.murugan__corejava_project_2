package com.fssa.movie.model;

import java.time.LocalDate;

/**
 * 
 * Model object for representing movie in application.
 * 
 * @author SaranMurugan
 *
 */

public class Movie {

	private String movieName;
	private String language;
	private String format;
	private String certificate;
	private String genre;
	private int durationHours;
	private int durationMinutes;
	private int durationSeconds;
	private String description;
	private LocalDate releaseDate;
	private int movieId;
	private String movieImage;
	private String movieBanner;
	
//	default constructor
	public 	Movie() {
		
	}
//parameterized constructor
	public Movie(int movieId,String movieName, String language, String format, String certificate, String genre, int durationHours,
			int durationMinutes, int durationSeconds, String description, LocalDate releaseDate, 
			String movieImage, String movieBanner) {

		this.movieName = movieName;
		this.language = language;
		this.format = format;
		this.certificate = certificate;
		this.genre = genre;
		this.durationHours = durationHours;
		this.durationMinutes = durationMinutes;
		this.durationSeconds = durationSeconds;
		this.description = description;
		this.releaseDate = releaseDate;
		this.movieId = movieId;
		this.movieImage = movieImage;
		this.movieBanner = movieBanner;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public String getMovieBanner() {
		return movieBanner;
	}

	public void setMovieBanner(String movieBanner) {
		this.movieBanner = movieBanner;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getDurationHours() {
		return durationHours;
	}

	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public int getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(int durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	
}
