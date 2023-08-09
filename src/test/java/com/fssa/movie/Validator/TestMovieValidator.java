package com.fssa.movie.Validator;

import java.time.LocalDate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.model.Movie;
import com.fssa.movie.validatorException.MovieValidateException;
import com.fssa.movie.validatorException.MovieValidatorErrors;



public class TestMovieValidator { 

//	Movie movie = new Movie(0,null, null, null, null, null, 0, 0, 0, null, null,null,null);
			
			
   @Test
   public void testMovievalidate() throws MovieValidateException{
	   Movie mv = new Movie(2,"leoBloodysweet", "Tamil", "IMAX", "UA", "Action", 10, 20, 10, "this movie name is leo this about action movie", LocalDate.of(2023, 7, 21),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg","https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg");
	  Assertions.assertTrue(MovieValidator.validate(mv));
   }
	
	@Test
	public  void testValidName() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateName("CaptainMiller"));
	}
	
	 
	@Test
	public void testNullName() throws MovieValidateException {
		try {
			MovieValidator.validateName(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_NAME, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyName() throws MovieValidateException{
    	try {
			MovieValidator.validateName("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_NAME, ex.getMessage());
		}
    }
	
	@Test
    public void testLengthName() throws MovieValidateException{
    	try {
			MovieValidator.validateName("y");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_NAME, ex.getMessage());
		}
    }
	
	
	@Test
	public  void testvalidLanguage() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateLanguage("Tamil"));
	}
	
	@Test
	public void testNullLanguage() throws MovieValidateException {
		try {
			MovieValidator.validateLanguage(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_LANGUAGE, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyLanguage() throws MovieValidateException{
    	try {
			MovieValidator.validateLanguage("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_LANGUAGE, ex.getMessage());
		}
    }
	
	@Test
    public void testLengthLanguage() throws MovieValidateException{
    	try {
			MovieValidator.validateLanguage("y");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_LANGUAGE, ex.getMessage());
		}
    }
	 

	@Test
	public  void testvalidateFormat() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateFormat("2D"));
	}
	
	 
	@Test
	public void testNullFormat() throws MovieValidateException {
		try {
			MovieValidator.validateFormat(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_FORMAT, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyFormat() throws MovieValidateException{
    	try {
			MovieValidator.validateFormat("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_FORMAT, ex.getMessage());
		}
    }
	
	@Test
    public void testLengthFormat() throws MovieValidateException{
    	try {
			MovieValidator.validateFormat("D");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_FORMAT, ex.getMessage());
		}
    }
	 
	@Test
    public void testUpperCaseFormat() throws MovieValidateException{
    	try {
			MovieValidator.validateFormat("2d");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_FORMAT, ex.getMessage());
		}
    }


	@Test
	public  void testvalidateCertificate() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateCertificate("UA"));
	}
	
	@Test
	public void testNullCertificate() throws MovieValidateException {
		try {
			MovieValidator.validateCertificate(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_CERTIFICATE, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyCertificate() throws MovieValidateException{
    	try {
			MovieValidator.validateCertificate("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_CERTIFICATE, ex.getMessage());
		}
    }
		
	@Test
    public void testUpperCaseCertificate() throws MovieValidateException{
    	try {
			MovieValidator.validateCertificate("Ua");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_CERTIFICATE, ex.getMessage());
		}
    }



	@Test
	public  void testvalidateGenre() throws MovieValidateException{
		Assertions.assertTrue(MovieValidator.validateGenre("Action,thriller"));
	}
	
	 
	@Test
	public void testNullGenre() throws MovieValidateException {
		try {
			MovieValidator.validateGenre(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_GENRE, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyGenre() throws MovieValidateException{
    	try {
			MovieValidator.validateGenre("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_GENRE, ex.getMessage());
		}
    }
	
	@Test
    public void testLengthGenre() throws MovieValidateException{
    	try {
			MovieValidator.validateGenre("ac");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_GENRE, ex.getMessage());
		}
    }
	 

	
	@Test
	public  void testvalidateDescription() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateDescription("Captain Miller is a Tamil movie starring Dhanush in a prominent role. It is written and directed by Arun Matheswaran."
				+ ""));
	}
	
	 
	@Test
	public void testNullDescription() throws MovieValidateException {
		try {
			MovieValidator.validateDescription(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyDescription() throws MovieValidateException{
    	try {
			MovieValidator.validateDescription("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION, ex.getMessage());
		}
    }
	
	@Test
    public void testLengthDescription() throws MovieValidateException{
    	try {
			MovieValidator.validateDescription("y");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION, ex.getMessage());
		}
    }
	 
	
	@Test
	public  void testvalidateDurationHours() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateDurationHours(10));
	}
	
	 
	@Test
	public void testInvalidDurationHours() throws MovieValidateException {
		try {
			MovieValidator.validateDurationHours(0);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DURATION_HOURS, ex.getMessage());
		}
	}


	@Test
	public  void testvalidateDurationMinutes() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateDurationMinutes(59));
	}
	
	 
	@Test
	public void testInvalidDurationMinutes() throws MovieValidateException {
		try {
			MovieValidator.validateDurationMinutes(60);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DURATION_MINUTES, ex.getMessage());
		}
	}
	


	@Test
	public  void testvalidateDurationSeconds() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateDurationSeconds(59));
	}
	 
	@Test
	public void testInvalidDurationSeconds() throws MovieValidateException {
		try {
			MovieValidator.validateDurationSeconds(60);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DURATION_SECONDS, ex.getMessage());
		}
	}
	
	@Test
	public  void testvalidateReleaseDate() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateReleaseDate(LocalDate.of(2023, 7, 21)));
	}
	
	 
	@Test
	public void testInvalidReleaseDate() throws MovieValidateException {
		try {
			MovieValidator.validateReleaseDate(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_RELEASE_DATE, ex.getMessage());
		}
	}

	@Test
	public  void testvalidateMovieImage() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateMovieImage("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg"));
	}
	
	@Test
	public void testNullMovieImage() throws MovieValidateException {
		try {
			MovieValidator.validateMovieImage(null);
			Assertions.fail("testNullMovieImage method failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_IMAGE, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyMovieImage() throws MovieValidateException{
    	try {
			MovieValidator.validateMovieImage("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_IMAGE, ex.getMessage());
		}
    }
	
	@Test
    public void testInvalidMovieImage() throws MovieValidateException{
    	try {
			MovieValidator.validateMovieImage("00348725-1680776467");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_IMAGE, ex.getMessage());
		}
    }

	    
	@Test
	public  void testvalidateMovieBanner() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateMovieBanner("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg"));
	}
	
	@Test
	public void testNullMovieBanner() throws MovieValidateException {
		try {
			MovieValidator.validateMovieBanner(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_BANNER, ex.getMessage());
		}
	}
	
	@Test
    public void testEmptyMovieBanner() throws MovieValidateException{
    	try {
			MovieValidator.validateMovieBanner("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_BANNER, ex.getMessage());
		}
    }
	
	@Test
	public  void testInvalidateMovieBanner() throws MovieValidateException{
		try {
			MovieValidator.validateMovieBanner("1680776467");
		}
		catch(MovieValidateException ab) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_BANNER ,ab.getMessage());
		}
	}

	
	
	@Test
	public  void testvalidateMovieId() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateMovieId(59));
	}
	
	 
	@Test
	public void testInvalidMovieId() throws MovieValidateException {
		try {
			MovieValidator.validateMovieId(0);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_ID, ex.getMessage());
		}
	}
	
		
}
