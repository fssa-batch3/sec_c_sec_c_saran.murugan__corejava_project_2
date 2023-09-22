package com.fssa.movie.Validator;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.model.*;
import com.fssa.movie.validatorException.MovieValidateException;
import com.fssa.movie.validatorException.MovieValidatorErrors;
import com.fssa.movie.validatorException.UserValidateException;
import com.fssa.movie.validatorException.UserValidatorErrors;

public class TestUserValidator {

	@Test
	void testUserValidate() throws UserValidateException {
        User mv = new User("saran","saran@gmail.com","Saran@123","7258516714");
		Assertions.assertTrue(UserValidator.validateUser(mv));

	}
	
	@Test
	  void testValidUserName() throws UserValidateException{
		Assertions.assertTrue( UserValidator.validateUsername("Saran"));
	}
	
	 
	@Test
	 void testNullUserName() throws UserValidateException {
		try {
			UserValidator.validateUsername(null);
			Assertions.fail("Validatename failed");
		} catch (UserValidateException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USERNAME, ex.getMessage());
		}
	}
	
	@Test
   void testEmptyUserName() throws UserValidateException{
  	try {
			UserValidator.validateUsername("");
			Assertions.fail("Validatename failed");
		} catch (UserValidateException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USERNAME, ex.getMessage());
		}
  }
	
	@Test
   void testLengthUserName() throws UserValidateException{
  	try {
			UserValidator.validateUsername("y");
			Assertions.fail("Validatename failed");
		} catch (UserValidateException ex) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_USERNAME, ex.getMessage());
		}
  }

	@Test
	void testValidateEmail() throws UserValidateException {
		Assertions.assertTrue(UserValidator.validateEmail("Saran@gmail.com"));
	}

	@Test
	void testNullValidateEmail() {
		try {
		UserValidator.validateEmail(null);
		} catch (UserValidateException e) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_EMAIL, e.getMessage());
		}
	}

	@Test
	void testEmptyValidateEmail() {
		try {
			UserValidator.validateEmail("");
		} catch (UserValidateException e) {
			Assertions.assertEquals(UserValidatorErrors.INVALID_EMAIL, e.getMessage());
		}
	}





	    
	    @Test
	    void testValidPassword() {
	        try {
	            Assertions.assertTrue(UserValidator.validatePassword("Saran123"));
	        } catch (UserValidateException ex) {
	            Assertions.fail("ValidatePassword failed");
	        }
	    }

	    @Test
	    void testShortPassword() {
	        try {
	            UserValidator.validatePassword("abc12");
	            Assertions.fail("ValidatePassword failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_PASSWORD, ex.getMessage());
	        }
	    }

	    @Test
	    void testNullPassword() {
	        try {
	            UserValidator.validatePassword(null);
	            Assertions.fail("ValidatePassword failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_PASSWORD, ex.getMessage());
	        }
	    }

	    @Test
	    void testLengthPassword() {
	        try {
	            UserValidator.validatePassword("Saran");
	            Assertions.fail("ValidatePassword failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_PASSWORD, ex.getMessage());
	        }
	    }
	    
	    @Test
	    void testValidNumber() {
	        try {
	            Assertions.assertTrue(UserValidator.validateNumber("1234567890"));
	        } catch (UserValidateException ex) {
	            Assertions.fail("ValidateNumber failed");
	        }
	    }

	    @Test
	    void testInvalidNumber() {
	        try {
	            UserValidator.validateNumber("abc123");
	            Assertions.fail("ValidateNumber failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_NUMBER, ex.getMessage());
	        }
	    }

	    @Test
	    void testNullNumber() {
	        try {
	            UserValidator.validateNumber(null);
	            Assertions.fail("ValidateNumber failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_NUMBER, ex.getMessage());
	        }
	    }
	    
	    @Test
	    void testValidUserId() {
	        try {
	            Assertions.assertTrue(UserValidator.validateUserId(1));
	        } catch (UserValidateException ex) {
	            Assertions.fail("ValidateUserId failed");
	        }
	    }

	    @Test
	    void testInvalidUserIdZero() {
	        try {
	            UserValidator.validateUserId(0);
	            Assertions.fail("ValidateUserId failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_USER_ID, ex.getMessage());
	        }
	    }

	    @Test
	    void testInvalidUserIdNegative() {
	        try {
	            UserValidator.validateUserId(-1);
	            Assertions.fail("ValidateUserId failed");
	        } catch (UserValidateException ex) {
	            Assertions.assertEquals(UserValidatorErrors.INVALID_USER_ID, ex.getMessage());
	        }
	    }
	    
	    


	
	
}
