package com.furb.prog3.trab3.rule;

import com.furb.prog3.trab3.util.ErrorResponse;

public abstract class BaseRule {

	private ErrorResponse errorResponse = new ErrorResponse();

	protected void addError(String error) {
		errorResponse.addError(error);
	}

	/**
	 * Valida a rule conforme a abstração.
	 * 
	 * @return
	 */
	protected abstract boolean validate();

}
