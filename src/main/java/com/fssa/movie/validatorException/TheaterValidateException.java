package com.fssa.movie.validatorException;

public class TheaterValidateException  extends Exception{

	private static final long serialVersionUID = -8105491977357554060L;

	public TheaterValidateException(String msg) {

		super(msg);
	}

	public TheaterValidateException(Throwable te) {
		super(te);
	}

	public TheaterValidateException(String msg, Throwable te) {

		super(msg, te);
	}

}
