package com.fssa.movie.Validator;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.movie.model.Movie;
import com.fssa.movie.model.MovieCertificate;
import com.fssa.movie.model.MovieFormat;
import com.fssa.movie.model.MovieGenre;
import com.fssa.movie.model.MovieLanguage;
import com.fssa.movie.model.MovieStatus;
import com.fssa.movie.validatorException.MovieValidateException;
import com.fssa.movie.validatorException.MovieValidatorErrors;



 class TestMovieValidator { 

			
   @Test
    void testMovievalidate() throws MovieValidateException{
	   Movie mv = new Movie( "leoBloodysweet",MovieLanguage.ENGLISH,MovieFormat.FORMAT_2D,MovieCertificate.UNIVERSAL_ADULT,MovieGenre.ACTION,150,"this movie name is leo this about action movie", LocalDate.of(2023, 7, 21),"https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg","https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg",MovieStatus.UPCOMING);
	  Assertions.assertTrue(MovieValidator.validate(mv));
   }
	
	@Test
	  void testValidName() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateName("CaptainMiller"));
	}
	
	 
	@Test
	 void testNullName() throws MovieValidateException {
		try {
			MovieValidator.validateName(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_NAME, ex.getMessage());
		}
	}
	
	@Test
     void testEmptyName() throws MovieValidateException{
    	try {
			MovieValidator.validateName("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_NAME, ex.getMessage());
		}
    }
	
	@Test
     void testLengthName() throws MovieValidateException{
    	try {
			MovieValidator.validateName("y");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_NAME, ex.getMessage());
		}
    }
	
		
	@Test
	  void testvalidateDescription() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateDescription("Captain Miller is a Tamil movie starring Dhanush in a prominent role. It is written and directed by Arun Matheswaran."
				+ ""));
	}
	
	 
	@Test
	 void testNullDescription() throws MovieValidateException {
		try {
			MovieValidator.validateDescription(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION, ex.getMessage());
		}
	}
	
	@Test
     void testEmptyDescription() throws MovieValidateException{
    	try {
			MovieValidator.validateDescription("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION, ex.getMessage());
		}
    }
	
	@Test
     void testLengthDescription() throws MovieValidateException{
    	try {
			MovieValidator.validateDescription("y");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DESCRIPTION, ex.getMessage());
		}
    }
	 
	
	@Test
	  void testvalidateDurationMinutes() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateDurationMinutes(59));
	}
	
	 
	@Test
	 void testInvalidDurationMinutes() throws MovieValidateException {
		try {
			MovieValidator.validateDurationMinutes(60);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_DURATION_MINUTES, ex.getMessage());
		}
	}
	

	
	@Test
	  void testvalidateReleaseDate() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateReleaseDate(LocalDate.of(2023, 7, 21)));
	}
	
	 
	@Test
	 void testInvalidReleaseDate() throws MovieValidateException {
		try {
			MovieValidator.validateReleaseDate(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_RELEASE_DATE, ex.getMessage());
		}
	}

	@Test
	  void testvalidateMovieImage() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateMovieImage("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg"));
	}
	
	@Test
	 void testNullMovieImage() throws MovieValidateException {
		try {
			MovieValidator.validateMovieImage(null);
			Assertions.fail("testNullMovieImage method failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_IMAGE, ex.getMessage());
		}
	}
	
	@Test
     void testEmptyMovieImage() throws MovieValidateException{
    	try {
			MovieValidator.validateMovieImage("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_IMAGE, ex.getMessage());
		}
    }
	
	@Test
     void testInvalidMovieImage() throws MovieValidateException{
    	try {
			MovieValidator.validateMovieImage("00348725-1680776467");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_IMAGE, ex.getMessage());
		}
    }

	    
	@Test
	  void testvalidateMovieBanner() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateMovieBanner("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/ponniyin-selvan--part-2-et00348725-1680776467.jpg"));
	}
	
	@Test
	 void testNullMovieBanner() throws MovieValidateException {
		try {
			MovieValidator.validateMovieBanner(null);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_BANNER, ex.getMessage());
		}
	}
	
	@Test
     void testEmptyMovieBanner() throws MovieValidateException{
    	try {
			MovieValidator.validateMovieBanner("");
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_BANNER, ex.getMessage());
		}
    }
	
	@Test
	  void testInvalidateMovieBanner() throws MovieValidateException{
		try {
			MovieValidator.validateMovieBanner("1680776467");
		}
		catch(MovieValidateException ab) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_BANNER ,ab.getMessage());
		}
	}

	
	
	@Test
	  void testvalidateMovieId() throws MovieValidateException{
		Assertions.assertTrue( MovieValidator.validateMovieId(59));
	}
	
	 
	@Test
	 void testInvalidMovieId() throws MovieValidateException {
		try {
			MovieValidator.validateMovieId(0);
			Assertions.fail("Validatename failed");
		} catch (MovieValidateException ex) {
			Assertions.assertEquals(MovieValidatorErrors.INVALID_MOVIE_ID, ex.getMessage());
		}
	}
	
		
}
