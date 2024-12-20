package com.Blog.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Blog.exceptions.PostNotFoundException;

@RestControllerAdvice
public class BloggerControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<Errors> handlePostNotFoundeException(PostNotFoundException ex){
		
		Errors er = new Errors("404 Not Found",LocalDateTime.now() ,ex.getMessage());
		
		return new ResponseEntity<Errors>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<Errors> handleBasicExceptions(Exception e){
		
		Errors er = new Errors("Internal Server Error", LocalDateTime.now(), e.getMessage());
		
		return new ResponseEntity<Errors>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
