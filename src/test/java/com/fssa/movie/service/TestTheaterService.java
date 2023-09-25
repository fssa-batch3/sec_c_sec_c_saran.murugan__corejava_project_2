package com.fssa.movie.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.*;
import com.fssa.movie.validatorException.TheaterValidateException;
public class TestTheaterService {

	public static Theater addNewTheater() {
		Theater data=new Theater("PVR Heritage RSL ECR Chennai","https://maps.app.goo.gl/c4RuXc8UTgL6FeGW9","1st Floor Near Uthandi Toll Gate Survey No: 3/488B1A And 3/700 No 17 Village, Uthandi, Chennai, Tamil Nadu 600119",300);
		
		return data;
	}
	
 	@Test
       public void testAddTheaterServiceLayer() throws DAOExceptions, TheaterValidateException{
     	Assertions.assertTrue(TheaterService.addTheater(addNewTheater()));
       }
	

}
