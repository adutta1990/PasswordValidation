package com.example.pwdval.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CentralExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(CentralExceptionHandler.class);

	private static final String STATUS = "status";
	private static final String ERROR = "error";
	private static final String DATA = "data";

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {

		Map<String, Object> responseMap = new HashMap<String, Object>();
		logger.error("Error : {}", ex);
		if (ex instanceof BadRequestException) {
			responseMap.put(STATUS, HttpStatus.BAD_REQUEST.value());
			responseMap.put(ERROR, ex.getMessage());
			responseMap.put(DATA, ((BadRequestException) ex).getData());
			return new ResponseEntity<>(responseMap, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		} else if (ex instanceof MandatoryParamException) {
			responseMap.put(STATUS, HttpStatus.BAD_REQUEST.value());
			responseMap.put(ERROR, ex.getMessage());
			responseMap.put(DATA, ((MandatoryParamException) ex).getData());
			return new ResponseEntity<>(responseMap, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		} else if (ex instanceof ResourceFormatException) {
			responseMap.put(STATUS, HttpStatus.BAD_REQUEST.value());
			responseMap.put(ERROR, ex.getMessage());
			responseMap.put(DATA, ((ResourceFormatException) ex).getData());
			return new ResponseEntity<>(responseMap, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		responseMap.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseMap.put(ERROR, ex.getMessage());
		return new ResponseEntity<>(responseMap, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}