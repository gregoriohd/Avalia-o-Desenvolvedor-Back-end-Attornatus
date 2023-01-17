package br.com.gregoriohd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoudException.class)
	public ResponseEntity<?> handleResourceNotFoudException(ResourceNotFoudException ex){
		ErrorMessage errorMessage = new ErrorMessage("NOT FOUND", HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

}
