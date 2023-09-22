package com.fssa.movie.service;

import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.User;
import com.fssa.movie.validatorException.UserValidateException;

import java.sql.SQLException;
import java.util.List;

import com.fssa.movie.DAO.UserDAO;
import com.fssa.movie.Validator.*;

public class UserService {

	public static boolean registerUser(User user) throws Exception {
		try {
			if (UserValidator.validateUser(user)) {
				UserDAO.registerUser(user);
			}
			return true;
		} catch (DAOExceptions | SQLException e) {
			// Handle the exception appropriately (e.g., log it, provide user-friendly error
			// messages)
			e.printStackTrace();
//			return false; // Return an appropriate response for failure

			throw new Exception(e);
		}
	}

	public static User getUserById(int id) {
		try {
			return UserDAO.getUserById(id);
		} catch (DAOExceptions e) {
			// Handle the exception appropriately (e.g., log it, provide user-friendly error
			// messages)
			e.printStackTrace();
			return null; // Return an appropriate response for failure
		}
	}

	public static List<User> getAllUsers() {
		try {
			return UserDAO.getAllUsers();
		} catch (DAOExceptions e) {
			// Handle the exception appropriately (e.g., log it, provide user-friendly error
			// messages)
			e.printStackTrace();
			return null; // Return an appropriate response for failure
		}
	}

	public static User LoginUser(String email, String password) throws DAOExceptions, UserValidateException {

		User users = null;
		if (UserValidator.validateEmail(email)) {
			users = UserDAO.loginUser(email, password);
		}

		return users;
	}
}
