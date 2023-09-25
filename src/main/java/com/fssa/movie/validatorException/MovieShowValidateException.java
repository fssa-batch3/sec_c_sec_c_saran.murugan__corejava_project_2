package com.fssa.movie.validatorException;

public class MovieShowValidateException extends Exception {

	private static final long serialVersionUID = -8105491977357554060L;

	public MovieShowValidateException(String msg) {

		super(msg);
	}

	public MovieShowValidateException(Throwable te) {
		super(te);
	}

	public MovieShowValidateException(String msg, Throwable te) {

		super(msg, te);
	}
}
