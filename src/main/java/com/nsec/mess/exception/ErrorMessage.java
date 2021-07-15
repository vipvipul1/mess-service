package com.nsec.mess.exception;

import org.slf4j.Logger;

import com.nsec.mess.util.MessConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
	private int statusCode;
	private StackTraceElement[] errorMessages;
	private String friendlyMessage;
	private String friendlyErrorMessage;
	private boolean isDeveloper;
	private StackTraceElement[] nestedErrorMessages;
	private String errorCause;
	
	public ErrorMessage() {
		this.statusCode = 500;
		this.friendlyMessage = MessConstants.ERROR_MESSAGE;
	}
	
	public void copy(Logger logger, Exception exception, String friendlyErrorMessage, boolean isDeveloper) {
		this.statusCode = 500;
		this.errorMessages = exception.getStackTrace();
		this.friendlyErrorMessage = friendlyErrorMessage;
		this.isDeveloper = isDeveloper;
		this.nestedErrorMessages = exception.getCause() != null ? exception.getCause().getStackTrace() : null;
		this.errorCause = exception.getMessage();
	}
}
