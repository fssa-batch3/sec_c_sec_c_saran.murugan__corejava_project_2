package com.fssa.movie.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.model.User;
import com.fssa.movie.validatorException.UserValidateException;

public class TestUserService {

	public static User loginUser() {
		User data = new User("dhanush","vijay@gmail.com","Saran123","7358516714");

		return data;
	}

	public static User updateUser() {
		User data = new User();
		return data;
	}

	@Test
	public void testAddUserServiceLayer() throws Exception {
		Assertions.assertTrue(UserService.registerUser(loginUser()));
	}

	@Test
	void testGetUserById() throws UserValidateException {

		User us = UserService.getUserById(1);
		CustomLogger log = new CustomLogger();
		CustomLogger.info(us);

	}
}
