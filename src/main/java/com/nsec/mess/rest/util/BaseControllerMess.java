package com.nsec.mess.rest.util;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nsec.mess.exception.ErrorMessage;

@Component
public class BaseControllerMess {

	public ResponseEntity<?> getResponse(Exception exception, String friendlyErrorMessage, Logger logger) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.copy(logger, exception, friendlyErrorMessage, false);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}
	
	public ResponseEntity<?> getResponse(HttpStatus status, Exception exception, String friendlyErrorMessage, Logger logger) {
		ErrorMessage errorMessage = new ErrorMessage(status.value(), exception.getLocalizedMessage());
		errorMessage.copy(logger, exception, friendlyErrorMessage, false);
		
		return ResponseEntity.status(status).body(errorMessage);
	}
	
}
