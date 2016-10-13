package com.kitchen.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public void handle(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
		log.info("Exception Occured:: URL=" + request.getRequestURL());
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		response.getOutputStream().println("{ \"error\": \"" + ex.getMessage() + "\" }");
		ex.printStackTrace();
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public void handleDuplicateKeyException(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws IOException {
		log.info("Exception Occured:: URL=" + request.getRequestURL());
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_CONFLICT);
		response.getOutputStream().println("{ \"error\": \"exception.duplicateKey\" }");
		ex.printStackTrace();
	}
}
