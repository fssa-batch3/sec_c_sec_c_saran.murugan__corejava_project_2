package com.fssa.movie.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import com.fssa.letzshow.util.*;
import java.util.*;

import com.fssa.movie.connection.*;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.daoException.DaoExceptionMessage;
import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;



public class MovieDAO {
    public static boolean createMovie(Movie movie) throws DAOExceptions {
    	Connection connection=GetConnection.getConnection();
        try  {
            // Create insert statement
            String insertQuery = "INSERT INTO movie_details (movie_id,movie_title, language, format, certificate, genre, " +
                                 "durationHours, durationMinutes, durationSeconds, description, releaseDate,movie_image_url,movie_banner_url)" +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
      


            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the prepared statement
                preparedStatement.setInt(1, movie.getMovieId());
                preparedStatement.setString(2, movie.getMovieName());
                preparedStatement.setString(3, movie.getLanguage());
                preparedStatement.setString(4, movie.getFormat());
                preparedStatement.setString(5, movie.getCertificate());
                preparedStatement.setString(6, movie.getGenre());
                preparedStatement.setInt(7, movie.getDurationHours());
                preparedStatement.setInt(8, movie.getDurationMinutes());
                preparedStatement.setInt(9, movie.getDurationSeconds());
                preparedStatement.setString(10, movie.getDescription());
                preparedStatement.setDate(11, java.sql.Date.valueOf(movie.getReleaseDate()));
                preparedStatement.setString(12, movie.getMovieImage());
                preparedStatement.setString(13, movie.getMovieBanner());

                // Execute insert statement
                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted == 0) {
                	
                    throw new DAOExceptions("Failed to insert the movie into the database.");
                }
            }
            CustomLogger.info("succesfull");
        } catch (SQLException e) {
            // Handle any database-related errors
            throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
        }
        return true;
        
    }
    
    
        public static boolean updateMovies(Movie movie) throws MovieValidateException,SQLException{
        	
        	  try(Connection conn=GetConnection.getConnection()){
        		  
        		  try(PreparedStatement pstmt = conn.prepareStatement("UPDATE movie_details SET movie_title=?, language=?, format=?, certificate=?, genre=? , durationHours=?, durationMinutes=?, durationSeconds=?, description=?, releaseDate=?,movie_image_url=?,movie_banner_url=? WHERE movie_id=?")){
        			  
        			  pstmt.setString(1, movie.getMovieName());
        			  pstmt.setString(2, movie.getLanguage());
                      pstmt.setString(3,movie.getFormat());
                      pstmt.setString(4,movie.getCertificate());
                      pstmt.setString(5,movie.getGenre());
                      pstmt.setInt(6,movie.getDurationHours());
                      pstmt.setInt(7,movie.getDurationMinutes());
                      pstmt.setInt(8,movie.getDurationSeconds());
                      pstmt.setString(9,movie.getDescription());
                      pstmt.setDate(10, java.sql.Date.valueOf(movie.getReleaseDate()));
                      pstmt.setString(11,movie.getMovieImage());
                      pstmt.setString(12,movie.getMovieBanner());
                      pstmt.setInt(13,movie.getMovieId());

                      int rowsAffected = pstmt.executeUpdate();
                      if (rowsAffected > 0) {
                    	  CustomLogger.info("Movie Updated Successfully");
                          return true; // Movie updated successfully
                      }
                      else {
                          throw new MovieValidateException(DaoExceptionMessage.UPDATE_MOVIE);
                      }

        		  }
        		  
        	  }
        }
    
        
        public static boolean deleteMovies(int movieId) throws  MovieValidateException,SQLException {
            try (Connection conn=GetConnection.getConnection()) {
                try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM movie_details WHERE movie_id=?")) {
                    pstmt.setInt(1, movieId);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                    	CustomLogger.info("movie Successfully");
                        return true; // movie deleted successfully
                    } else {
                    	CustomLogger.info("Failed to delete the movie");
                        return false; // Failed to delete the movie
                    }
                }
            }
        }

            public static List<Movie> showMovieByName(String name) throws MovieValidateException, SQLException {
            	
            	List<Movie> movieList = new ArrayList<Movie>();
            
               
                String READ_QUERY = "SELECT * FROM movie_details WHERE movie_title = ?";
                try (Connection conn=GetConnection.getConnection()) {
                    try (PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {
                        pstmt.setString(1, name);
                        try (ResultSet rs = pstmt.executeQuery()) {
                            while (rs.next()){
                                int movieId = rs.getInt("movie_id");
                                String title = rs.getString("movie_title");
                                String language = rs.getString("language");
                                String format = rs.getString("format");
                                String certificate = rs.getString("certificate");
                                String genre = rs.getString("genre");
                                int  durationHour = rs.getInt("durationHours");
                                int  durationMinutes = rs.getInt("durationMinutes");
                                int  durationSeconds = rs.getInt("durationSeconds");
                                String description= rs.getString("description");
                                LocalDate releaseDate = rs.getDate("releaseDate").toLocalDate();
                                String movieImage = rs.getString("movie_image_url");
                                String bannerImage = rs.getString("movie_banner_url");

                                Movie movie = new Movie();
                               // movie = new Movie();
                                movie.setMovieId(movieId);
                                movie.setMovieName(title);
                                movie.setLanguage(language);
                                movie.setFormat(format);
                                movie.setCertificate(certificate);
                                movie.setGenre(genre);
                                movie.setDurationHours(durationHour);
                                movie.setDurationMinutes(durationMinutes);
                                movie.setDurationSeconds(durationSeconds);
                                movie.setDescription(description);
                                movie.setReleaseDate(releaseDate);
                                movie.setMovieImage(movieImage);
                                movie.setMovieBanner(bannerImage);
                                CustomLogger.info(movie.getMovieId()+"|"+movie.getMovieName()+"|"+movie.getLanguage()+"|"+movie.getFormat()+"|"+movie.getCertificate()+"|"+movie.getGenre()+"|"+movie.getDurationHours()+"|"+movie.getDurationMinutes()+"|"+movie.getDurationSeconds()+"|"+movie.getDescription()+"|"+movie.getReleaseDate()+"|"+movie.getMovieImage()+"|"+movie.getMovieBanner());
                            }
                        }
                    }
                }
                return movieList;
            }

}

