package com.fssa.movie.DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;




public class TestMovieDao {
	@Test
	 public void TestAddMovies() throws  SQLException , MovieValidateException, DAOExceptions{
		 
		 Movie movie = new Movie();
		 movie.setMovieId(2);
		 movie.setMovieName("CaptainMiller");
		 movie.setLanguage("Tamil");
		 movie.setFormat("2d");
		 movie.setCertificate("u");
		 movie.setGenre("Action,thriller");
		 movie.setDurationHours(2);
		 movie.setDurationMinutes(40);
		 movie.setDurationSeconds(10);
		 movie.setDescription("captainmiiler is histrocial movie and the dhnaush play lead role");
		 movie.setReleaseDate(LocalDate.of(2023, 7, 21));
		 movie.setMovieImage("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg");
		 movie.setMovieBanner("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg");
		 
		 boolean result = MovieDAO.createMovie(movie);
		 Assertions.assertTrue(result);
	 }
	
	@Test
    public void testDeleteMovie() throws SQLException, MovieValidateException {
        // Delete the book with ID 1 (which exists in the database)
        boolean result = MovieDAO.deleteMovies(11);
        assertTrue(result); // Check if the book is deleted successfully
    }
	
}

