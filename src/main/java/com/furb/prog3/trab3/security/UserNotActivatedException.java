package com.furb.prog3.trab3.security;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class UserNotActivatedException extends AuthenticationException {

	public UserNotActivatedException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserNotActivatedException(String msg) {
		super(msg);
	}

}
