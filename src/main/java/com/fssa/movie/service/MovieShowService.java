package com.fssa.movie.service;

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
	
}
