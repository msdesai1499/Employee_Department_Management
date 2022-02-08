package io.javabrains.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e){
		
	HttpStatus st=HttpStatus.BAD_REQUEST;	
	ApiException apiException=new ApiException(e.getMessage(), e, st, ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity<>(apiException,st);
	}
	
}
