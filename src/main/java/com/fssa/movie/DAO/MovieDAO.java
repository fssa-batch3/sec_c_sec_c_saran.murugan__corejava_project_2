package com.fssa.movie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.daoException.DaoExceptionMessage;
import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;
import day11.solved.ConnectionUtil;


public class MovieDAO {
    private static final String URL = "jdbc:mysql://Localhost:3306/letz_show";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static boolean createMovie(Movie movie) throws DAOExceptions {
        try (Connection connection = DriverManager.getConnection(URL,USER, PASSWORD)) {
            // Create insert statement
            String insertQuery = "INSERT INTO movie_details (movie_id,movie_title, language, format, certificate, genre, " +
                                 "durationHours, durationMinutes, durationSeconds, description, releaseDate,movie_image_url,movie_banner_url)" +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
            
//            String query ="SELECT * FROM MOVIE_DETAILS WHERE MOVIE_NAME = ?";
//            PreparedStatement.setString()
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
            System.out.println("succesfull");
        } catch (SQLException e) {
            // Handle any database-related errors
            throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
        }
        return true;
        
    }
    
    
        public static boolean updateMovies(Movie movie) throws MovieValidateException,SQLException{
        	
        	  try(Connection conn = DriverManager.getConnection(URL,USER, PASSWORD)){
        		  
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
                          System.out.println("Updated Successfully");
                          return true; // Book updated successfully
                      }
                      else {
                          throw new MovieValidateException(DaoExceptionMessage.UPDATE_MOVIE);
                      }

        		  }
        		  
        	  }
        }
    
        
        public static boolean deleteMovies(int movieId) throws  MovieValidateException,SQLException {
            try (Connection conn = ConnectionUtil.getConnection()) {
                try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM movie_details WHERE movie_id=?")) {
                    pstmt.setInt(1, movieId);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Deleted Successfully");
                        return true; // Book deleted successfully
                    } else {
                        System.out.println("Failed to delete the book");
                        return false; // Failed to delete the book
                    }
                }
            }
        }

            public static Movie showMovieByName(String name) throws MovieValidateException, SQLException {
                Movie movie = null;
                String READ_QUERY = "SELECT * FROM movie_details WHERE movie_title = ?";
                try (Connection conn = ConnectionUtil.getConnection()) {
                    try (PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {
                        pstmt.setString(1, name);
                        try (ResultSet rs = pstmt.executeQuery()) {
                            while (rs.next()) {
                                movie = new Movie();
                                movie.setMovieId(rs.getInt("movie_id"));
                                movie.setMovieName(rs.getString("movie_title"));
                                movie.setLanguage(rs.getString("language"));
                                movie.setFormat(rs.getString("format"));
                                movie.setCertificate(rs.getString("certificate"));
                                movie.setGenre(rs.getString("genre"));
                                movie.setDurationHours(rs.getInt("durationHours"));
                                movie.setDurationMinutes(rs.getInt("durationMinutes"));
                                movie.setDurationSeconds(rs.getInt("durationSeconds"));
                                movie.setDescription(rs.getString("description"));
                                movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                                movie.setMovieImage(rs.getString("movie_image_url"));
                                movie.setMovieBanner(rs.getString("movie_banner_url"));

                            }
                        }
                    }
                }
                return movie;
            }

            public static void main(String[] args) throws MovieValidateException, SQLException {
                Movie movie = showMovieByName("Master");
                if (movie != null) {
                    System.out.println("Movie ID: " + movie.getMovieId());
                    System.out.println("Movie Title: " + movie.getMovieName());
                    // Print other movie details
                } else {
                    System.out.println("Movie not found.");
                }
            }

}

