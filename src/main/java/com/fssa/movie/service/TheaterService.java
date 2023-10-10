
package com.fssa.movie.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.movie.DAO.MovieDAO;
import com.fssa.movie.DAO.TheaterDAO;
import com.fssa.movie.Validator.TheaterValidator;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.model.Theater;
import com.fssa.movie.validatorException.TheaterValidateException;

public class TheaterService {

    public static boolean addTheater(Theater theater) throws DAOExceptions, TheaterValidateException{
		
		if(TheaterValidator.validateTheater(theater)) {
			return TheaterDAO.createTheater(theater);
		}
		return true;	 
	}

    public static List<Theater> readTheaters() throws  SQLException{
		return TheaterDAO.readAllTheaters();
	}

 
    public static Theater getTheaterDetailsByID(int id) throws DAOExceptions {
    	
    	return TheaterDAO.getTheaterDetailsById(id);
    	}
    }