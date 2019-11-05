package com.furb.prog3.trab3.util;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

	private List<String> errors = new ArrayList<>();

	public ErrorResponse() {
	}

	public ErrorResponse(String error) {
		addError(error);
	}

	public List<String> getErrors() {
		return errors;
	}

	public void addError(String error) {
		errors.add(error);
	}

}
