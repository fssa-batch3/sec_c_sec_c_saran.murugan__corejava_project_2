package com.fssa.movie.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.model.MovieCertificate;
import com.fssa.movie.model.MovieFormat;
import com.fssa.movie.model.MovieGenre;
import com.fssa.movie.model.MovieLanguage;
import com.fssa.movie.model.MovieStatus;
import com.fssa.movie.validatorException.MovieValidateException;

public class TestMovieService {


	public static Movie addNewMovies() {
		Movie data=new Movie("kushi",MovieLanguage.Tamil,MovieFormat.FORMAT_2D,MovieCertificate.UA,MovieGenre.Romance,2,53,10,"A couple who are predicted to have a failed marriage, decide to become ideal partners for each other. Will it work out or will they realize that their parents were right?",LocalDate.of(2023, 9, 7),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/kushi-et00328665-1693390326.jpg","https://static.moviecrow.com/gallery/20230710/217256-Jawan%20Prevue%20SRK%20Atlee.png",MovieStatus.CURRENTLY_RUNNING);
		
		return data;
	}
	public static Movie updateMovies() {
		Movie data=new Movie(7,"kushi",MovieLanguage.Tamil,MovieFormat.FORMAT_2D,MovieCertificate.UA,MovieGenre.Romance,2,55,10,"A couple who are predicted to have a failed marriage, decide to become ideal partners for each other. Will it work out or will they realize that their parents were right?",LocalDate.of(2023, 9, 7),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/kushi-et00328665-1693390326.jpg","https://static.moviecrow.com/gallery/20230710/217256-Jawan%20Prevue%20SRK%20Atlee.png",MovieStatus.CURRENTLY_RUNNING);
		
		return data;
	}
	
	
	
	@Test
       public void testAddMovieServiceLayer() throws DAOExceptions, MovieValidateException{
     	Assertions.assertTrue(MovieService.addMovie(addNewMovies()));
       }
	
	
	@Test
	public void testReadMovieServiceLayer()  throws DAOExceptions, MovieValidateException, SQLException {
	  List<Movie> movieList = MovieService.readMovies();
	  for(Movie movies :movieList) {
		  CustomLogger.info(movies);
	  }
	}
      
    @Test
         public void testUpdateMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
        Assertions.assertTrue(MovieService.updateMovie(updateMovies()));
           }

   	
    @Test	
     	void testMovieByName() throws DAOExceptions, MovieValidateException, SQLException {
    	
     		List<Movie> MovieList = MovieService.showMovieByName("Jailer");
     		for(Movie movie : MovieList) {
     			
     			CustomLogger.info(movie);
     		}
     	}

    @Test
    	  void testDeleteMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
   		Assertions.assertTrue(MovieService.deleteMovie(7));
     	  }
    
     
    @Test	
 	void testShowMovieByCertificate() throws DAOExceptions, MovieValidateException, SQLException {
 		Assertions.assertTrue(MovieService.showMovieByCertificate("UA"));
 	}

    
   
	 
}

