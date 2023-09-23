package com.fssa.movie.DAO;


import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.connection.GetConnection;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.daoException.DaoExceptionMessage;
import com.fssa.movie.model.Movie;
import com.fssa.movie.model.MovieCertificate;
import com.fssa.movie.model.MovieFormat;
import com.fssa.movie.model.MovieGenre;
import com.fssa.movie.model.MovieLanguage;
import com.fssa.movie.model.MovieStatus;
import com.fssa.movie.validatorException.MovieValidateException;



public class MovieDAO {
    public static boolean createMovie(Movie movie) throws DAOExceptions {
    
        try (Connection connection=GetConnection.getConnection()) {
            // Create insert statement
            String insertQuery = "INSERT INTO movie_details (movie_title, language, format, certificate, genre, " +
                                 "durationHours, durationMinutes, durationSeconds, description,releaseDate,movie_image_url,movie_banner_url,status)" +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the prepared statement
                preparedStatement.setString(1, movie.getMovieName());
                preparedStatement.setString(2, movie.getLanguage().toString());
                preparedStatement.setString(3, movie.getFormat().toString());
                preparedStatement.setString(4, movie.getCertificate().toString());
                preparedStatement.setString(5, movie.getGenre().toString());
                preparedStatement.setInt(6, movie.getDurationHours());
                preparedStatement.setInt(7, movie.getDurationMinutes());
                preparedStatement.setInt(8, movie.getDurationSeconds());
                preparedStatement.setString(9, movie.getDescription());
                preparedStatement.setDate(10, java.sql.Date.valueOf(movie.getReleaseDate()));
                preparedStatement.setString(11, movie.getMovieImage());
                preparedStatement.setString(12, movie.getMovieBanner());
                preparedStatement.setString(13, movie.getStatus().toString());

                // Execute insert statement
                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted == 0) {
                    throw new DAOExceptions("Failed to insert the movie into the database.");
                }
            }
            CustomLogger.info("Movie added succesfully");
        } catch (SQLException e) {
            // Handle any database-related errors
            throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
        }
        return true;
        
    }
    
    
        public static boolean updateMovies(Movie movie) throws MovieValidateException,SQLException{
        	
        	  try(Connection conn=GetConnection.getConnection()){
        		  
        		  try(PreparedStatement pstmt = conn.prepareStatement("UPDATE movie_details SET movie_title=?, language=?, format=?, certificate=?, genre=? , durationHours=?, durationMinutes=?, durationSeconds=?, description=?, releaseDate=?,movie_image_url=?,movie_banner_url=? ,status=? WHERE movie_id=?")){
        			  
        			  pstmt.setString(1, movie.getMovieName());
        			  pstmt.setString(2, movie.getLanguage().toString());
                      pstmt.setString(3,movie.getFormat().toString());
                      pstmt.setString(4,movie.getCertificate().toString());
                      pstmt.setString(5,movie.getGenre().toString());
                      pstmt.setInt(6,movie.getDurationHours());
                      pstmt.setInt(7,movie.getDurationMinutes());
                      pstmt.setInt(8,movie.getDurationSeconds());
                      pstmt.setString(9,movie.getDescription());
                      pstmt.setDate(10, java.sql.Date.valueOf(movie.getReleaseDate()));
                      pstmt.setString(11,movie.getMovieImage());
                      pstmt.setString(12,movie.getMovieBanner());
                      pstmt.setString(13, movie.getStatus().toString());
                      pstmt.setInt(14,movie.getMovieId());

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
    
        // Delete the movies in database
        public static boolean deleteMovies(int movieId) throws SQLException {
            try (Connection conn=GetConnection.getConnection()) {
                try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM movie_details WHERE movie_id=?")) {
                    pstmt.setInt(1, movieId);
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                    	CustomLogger.info("Movie deleted Successfully");
                        return true; // movie deleted successfully
                    } else {
                    	CustomLogger.info("Failed to delete the movie");
                        return false; // Failed to delete the movie
                    }
                }
            }
        } 

        //this method will do show the movie by name
        public static List<Movie> showMovieByName(String name) throws MovieValidateException, SQLException {
            List<Movie> movieList = new ArrayList<>();
            String READ_QUERY = "SELECT * FROM movie_details WHERE movie_title = ?";
            try (Connection conn = GetConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {
                pstmt.setString(1, name);            
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Movie movie = new Movie();                        
                        movie.setMovieId(rs.getInt("movie_id"));
                        movie.setMovieName(rs.getString("movie_title"));
                        movie.setLanguage(MovieLanguage.valueOf(rs.getString("language")));
                        movie.setFormat(MovieFormat.valueOf(rs.getString("format")));
                        movie.setCertificate(MovieCertificate.valueOf(rs.getString("certificate")));
                        movie.setGenre(MovieGenre.valueOf(rs.getString("genre")));
                        movie.setDurationHours(rs.getInt("durationHours"));
                        movie.setDurationMinutes(rs.getInt("durationMinutes"));
                        movie.setDurationSeconds(rs.getInt("durationSeconds"));
                        movie.setDescription(rs.getString("description"));
                        movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                        movie.setMovieImage(rs.getString("movie_image_url"));
                        movie.setMovieBanner(rs.getString("movie_banner_url"));
                        
                        movieList.add(movie); 
                    }
                }
            }
            
            return movieList;
        }
       
        public static List<Movie> searchByCertificateName(String name) throws MovieValidateException, SQLException {
            List<Movie> movieList = new ArrayList<>();
            String READ_QUERY = "SELECT * FROM movie_details WHERE certificate = ?";
            try (Connection conn = GetConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {
                pstmt.setString(1, name);            
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Movie movie = new Movie();                        
                        movie.setMovieId(rs.getInt("movie_id"));
                        movie.setMovieName(rs.getString("movie_title"));
                        movie.setLanguage(MovieLanguage.valueOf(rs.getString("language")));
                        movie.setFormat(MovieFormat.valueOf(rs.getString("format")));
                        movie.setCertificate(MovieCertificate.valueOf(rs.getString("certificate")));
                        movie.setGenre(MovieGenre.valueOf(rs.getString("genre")));
                        movie.setDurationHours(rs.getInt("durationHours"));
                        movie.setDurationMinutes(rs.getInt("durationMinutes"));
                        movie.setDurationSeconds(rs.getInt("durationSeconds"));
                        movie.setDescription(rs.getString("description"));
                        movie.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                        movie.setMovieImage(rs.getString("movie_image_url"));
                        movie.setMovieBanner(rs.getString("movie_banner_url"));
                        CustomLogger.info("["+movie.getMovieId() + "," + movie.getMovieName() + "," +movie.getLanguage() + "," +movie.getFormat() + "," +movie.getCertificate() + "," +movie.getGenre() + "," +movie.getDurationHours() + "," +movie.getDurationMinutes() + "," +movie.getDurationSeconds() + "," +movie.getDescription() + "," +movie.getReleaseDate() + "," +movie.getMovieImage() + "," +movie.getMovieBanner()+"]");
                        
                        movieList.add(movie); 
                    }
                }
            }
            
            return movieList;
        }

        
        public static List<Movie> readAllMovies() throws SQLException {
            List<Movie> movieList = new ArrayList<>();
            String READ_QUERY = "SELECT * FROM movie_details";
            try (Connection conn = GetConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(READ_QUERY)) {
                     
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Movie movie1 = new Movie();                        
       
                        movie1.setMovieName(rs.getString("movie_title"));
                        movie1.setLanguage(MovieLanguage.valueOf(rs.getString("language")));
                        movie1.setFormat(MovieFormat.valueOf(rs.getString("format")));
                        movie1.setCertificate(MovieCertificate.valueOf(rs.getString("certificate")));
                        movie1.setGenre(MovieGenre.valueOf(rs.getString("genre")));
                        movie1.setDurationHours(rs.getInt("durationHours"));
                        movie1.setDurationMinutes(rs.getInt("durationMinutes"));
                        movie1.setDurationSeconds(rs.getInt("durationSeconds"));
                        movie1.setDescription(rs.getString("description"));
                        movie1.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
                        movie1.setMovieImage(rs.getString("movie_image_url"));
                        movie1.setMovieBanner(rs.getString("movie_banner_url"));
                        movie1.setStatus(MovieStatus.valueOf(rs.getString("status")));
                        movieList.add(movie1); 
                    }
                }
            }
            
            return movieList;
        }
        
      
	        public static int getMovieIdByName(String movieName) throws DAOExceptions, SQLException {
	    		try (Connection connection = GetConnection.getConnection()) {
	    			// Create update statement using task id
	    			String query = "SELECT movie_id FROM movie_details WHERE movie_title = ? ";
	    			try (PreparedStatement pst = connection.prepareStatement(query)) {
	    				pst.setString(1, movieName);
	    				ResultSet rs = pst.executeQuery();
	    				// .executeQuery() .. returns result set
	    				// .executeUpdate() .. returns no of rows affected
	    				int id = 0;
	    				while (rs.next()) {
	    					id = rs.getInt("movie_id");
	    				}
	    				return id;
	    			}
	    		} catch (SQLException e) {
	    			throw new DAOExceptions("not get movieid by moviename", e);
	    		}
    	}

	        public static Movie showMovieById(int id) throws DAOExceptions {
	            try (Connection connection = GetConnection.getConnection()) {
	                String query = "SELECT * FROM movie_details WHERE movie_id = ?";
	                try (PreparedStatement statement = connection.prepareStatement(query)) {
	                    statement.setInt(1, id);
	                    try (ResultSet resultSet = statement.executeQuery()) {
	                        if (resultSet.next()) {
	                            int movieId = resultSet.getInt("id");
	                            String title = resultSet.getString("movie_title");
	                            String language = resultSet.getString("language");
	                            String format = resultSet.getString("format");
	                            String certificate = resultSet.getString("certificate");
	                            String genre = resultSet.getString("genre");
	                            int durationHours = resultSet.getInt("duration_hours");
	                            int durationMinutes = resultSet.getInt("duration_minutes");
	                            int durationSeconds = resultSet.getInt("duration_seconds");
	                            String description = resultSet.getString("description");
	                            String releaseDate = resultSet.getString("release_date");
	                            String movieImageUrl = resultSet.getString("movie_image_url");
	                            String movieBannerUrl = resultSet.getString("movie_banner_url");

	                            // Create a Movie object with the retrieved information
	                            Movie movie = new Movie(
	                                movieId, title, language, format, certificate, genre, 
	                                durationHours, durationMinutes, durationSeconds, description,
	                                releaseDate, movieImageUrl, movieBannerUrl
	                            );

	                            return movie;
	                        }
	                    }
	                }
	            } catch (SQLException e) {
	                throw new DAOExceptions(e.getMessage());
	            }
	            return null; // Return null if movie not found
	        }

		
        
}

