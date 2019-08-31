package com.bjsxt.exception;

public class UsersException extends RuntimeException {

	public UsersException() {

	}
	public UsersException(String msg) {
		super(msg);
	}

	public UsersException(String msg, Throwable t) {
		super(msg, t);
	}
}
