package com.fssa.movie.service;

import com.fssa.movie.Validator.MovieValidator;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.model.MovieCertificate;
import com.fssa.movie.validatorException.MovieValidateException;
import java.sql.SQLException;
import java.util.List;

import com.fssa.movie.DAO.*;

public class MovieService {

	
	public static boolean addMovie(Movie movie) throws DAOExceptions, MovieValidateException{
		
		if(MovieValidator.validate(movie)) {
			return MovieDAO.createMovie(movie);
		}
		return true;	 
	}
	
   public static boolean updateMovie(Movie movie) throws  MovieValidateException, SQLException{
		
		if(MovieValidator.validate(movie)) {
			MovieDAO.updateMovies(movie);
		}
		return true;	
		
	}
   

	public static List<Movie> readMovies() throws  SQLException{
		return MovieDAO.readAllMovies();
	}
  
	public static boolean deleteMovie(int id) throws  MovieValidateException, SQLException{
		
		if(MovieValidator.validateMovieId(id)) {
			MovieDAO.deleteMovies(id);
		}
		return true;	 
	}
   
   public static List<Movie> showMovieByName(String name) throws MovieValidateException, SQLException{
		

		return MovieDAO.showMovieByName(name);
		
		 
	}
   public static boolean showMovieByCertificate(String certificate)throws  MovieValidateException, SQLException  {
	     
	   if(certificate!=null) {
	    	 MovieDAO.searchByCertificateName(certificate);
	     }
	   return true;
	   
   }
   
   public static int getMovieIdByName(String movieName) throws MovieValidateException, SQLException, DAOExceptions {
       if (MovieValidator.validateName(movieName)) {
           return MovieDAO.getMovieIdByName(movieName);
       }
       return -1; 
   }
    
   
   public Movie getMovieById(int id) throws DAOExceptions {
       return MovieDAO.showMovieById(id);
   }

   
}
