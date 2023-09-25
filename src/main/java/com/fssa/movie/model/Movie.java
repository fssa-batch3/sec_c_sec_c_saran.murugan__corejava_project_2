package com.fssa.movie.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 * 
 * Model object for representing movie details in application.
 * 
 * @author SaranMurugan
 *
 */

public class Movie {

	private String movieName;
	private MovieLanguage language;
	private MovieFormat format;
	private MovieCertificate certificate;
	private MovieGenre genre;
	private int durationMinutes;
	private String description;
	private LocalDate releaseDate;
	private int movieId;
	private String movieImage;
	private String movieBanner;
	private MovieStatus status;
	

  
	//default constructor

	public Movie(int movieId2, String title, String language2, String format2, String certificate2, String genre2, int durationHours2, int durationMinutes2, int durationSeconds2, String description2, String releaseDate2, String movieImageUrl, String movieBannerUrl) {

	}

	public Movie(String movieName, MovieLanguage language, MovieFormat format, MovieCertificate certificate,
			MovieGenre genre, int durationMinutes, String description,
			LocalDate releaseDate, String movieImage, String movieBanner,MovieStatus status) {
		super();
		this.movieName = movieName;
		this.language = language;
		this.format = format;
		this.certificate = certificate;
		this.genre = genre;
		this.durationMinutes = durationMinutes;
		this.description = description;
		this.releaseDate = releaseDate;
		this.movieImage = movieImage;
		this.movieBanner = movieBanner;
		this.status= status;
	}
	
	
	public Movie(int id, String name, MovieLanguage tamil, MovieFormat format, MovieCertificate certificate,
			MovieGenre genre,int minutes,String description, LocalDate releaseDate, String imageUrl, String movieBanner,
			MovieStatus status) {
		super();
		this.movieId=id;
		this.movieName = name;
		this.language = tamil;
		this.format = format;
		this.certificate = certificate;
		this.genre = genre;
		this.durationMinutes = minutes;
		this.description = description;
		this.releaseDate = releaseDate;
		this.movieImage = imageUrl;
		this.movieBanner = movieBanner;
		this.status= status;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}
    public Movie(ResultSet resultSet) throws SQLException {
        // Populate fields from ResultSet
        this.movieId = resultSet.getInt("movie_id");
        this.movieName = resultSet.getString("movie_title");
        this.language = MovieLanguage.fromValue(resultSet.getString("language"));
        this.format = MovieFormat.fromValue(resultSet.getString("format"));
        this.certificate = MovieCertificate.fromValue(resultSet.getString("certificate"));
        this.genre = MovieGenre.fromValue(resultSet.getString("genre"));
        this.durationMinutes = resultSet.getInt("durationMinutes");
        this.durationMinutes = resultSet.getInt("durationMinutes");
        this.description = resultSet.getString("description");
        this.releaseDate = resultSet.getDate("releaseDate").toLocalDate();
        this.movieImage = resultSet.getString("movie_image_url");
        this.movieBanner = resultSet.getString("movie_banner_url");
    }

    // Getters for Movie class (generated automatically)

    // Example of a getter:
   
    public String toString1() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + movieName + '\'' +
                ", language='" + language + '\'' +
                ", format='" + format + '\'' +
                ", certificate='" + certificate + '\'' +
                ", genre='" + genre + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", movieImageUrl='" + movieImage + '\'' +
                ", movieBannerUrl='" + movieBanner + '\'' +
                '}';
    }



	public String toString() {
		return "Movie [movieName=" + movieName + ", language=" + language + ", format=" + format + ", certificate="
				+ certificate + ", genre=" + genre + ", durationHours=" +  ", durationMinutes="
				+ durationMinutes + ", description=" + description
				+ ", releaseDate=" + releaseDate + ", movieId=" + movieId + ", movieImage=" + movieImage
				+ ", movieBanner=" + movieBanner + ", status=" + status + "]";
	}

	public MovieStatus getStatus() {
		return status;
	}

	public void setStatus(MovieStatus status) {
		this.status = status;
	}


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public MovieLanguage getLanguage() {
		return language;
	}

	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}

	public MovieFormat getFormat() {
		return format;
	}

	public void setFormat(MovieFormat format) {
		this.format = format;
	}

	public MovieCertificate getCertificate() {
		return certificate;
	}

	public void setCertificate(MovieCertificate certificate) {
		this.certificate = certificate;
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}


	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
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

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
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

	
	
}
