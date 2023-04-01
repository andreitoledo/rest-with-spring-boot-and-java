package com.andreitoledo.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.andreitoledo.erudio.exceptions.ExceptionResponse;
import com.andreitoledo.erudio.exceptions.UnsupportedMathOperationException;

// Anotação para concentrar todos os tratamentos espalhados no controle
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
/*
 * Para tratar as exceções mais genéricas do java: 500, etc...
 * */	

	// Anotação que filtra e trata a exceção mais genérica do java. (exception.class)
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex, WebRequest request){
		// retorna a exceção customizada
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), 
				ex.getMessage(),			
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	// Tratamento de exceção específica
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request){
		// retorna a exceção customizada
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), 
				ex.getMessage(),			
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
