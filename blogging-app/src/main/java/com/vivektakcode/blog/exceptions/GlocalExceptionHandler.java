package com.vivektakcode.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vivektakcode.blog.payload.ApiResponse;

@RestControllerAdvice
public class GlocalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExcptionHandler(ResourceNotFoundException ex){
		String msg= ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(msg, false);
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgsNotValidExcptionHandler(MethodArgumentNotValidException ex){
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((e)->{
			String fieldName=((FieldError)e).getField();
			String message= e.getDefaultMessage();
			map.put(fieldName, message);
		});
		
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
		
		
		
	}
}
