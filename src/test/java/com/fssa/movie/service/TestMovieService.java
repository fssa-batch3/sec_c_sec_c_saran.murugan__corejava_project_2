package com.fssa.movie.service;

import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;


public class TestMovieService {
	
	public static Movie movie() {
		Movie data=new Movie(8,"Vaathi","Tamil","2D","UA","Action,thriller",2,40,10,"  vaathi is a tamil and telugu movie ",LocalDate.of(2023, 7, 21),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg","https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg");
    	
		return data;
	}
	public static Movie updatemovies() {
		Movie dataone=new Movie(3,"leo","Tamil","2D","UA","Action,thriller",2,40,10,"leo is the action movie and lead role is vijay ",LocalDate.of(2023, 7, 21),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg","https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg");
    	
		return dataone;
	}


   @Test
   public void testAddMovieServiceLayer() throws DAOExceptions, MovieValidateException{
	Assertions.assertTrue(MovieService. addMovie(movie()));
   }
   
   @Test
   public void testUpdateMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
	Assertions.assertTrue(MovieService.updateMovie(updatemovies()));
   }
   @Test
   public void testDeleteMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
	Assertions.assertTrue(MovieService.deleteMovie(2));
   }
   @Test
   public void testShowMovieByName(String name) throws DAOExceptions, MovieValidateException, SQLException{
	   Assertions.assertTrue(MovieService.showMovieByName("leo")); 
   }
   
}
