package com.fssa.movie.validatorException;

public class UserValidateException extends Exception {

	
	private static final long serialVersionUID = -8105491977357554060L;

	public UserValidateException(String msg) {

		super(msg);
	}

	public UserValidateException(Throwable te) {
		super(te);
	}

	public UserValidateException(String msg, Throwable te) {

		super(msg, te);
	}


}
