package com.fssa.movie.service;

import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.MovieShow;
import com.fssa.movie.validatorException.MovieShowValidateException;

public class TestMovieShowService {

	public static MovieShow addNewShow() {
		
		MovieShow data=new MovieShow(1,1,LocalTime.of(10, 30));
		
		return data;
	}
	
	
	@Test
    public void testAddMovieShowServiceLayer() throws DAOExceptions, MovieShowValidateException{
  	Assertions.assertTrue(MovieShowService.createShowTime(addNewShow()));
    }

}
