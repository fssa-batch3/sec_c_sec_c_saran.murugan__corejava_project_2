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
		Movie data=new Movie(3,"CaptainMiller","Tamil","2D","u","Action,thriller",2,40,10,"captainmiiler is histrocial movie and the dhnaush play lead role",LocalDate.of(2023, 7, 21),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg","https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg");
    	
		return data;
	}
	
//	
//   @Test
//   public void testAddMovieServiceLayer() throws DAOExceptions, MovieValidateException{
//	Assertions.assertTrue(MovieService.addMovie(movie()));
//   }
   
   @Test
   public void testUpdateMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
	Assertions.assertTrue(MovieService.updateMovie(movie()));
   }
//   @Test
//   public void testDeleteMovieServiceLayer() throws DAOExceptions, MovieValidateException, SQLException{
//	Assertions.assertTrue(MovieService.deleteMovie(2));
//   }
   @Test
   public void testShowMovieByName(String name) throws DAOExceptions, MovieValidateException, SQLException{
	   Assertions.assertTrue(MovieService.showMovieByName("Master")); 
   }
   
}
