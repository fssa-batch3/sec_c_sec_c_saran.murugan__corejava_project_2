package com.fssa.movie.service;

import com.fssa.movie.DAO.TheaterDAO;
import com.fssa.movie.Validator.TheaterValidator;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Theater;
import com.fssa.movie.validatorException.TheaterValidateException;

public class TheaterService {

public static boolean addTheater(Theater theater) throws DAOExceptions, TheaterValidateException{
		
		if(TheaterValidator.validateTheater(theater)) {
			return TheaterDAO.createTheater(theater);
		}
		return true;	 
	}

}
