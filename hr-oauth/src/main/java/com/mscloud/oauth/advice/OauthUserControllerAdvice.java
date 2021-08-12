package com.mscloud.oauth.advice;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mscloud.oauth.dto.ErrorDTO;
import com.mscloud.oauth.exception.UserNotFoundException;

import feign.FeignException;

@RestControllerAdvice
public class OauthUserControllerAdvice {

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
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(FeignException.class)
    public ErrorDTO handleFeignStatusException(FeignException e, HttpServletResponse response) {
		return ErrorDTO.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.message(e.getMessage())
				.timestamp(new Date())
				.build();
    }

}
