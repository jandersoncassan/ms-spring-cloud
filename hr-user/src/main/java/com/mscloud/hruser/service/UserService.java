package com.mscloud.hruser.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscloud.hruser.dto.UserDTO;
import com.mscloud.hruser.entities.User;
import com.mscloud.hruser.exception.UserNotFoundException;
import com.mscloud.hruser.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll(){
		return userRepository.findAll().stream().map(UserDTO::converter).collect(Collectors.toList());
	}

	public UserDTO findById(final Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return UserDTO.converter(user.get());
		
		throw new UserNotFoundException("User id:".concat(id.toString()).concat(" not found"));
	}

	public UserDTO findByEmail(final String email) {
		User user = userRepository.findByEmail(email);
		if(Optional.ofNullable(user).isPresent())
			return UserDTO.converter(user);
		
		throw new UserNotFoundException("User email:".concat(email).concat(" not found"));
	}

}