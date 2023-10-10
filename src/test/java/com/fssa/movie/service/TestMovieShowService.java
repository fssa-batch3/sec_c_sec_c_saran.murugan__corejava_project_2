package com.fssa.movie.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.Movie;
import com.fssa.movie.model.MovieShow;
import com.fssa.movie.validatorException.MovieShowValidateException;
import com.fssa.movie.validatorException.MovieValidateException;

public class TestMovieShowService {

	public static MovieShow addNewShow() {

		MovieShow data = new MovieShow(1, 1, LocalTime.of(10, 30), LocalDate.of(2023, 9, 20));

		return data;
	}

	@Test
	public void testAddMovieShowServiceLayer() throws DAOExceptions, MovieShowValidateException {
		Assertions.assertTrue(MovieShowService.createShowTime(addNewShow()));
	}

	@Test
	public void testReadShowsServiceLayer() throws DAOExceptions, MovieValidateException, SQLException {
		List<MovieShow> showList = MovieShowService.readAllShows();
		for (MovieShow movies : showList) {
			CustomLogger.info(movies.getMovieId());
			CustomLogger.info(movies.getShow_id());
			CustomLogger.info(movies.getShowDate());
			CustomLogger.info(movies.getShowTime());
			CustomLogger.info(movies.getTheaterId());
		}
	}

}
