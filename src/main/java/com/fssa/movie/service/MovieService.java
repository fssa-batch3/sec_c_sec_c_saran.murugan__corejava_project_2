package com.fssa.movie.service;

import com.fssa.movie.Validator.MovieValidator;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;
import java.sql.SQLException;
import com.fssa.movie.DAO.*;

public class MovieService {

	
	public static boolean addMovie(Movie movie) throws DAOExceptions, MovieValidateException{
		
		if(MovieValidator.validate(movie)) {
			MovieDAO.createMovie(movie);
		}
		return true;	
	}
	
   public static boolean updateMovie(Movie movie) throws DAOExceptions, MovieValidateException, SQLException{
		
		if(MovieValidator.validate(movie)) {
			MovieDAO.updateMovies(movie);
		}
		return true;	
		
	}
   public static boolean deleteMovie(int id) throws DAOExceptions, MovieValidateException, SQLException{
		
		if(MovieValidator.validateMovieId(id)) {
			MovieDAO.deleteMovies(id);
		}
		return true;	
	}
   public static boolean showMovieByName(String name) throws DAOExceptions, MovieValidateException, SQLException{
		
		if(MovieValidator.validateName(name)) {
			MovieDAO.showMovieByName(name);
		}
		return true;	
	}
   
}
