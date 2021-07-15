package com.nsec.mess.rest.util;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nsec.mess.exception.ErrorMessage;

@Component
public class BaseControllerMess {

	public ResponseEntity<?> getResponse(Logger logger, Exception exception, String friendlyErrorMessage) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.copy(logger, exception, friendlyErrorMessage, false);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}
	
}
