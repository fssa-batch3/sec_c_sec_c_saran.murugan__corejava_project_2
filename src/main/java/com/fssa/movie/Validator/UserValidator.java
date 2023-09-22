package com.fssa.movie.Validator;

import com.fssa.movie.model.User;
import com.fssa.movie.validatorException.*;

public class UserValidator {

	public static boolean validateUser(User users) throws UserValidateException {
		if (users == null) {
			throw new UserValidateException(UserValidatorErrors.INVALID_USER_NULL);
		}
		validateUsername(users.getUsername());
		validateEmail(users.getEmail());
		validateNumber(users.getNumber());
		validatePassword(users.getPassword());
		return true;
	}

	public static boolean validateUsername(String username) throws UserValidateException {
		if (username == null || username.length() < 2) {
			throw new UserValidateException(UserValidatorErrors.INVALID_USERNAME);
		}
		return true;
	}

	public static boolean validateEmail(String email) throws UserValidateException {
		if (email == null) {
			throw new UserValidateException(UserValidatorErrors.INVALID_EMAIL);
		}
		return true;

	}

	public static boolean validatePassword(String password) throws UserValidateException {
		if (password == null || password.length() < 6) {
			throw new UserValidateException(UserValidatorErrors.INVALID_PASSWORD);
		}
		return true;
	}

	public static boolean validateNumber(String number) throws UserValidateException {
		if (number == null || !number.matches("\\d{10}")) {
			throw new UserValidateException(UserValidatorErrors.INVALID_NUMBER);
		}
		return true;
	}

	public static boolean validateUserId(int userId) throws UserValidateException {
		if (userId <= 0) {
			throw new UserValidateException(UserValidatorErrors.INVALID_USER_ID);
		}
		return true;
	}

}