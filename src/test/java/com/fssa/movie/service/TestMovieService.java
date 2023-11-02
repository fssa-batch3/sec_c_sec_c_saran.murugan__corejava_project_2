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
		Movie data=new Movie("kushi",MovieLanguage.TAMIL,MovieFormat.FORMAT_2D,MovieCertificate.UNIVERSAL,MovieGenre.ROMANCE,150,"A couple who are predicted to have a failed marriage, decide to become ideal partners for each other. Will it work out or will they realize that their parents were right?",LocalDate.of(2023, 9, 7),"https://timesofindia.indiatimes.com/photo/91608543.cms","https://static.zoomnews.com/photo/msid-103299067/103299067.jpg",MovieStatus.CURRENTLY_RUNNING);
		
		return data;
	}
	public static Movie updateMovies() {
		Movie data=new Movie(9,"Leo",MovieLanguage.TAMIL,MovieFormat.FORMAT_2D,MovieCertificate.UNIVERSAL_ADULT,MovieGenre.ACTION,150,"Leo is an action-thriller starring Vijay and Trisha Krishnan in the lead.",LocalDate.of(2023,10, 19),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/leo-et00351731-1675663884.jpg","https://m.media-amazon.com/images/M/MV5BOGQ2OTNmODQtNDRkOC00ODRmLTkwOWQtMmU1NjdmODQ0NTA3XkEyXkFqcGdeQXVyMTMxODA4Njgx._V1_FMjpg_UX1000_.jpg",MovieStatus.CURRENTLY_RUNNING);
		
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
    	
     		List<Movie> MovieList = MovieService.showMovieByName("Leo");
     		for(Movie movie : MovieList) {
     			
     			CustomLogger.info(movie);
     		}
     	}

          @Test
    	  void testDeleteMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
   	   	Assertions.assertTrue(MovieService.deleteMovie(16));
     	  }
    
     
    @Test	
 	void testShowMovieByCertificate() throws DAOExceptions, MovieValidateException, SQLException {
 		Assertions.assertTrue(MovieService.showMovieByCertificate("U"));
 	}

    
   
	 
}

