package com.mscloud.hruser.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mscloud.hruser.dto.ErrorDTO;
import com.mscloud.hruser.exception.UserNotFoundException;

@RestControllerAdvice
public class UserControllerAdvice {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
			
		return ErrorDTO.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.message(userNotFoundException.getMessage())
				.timestamp(new Date())
				.build();
	}
}
