package com.nsec.mess.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends Exception {

	private static final long serialVersionUID = -7049116225045314538L;
	
	private String exceptionMessage;
	
	public AppException() {
		super();
	}
	
	public AppException(String message) {
		super(message);
		exceptionMessage = message;
	}
	
	public AppException(String message, Throwable cause) {
		super(message, cause);
		exceptionMessage = message;
	}

}
