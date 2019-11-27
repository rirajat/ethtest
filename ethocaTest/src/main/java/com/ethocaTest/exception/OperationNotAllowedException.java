package com.ethocaTest.exception;

public class OperationNotAllowedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperationNotAllowedException() {
		super();
	}

	public OperationNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationNotAllowedException(String message) {
		super(message);
	}

	public OperationNotAllowedException(Throwable cause) {
		super(cause);
	}
}
