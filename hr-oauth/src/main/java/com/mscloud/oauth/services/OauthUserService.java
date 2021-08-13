package com.mscloud.oauth.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mscloud.oauth.entities.User;
import com.mscloud.oauth.exception.UserNotFoundException;
import com.mscloud.oauth.feignclients.UserFeignCient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OauthUserService implements UserDetailsService{

	@Autowired
	private UserFeignCient userFeignclient;
	
	public User findByEmail(final String email) {
		log.info("OAUTH findByEmail {}", email);
		ResponseEntity<User> responseUser = userFeignclient.findByEmail(email);
		if(responseUser.getStatusCode().is2xxSuccessful()) 
			return responseUser.getBody();
		
		log.info("OAUTH findByEmail {} - {}", email, "Not Found");
		throw new UserNotFoundException("User email: ".concat(email).concat(" not found"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("OAUTH findByEmail {}", username);
		User user = userFeignclient.findByEmail(username).getBody();
		if(Objects.isNull(user)) {
			log.info("OAUTH findByEmail {} - {}", username, "Not Found");
			throw new UsernameNotFoundException("User not found");
		}
		return user;		
	}
}
