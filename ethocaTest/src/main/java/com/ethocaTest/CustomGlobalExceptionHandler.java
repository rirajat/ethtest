package com.ethocaTest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@ExceptionHandler(NullPointerException.class)
    public void nullPointer(HttpServletResponse response, Exception ex) throws IOException {
		logger.error("Null Pointer Exception",ex);
		response.sendError(HttpStatus.BAD_REQUEST.value());
    }
	
	@ExceptionHandler(SQLException.class)
    public void sqlException(HttpServletResponse response, Exception ex) throws IOException {
		logger.error("SQL Exception",ex);
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
	
	@ExceptionHandler(Exception.class)
    public void http500(HttpServletResponse response, Exception ex) throws IOException {
		logger.error("ERROR:",ex);
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
