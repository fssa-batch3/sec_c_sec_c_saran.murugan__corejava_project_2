
package com.fssa.movie.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.*;
import com.fssa.movie.validatorException.TheaterValidateException;
public class TestTheaterService {

	public static Theater addNewTheater() {
		Theater data=new Theater("Rohini Silver Screens: Koyambedu","https://maps.app.goo.gl/PRUSxSUDnyh3VPVU8","141/2, Poonamallee High Rd, Koyambedu, Chennai, Tamil Nadu 600107",300,190);
		
		return data;
	}
	
 	@Test
       public void testAddTheaterServiceLayer() throws DAOExceptions, TheaterValidateException{
     	Assertions.assertTrue(TheaterService.addTheater(addNewTheater()));
       }
	

}
