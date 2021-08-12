package com.mscloud.oauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mscloud.oauth.dto.UserDTO;
import com.mscloud.oauth.exception.UserNotFoundException;
import com.mscloud.oauth.feignclients.UserFeignCient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OauthUserService {

	@Autowired
	private UserFeignCient userFeignclient;
	
	public UserDTO findByEmail(final String email) {
		log.info("OAUTH findByEmail {}", email);
		ResponseEntity<UserDTO> responseUser = userFeignclient.findByEmail(email);
		if(responseUser.getStatusCode().is2xxSuccessful()) 
			return responseUser.getBody();
		
		log.info("OAUTH findByEmail {} - {}", email, "Not Found");
		throw new UserNotFoundException("User email: ".concat(email).concat(" not found"));
	}
}
