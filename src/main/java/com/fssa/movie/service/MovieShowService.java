package com.fssa.movie.service;

import java.util.List;
import java.util.Map;

import com.fssa.movie.DAO.MovieShowDAO;
import com.fssa.movie.Validator.MovieShowValidator;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.MovieShow;
import com.fssa.movie.validatorException.MovieShowValidateException;

public class MovieShowService {
	
	
	public static boolean createShowTime(MovieShow showTime) throws DAOExceptions, MovieShowValidateException {
	    if (MovieShowValidator.validateMovieShow(showTime)) {
	        return MovieShowDAO.createShow(showTime);
	    }
	    return true;
	}
	
	 public static List<MovieShow> readAllShows() throws DAOExceptions {
	        try {
	            return MovieShowDAO.readAllShows();
	        } catch (DAOExceptions e) {
	            throw e; // You may want to handle or log the exception here
	        }
	    }
	 
	 public static List<Map<String, String>> getMovieShowDetails() throws DAOExceptions {
	        try {
	            return MovieShowDAO.getMovieShowDetails();
	        } catch (DAOExceptions e) {
	            throw e; // You may want to handle or log the exception here
	        }
	    }
	
}
